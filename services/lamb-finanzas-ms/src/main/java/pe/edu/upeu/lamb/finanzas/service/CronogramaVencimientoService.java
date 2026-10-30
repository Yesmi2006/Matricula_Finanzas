package pe.edu.upeu.lamb.finanzas.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.upeu.lamb.finanzas.dto.CronogramaVencimientoRequest;
import pe.edu.upeu.lamb.finanzas.dto.CronogramaVencimientoResponse;
import pe.edu.upeu.lamb.finanzas.entity.CronogramaVencimiento;
import pe.edu.upeu.lamb.finanzas.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.finanzas.mapper.CronogramaVencimientoMapper;
import pe.edu.upeu.lamb.finanzas.repository.CronogramaVencimientoRepository;

import java.util.List;

/**
 * Lote F2b - Calendario y planes (item 13 del documento): Cronograma de vencimientos por periodo.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CronogramaVencimientoService {

    private final CronogramaVencimientoRepository cronogramaVencimientoRepository;
    private final CronogramaVencimientoMapper cronogramaVencimientoMapper;

    public List<CronogramaVencimientoResponse> listar() {
        return cronogramaVencimientoRepository.findAll().stream()
                .map(cronogramaVencimientoMapper::toResponse)
                .toList();
    }

    public CronogramaVencimientoResponse obtener(Long id) {
        return cronogramaVencimientoMapper.toResponse(buscarOFallar(id));
    }

    public CronogramaVencimientoResponse crear(CronogramaVencimientoRequest request) {
        CronogramaVencimiento entity = cronogramaVencimientoMapper.toEntity(request);
        CronogramaVencimiento guardado = cronogramaVencimientoRepository.save(entity);
        return cronogramaVencimientoMapper.toResponse(guardado);
    }

    private CronogramaVencimiento buscarOFallar(Long id) {
        return cronogramaVencimientoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cronograma de vencimiento no encontrado: " + id));
    }
}
