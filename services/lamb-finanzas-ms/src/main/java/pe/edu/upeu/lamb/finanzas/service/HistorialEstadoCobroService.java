package pe.edu.upeu.lamb.finanzas.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.upeu.lamb.finanzas.dto.HistorialEstadoCobroRequest;
import pe.edu.upeu.lamb.finanzas.dto.HistorialEstadoCobroResponse;
import pe.edu.upeu.lamb.finanzas.entity.EstadoCobro;
import pe.edu.upeu.lamb.finanzas.entity.HistorialEstadoCobro;
import pe.edu.upeu.lamb.finanzas.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.finanzas.mapper.HistorialEstadoCobroMapper;
import pe.edu.upeu.lamb.finanzas.repository.EstadoCobroRepository;
import pe.edu.upeu.lamb.finanzas.repository.HistorialEstadoCobroRepository;

import java.util.List;

/**
 * Item 20 del documento: "Historial de estados del cobro".
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class HistorialEstadoCobroService {

    private final HistorialEstadoCobroRepository historialEstadoCobroRepository;
    private final EstadoCobroRepository estadoCobroRepository;
    private final HistorialEstadoCobroMapper historialEstadoCobroMapper;

    public List<HistorialEstadoCobroResponse> listar() {
        return historialEstadoCobroRepository.findAll().stream()
                .map(historialEstadoCobroMapper::toResponse)
                .toList();
    }

    public HistorialEstadoCobroResponse obtener(Long id) {
        return historialEstadoCobroMapper.toResponse(buscarOFallar(id));
    }

    public HistorialEstadoCobroResponse crear(HistorialEstadoCobroRequest request) {
        EstadoCobro estadoCobro = estadoCobroRepository.findById(request.getIdEstadoCobro())
                .orElseThrow(() -> new ResourceNotFoundException("Estado de cobro no encontrado: " + request.getIdEstadoCobro()));

        HistorialEstadoCobro entity = HistorialEstadoCobro.builder()
                .estadoCobro(estadoCobro)
                .estado(request.getEstado())
                .fecha(request.getFecha())
                .build();

        HistorialEstadoCobro guardado = historialEstadoCobroRepository.save(entity);
        return historialEstadoCobroMapper.toResponse(guardado);
    }

    private HistorialEstadoCobro buscarOFallar(Long id) {
        return historialEstadoCobroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Historial de estado de cobro no encontrado: " + id));
    }
}
