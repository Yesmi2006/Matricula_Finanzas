package pe.edu.upeu.lamb.finanzas.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.upeu.lamb.finanzas.dto.ExoneracionPagoRequest;
import pe.edu.upeu.lamb.finanzas.dto.ExoneracionPagoResponse;
import pe.edu.upeu.lamb.finanzas.entity.ExoneracionPago;
import pe.edu.upeu.lamb.finanzas.entity.Pago;
import pe.edu.upeu.lamb.finanzas.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.finanzas.mapper.ExoneracionPagoMapper;
import pe.edu.upeu.lamb.finanzas.repository.ExoneracionPagoRepository;
import pe.edu.upeu.lamb.finanzas.repository.PagoRepository;

import java.util.List;

/**
 * CRUD marcado con (*) en el documento: "Exoneracion de pago" requiere autorizacion.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ExoneracionPagoService {

    private final ExoneracionPagoRepository exoneracionPagoRepository;
    private final PagoRepository pagoRepository;
    private final ExoneracionPagoMapper exoneracionPagoMapper;

    public List<ExoneracionPagoResponse> listar() {
        return exoneracionPagoRepository.findAll().stream()
                .map(exoneracionPagoMapper::toResponse)
                .toList();
    }

    public ExoneracionPagoResponse obtener(Long id) {
        return exoneracionPagoMapper.toResponse(buscarOFallar(id));
    }

    public ExoneracionPagoResponse crear(ExoneracionPagoRequest request) {
        Pago pago = pagoRepository.findById(request.getIdPago())
                .orElseThrow(() -> new ResourceNotFoundException("Pago no encontrado: " + request.getIdPago()));

        ExoneracionPago entity = ExoneracionPago.builder()
                .pago(pago)
                .motivo(request.getMotivo())
                .fecha(request.getFecha())
                .build();

        ExoneracionPago guardado = exoneracionPagoRepository.save(entity);
        return exoneracionPagoMapper.toResponse(guardado);
    }

    private ExoneracionPago buscarOFallar(Long id) {
        return exoneracionPagoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Exoneracion de pago no encontrada: " + id));
    }
}
