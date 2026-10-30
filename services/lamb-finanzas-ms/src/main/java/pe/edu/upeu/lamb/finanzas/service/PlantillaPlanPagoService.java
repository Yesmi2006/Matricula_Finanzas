package pe.edu.upeu.lamb.finanzas.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.upeu.lamb.finanzas.dto.PlantillaPlanPagoRequest;
import pe.edu.upeu.lamb.finanzas.dto.PlantillaPlanPagoResponse;
import pe.edu.upeu.lamb.finanzas.entity.PlantillaPlanPago;
import pe.edu.upeu.lamb.finanzas.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.finanzas.mapper.PlantillaPlanPagoMapper;
import pe.edu.upeu.lamb.finanzas.repository.PlantillaPlanPagoRepository;

import java.util.List;

/**
 * Lote F2b - Calendario y planes (item 14 del documento): Plantilla de plan de pagos
 * (contado, cuotas, pago anticipado).
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class PlantillaPlanPagoService {

    private final PlantillaPlanPagoRepository plantillaPlanPagoRepository;
    private final PlantillaPlanPagoMapper plantillaPlanPagoMapper;

    public List<PlantillaPlanPagoResponse> listar() {
        return plantillaPlanPagoRepository.findAll().stream()
                .map(plantillaPlanPagoMapper::toResponse)
                .toList();
    }

    public PlantillaPlanPagoResponse obtener(Long id) {
        return plantillaPlanPagoMapper.toResponse(buscarOFallar(id));
    }

    public PlantillaPlanPagoResponse crear(PlantillaPlanPagoRequest request) {
        PlantillaPlanPago entity = plantillaPlanPagoMapper.toEntity(request);
        PlantillaPlanPago guardado = plantillaPlanPagoRepository.save(entity);
        return plantillaPlanPagoMapper.toResponse(guardado);
    }

    private PlantillaPlanPago buscarOFallar(Long id) {
        return plantillaPlanPagoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Plantilla de plan de pago no encontrada: " + id));
    }
}
