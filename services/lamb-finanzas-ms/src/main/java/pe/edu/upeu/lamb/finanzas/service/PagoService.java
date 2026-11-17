package pe.edu.upeu.lamb.finanzas.service;

import pe.edu.upeu.lamb.finanzas.dto.PagoRequest;
import pe.edu.upeu.lamb.finanzas.dto.PagoResponse;
import pe.edu.upeu.lamb.finanzas.entity.EstadoPago;
import pe.edu.upeu.lamb.finanzas.entity.Pago;
import pe.edu.upeu.lamb.finanzas.event.MatriculaConfirmadaEvento;
import pe.edu.upeu.lamb.finanzas.event.PagoAceptadoEvento;
import pe.edu.upeu.lamb.finanzas.exception.BusinessRuleException;
import pe.edu.upeu.lamb.finanzas.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.finanzas.mapper.PagoMapper;
import pe.edu.upeu.lamb.finanzas.messaging.PagoEventosProducer;
import pe.edu.upeu.lamb.finanzas.repository.PagoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class PagoService {

    // Placeholder: el costo real por periodo lo calcula Core academico (Curriculo/Planificacion).
    // Aqui se deja fijo porque el flujo de costo real aun no esta integrado con finanzas.
    private static final BigDecimal MONTO_MATRICULA_PLACEHOLDER = new BigDecimal("350.00");

    private final PagoRepository pagoRepository;
    private final PagoMapper pagoMapper;
    private final PagoEventosProducer pagoEventosProducer;

    /**
     * Idempotente por matriculaId: si el evento matricula.confirmada se reentrega, no genera
     * un segundo cargo (constraint unica en matricula_id respalda esto a nivel de BD tambien).
     */
    @Transactional
    public void generarCargoDeMatricula(MatriculaConfirmadaEvento evento) {
        if (pagoRepository.findByMatriculaId(evento.getMatriculaId()).isPresent()) {
            log.warn("component=processor matriculaId={} status=ignored motivo=\"cargo ya generado\"",
                    evento.getMatriculaId());
            return;
        }
        Pago pago = Pago.builder()
                .idPersona(evento.getIdPersona())
                .matriculaId(evento.getMatriculaId())
                .concepto("Matricula " + evento.getPeriodo())
                .monto(MONTO_MATRICULA_PLACEHOLDER)
                .estado(EstadoPago.PENDIENTE)
                .fechaPago(Instant.now())
                .build();
        Pago guardado = pagoRepository.save(pago);
        log.info("component=processor matriculaId={} idPersona={} pagoId={} estado={} status=processed",
                evento.getMatriculaId(), evento.getIdPersona(), guardado.getId(), guardado.getEstado());
    }

    public List<PagoResponse> listar(Long idPersonaSolicitante, boolean privilegiado) {
        List<Pago> pagos = privilegiado
                ? pagoRepository.findAll()
                : pagoRepository.findByIdPersona(idPersonaSolicitante);
        return pagos.stream().map(pagoMapper::toResponse).toList();
    }

    public PagoResponse obtener(Long id, Long idPersonaSolicitante, boolean privilegiado) {
        Pago pago = buscarOFallar(id);
        if (!privilegiado && !pago.getIdPersona().equals(idPersonaSolicitante)) {
            throw new ResourceNotFoundException("Pago no encontrado: " + id);
        }
        return pagoMapper.toResponse(pago);
    }

    /**
     * El estudiante registra el pago (voucher) pero queda EN_PROCESO hasta que
     * ADMIN/COORDINADOR lo valide con aceptar()/rechazar() (saga paga-antes-de-confirmar).
     */
    public PagoResponse procesar(PagoRequest request) {
        Pago pago = pagoMapper.toEntity(request);
        pago.setEstado(EstadoPago.EN_PROCESO);
        pago.setReferenciaExterna(UUID.randomUUID().toString());
        return pagoMapper.toResponse(pagoRepository.save(pago));
    }

    @Transactional
    public PagoResponse aceptar(Long id) {
        Pago pago = buscarOFallar(id);
        validarEstado(pago, EstadoPago.EN_PROCESO, "aceptar");
        pago.setEstado(EstadoPago.APROBADO);
        Pago guardado = pagoRepository.save(pago);
        pagoEventosProducer.publicarTrasCommit(PagoAceptadoEvento.builder()
                .tipoEvento("pago.aceptado")
                .idPago(guardado.getId())
                .matriculaId(guardado.getMatriculaId())
                .idPersona(guardado.getIdPersona())
                .monto(guardado.getMonto())
                .fechaAceptacion(Instant.now())
                .build());
        return pagoMapper.toResponse(guardado);
    }

    public PagoResponse rechazar(Long id) {
        Pago pago = buscarOFallar(id);
        validarEstado(pago, EstadoPago.EN_PROCESO, "rechazar");
        pago.setEstado(EstadoPago.RECHAZADO);
        return pagoMapper.toResponse(pagoRepository.save(pago));
    }

    public PagoResponse reembolsar(Long id) {
        Pago pago = buscarOFallar(id);
        validarEstado(pago, EstadoPago.APROBADO, "reembolsar");
        pago.setEstado(EstadoPago.REEMBOLSADO);
        return pagoMapper.toResponse(pagoRepository.save(pago));
    }

    private void validarEstado(Pago pago, EstadoPago esperado, String accion) {
        if (pago.getEstado() != esperado) {
            throw new BusinessRuleException("No se puede " + accion + " el pago " + pago.getId()
                    + ": esta en estado " + pago.getEstado() + ", se esperaba " + esperado);
        }
    }

    private Pago buscarOFallar(Long id) {
        return pagoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pago no encontrado: " + id));
    }
}
