package pe.edu.upeu.lamb.matricula.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.upeu.lamb.matricula.dto.HistorialEstadoMatriculaRequest;
import pe.edu.upeu.lamb.matricula.dto.HistorialEstadoMatriculaResponse;
import pe.edu.upeu.lamb.matricula.entity.HistorialEstadoMatricula;
import pe.edu.upeu.lamb.matricula.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.matricula.mapper.HistorialEstadoMatriculaMapper;
import pe.edu.upeu.lamb.matricula.repository.HistorialEstadoMatriculaRepository;

import java.time.Instant;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class HistorialEstadoMatriculaService {

    private final HistorialEstadoMatriculaRepository historialEstadoMatriculaRepository;
    private final HistorialEstadoMatriculaMapper historialEstadoMatriculaMapper;

    public List<HistorialEstadoMatriculaResponse> listar() {
        return historialEstadoMatriculaRepository.findAll().stream()
                .map(historialEstadoMatriculaMapper::toResponse)
                .toList();
    }

    public HistorialEstadoMatriculaResponse obtener(Long id) {
        return historialEstadoMatriculaMapper.toResponse(buscarOFallar(id));
    }

    public HistorialEstadoMatriculaResponse crear(HistorialEstadoMatriculaRequest request) {
        HistorialEstadoMatricula entity = historialEstadoMatriculaMapper.toEntity(request);
        entity.setFechaCambio(Instant.now());
        return historialEstadoMatriculaMapper.toResponse(historialEstadoMatriculaRepository.save(entity));
    }

    private HistorialEstadoMatricula buscarOFallar(Long id) {
        return historialEstadoMatriculaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Historial de estado no encontrado: " + id));
    }
}
