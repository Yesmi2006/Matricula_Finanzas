package pe.edu.upeu.lamb.matricula.service;

import pe.edu.upeu.lamb.matricula.dto.MatriculaRequest;
import pe.edu.upeu.lamb.matricula.dto.MatriculaResponse;
import pe.edu.upeu.lamb.matricula.dto.SeccionDisponibleDto;
import pe.edu.upeu.lamb.matricula.entity.CondicionMatricula;
import pe.edu.upeu.lamb.matricula.entity.DetalleMatricula;
import pe.edu.upeu.lamb.matricula.entity.EstadoMatricula;
import pe.edu.upeu.lamb.matricula.entity.Matricula;
import pe.edu.upeu.lamb.matricula.event.MatriculaConfirmadaEvento;
import pe.edu.upeu.lamb.matricula.exception.BusinessRuleException;
import pe.edu.upeu.lamb.matricula.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.matricula.mapper.MatriculaMapper;
import pe.edu.upeu.lamb.matricula.messaging.MatriculaEventosProducer;
import pe.edu.upeu.lamb.matricula.repository.CondicionMatriculaRepository;
import pe.edu.upeu.lamb.matricula.repository.MatriculaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MatriculaService {

    private static final String MATRICULA_CONFIRMADA = "matricula.confirmada";

    private final MatriculaRepository matriculaRepository;
    private final MatriculaMapper matriculaMapper;
    private final MatriculaEventosProducer producer;
    private final PlanificacionConsultaService planificacionConsultaService;
    private final CondicionMatriculaRepository condicionMatriculaRepository;

    public List<MatriculaResponse> listar() {
        return matriculaRepository.findAll().stream()
                .map(matriculaMapper::toResponse)
                .toList();
    }

    public MatriculaResponse obtener(Long id) {
        return matriculaMapper.toResponse(buscarOFallar(id));
    }

    /**
     * Valida cada seccion contra planificacion antes de registrar (S06: llamada sincrona
     * resiliente). Si planificacion esta caida (fallback), la matricula se registra igual
     * para no propagar el fallo en cascada; solo se rechaza cuando planificacion SI responde
     * y la seccion no esta ABIERTA.
     */
    public MatriculaResponse crear(MatriculaRequest request) {
        Matricula matricula = matriculaMapper.toEntity(request);
        matricula.setEstado(EstadoMatricula.REGISTRADA);
        for (DetalleMatricula detalle : matricula.getDetalles()) {
            SeccionDisponibleDto seccion = planificacionConsultaService.obtenerSeccion(detalle.getIdSeccion());
            if (seccion == null) {
                log.warn("component=client seccionId={} status=no_verificado motivo=\"planificacion no respondio\"",
                        detalle.getIdSeccion());
                continue;
            }
            if (!"ABIERTA".equals(seccion.getEstado())) {
                throw new BusinessRuleException("La seccion " + detalle.getIdSeccion()
                        + " no esta ABIERTA (estado actual: " + seccion.getEstado() + ")");
            }
        }
        return matriculaMapper.toResponse(matriculaRepository.save(matricula));
    }

    /**
     * Idempotente: si ya esta CONFIRMADA no vuelve a procesar ni a publicar el evento
     * (evita generar un cargo duplicado en finanzas si el cliente reintenta la llamada).
     * Solo se confirma desde REGISTRADA.
     */
    @Transactional
    public MatriculaResponse confirmar(Long id) {
        Matricula matricula = buscarOFallar(id);
        if (matricula.getEstado() == EstadoMatricula.CONFIRMADA) {
            log.warn("component=processor matriculaId={} status=ignored motivo=\"ya estaba confirmada\"", id);
            return matriculaMapper.toResponse(matricula);
        }
        validarEstado(matricula, EstadoMatricula.REGISTRADA, "confirmar");
        matricula.setEstado(EstadoMatricula.CONFIRMADA);
        Matricula guardada = matriculaRepository.save(matricula);

        producer.publicarTrasCommit(MatriculaConfirmadaEvento.builder()
                .tipoEvento(MATRICULA_CONFIRMADA)
                .matriculaId(guardada.getId())
                .idPersona(guardada.getIdPersona())
                .periodo(guardada.getPeriodo())
                .timestamp(Instant.now().toEpochMilli())
                .build());
        log.info("component=processor matriculaId={} idPersona={} estado={} status=processed",
                guardada.getId(), guardada.getIdPersona(), guardada.getEstado());
        return matriculaMapper.toResponse(guardada);
    }

    public MatriculaResponse anular(Long id) {
        Matricula matricula = buscarOFallar(id);
        if (matricula.getEstado() == EstadoMatricula.ANULADA) {
            log.warn("component=processor matriculaId={} status=ignored motivo=\"ya estaba anulada\"", id);
            return matriculaMapper.toResponse(matricula);
        }
        matricula.setEstado(EstadoMatricula.ANULADA);
        return matriculaMapper.toResponse(matriculaRepository.save(matricula));
    }

    /**
     * Asocia una CondicionMatricula (ingresante, reingresante, repitente, traslado)
     * a la matricula. Relacion muchos a muchos real via tabla matricula_condicion.
     */
    public MatriculaResponse agregarCondicion(Long id, Long idCondicion) {
        Matricula matricula = buscarOFallar(id);
        CondicionMatricula condicion = condicionMatriculaRepository.findById(idCondicion)
                .orElseThrow(() -> new ResourceNotFoundException("CondicionMatricula no encontrada: " + idCondicion));
        if (!matricula.getCondiciones().contains(condicion)) {
            matricula.getCondiciones().add(condicion);
        }
        return matriculaMapper.toResponse(matriculaRepository.save(matricula));
    }

    public MatriculaResponse quitarCondicion(Long id, Long idCondicion) {
        Matricula matricula = buscarOFallar(id);
        matricula.getCondiciones().removeIf(c -> c.getId().equals(idCondicion));
        return matriculaMapper.toResponse(matriculaRepository.save(matricula));
    }

    private void validarEstado(Matricula matricula, EstadoMatricula esperado, String accion) {
        if (matricula.getEstado() != esperado) {
            throw new BusinessRuleException("No se puede " + accion + " la matricula " + matricula.getId()
                    + ": esta en estado " + matricula.getEstado() + ", se esperaba " + esperado);
        }
    }

    private Matricula buscarOFallar(Long id) {
        return matriculaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Matricula no encontrada: " + id));
    }
}
