package pe.edu.upeu.lamb.finanzas.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.upeu.lamb.finanzas.dto.RecaudacionVentanillaRequest;
import pe.edu.upeu.lamb.finanzas.dto.RecaudacionVentanillaResponse;
import pe.edu.upeu.lamb.finanzas.entity.Pago;
import pe.edu.upeu.lamb.finanzas.entity.RecaudacionVentanilla;
import pe.edu.upeu.lamb.finanzas.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.finanzas.mapper.RecaudacionVentanillaMapper;
import pe.edu.upeu.lamb.finanzas.repository.PagoRepository;
import pe.edu.upeu.lamb.finanzas.repository.RecaudacionVentanillaRepository;

import java.util.List;

/**
 * Item 29 del documento: "Recaudacion en ventanilla".
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class RecaudacionVentanillaService {

    private final RecaudacionVentanillaRepository recaudacionVentanillaRepository;
    private final PagoRepository pagoRepository;
    private final RecaudacionVentanillaMapper recaudacionVentanillaMapper;

    public List<RecaudacionVentanillaResponse> listar() {
        return recaudacionVentanillaRepository.findAll().stream()
                .map(recaudacionVentanillaMapper::toResponse)
                .toList();
    }

    public RecaudacionVentanillaResponse obtener(Long id) {
        return recaudacionVentanillaMapper.toResponse(buscarOFallar(id));
    }

    public RecaudacionVentanillaResponse crear(RecaudacionVentanillaRequest request) {
        Pago pago = pagoRepository.findById(request.getIdPago())
                .orElseThrow(() -> new ResourceNotFoundException("Pago no encontrado: " + request.getIdPago()));

        RecaudacionVentanilla entity = RecaudacionVentanilla.builder()
                .pago(pago)
                .idCajero(request.getIdCajero())
                .numeroVentanilla(request.getNumeroVentanilla())
                .montoRecaudado(request.getMontoRecaudado())
                .fecha(request.getFecha())
                .build();

        RecaudacionVentanilla guardado = recaudacionVentanillaRepository.save(entity);
        return recaudacionVentanillaMapper.toResponse(guardado);
    }

    private RecaudacionVentanilla buscarOFallar(Long id) {
        return recaudacionVentanillaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recaudacion en ventanilla no encontrada: " + id));
    }
}
