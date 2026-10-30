package pe.edu.upeu.lamb.matricula.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.upeu.lamb.matricula.dto.LiberacionExcepcionalPrerrequisitoRequest;
import pe.edu.upeu.lamb.matricula.dto.LiberacionExcepcionalPrerrequisitoResponse;
import pe.edu.upeu.lamb.matricula.entity.LiberacionExcepcionalPrerrequisito;
import pe.edu.upeu.lamb.matricula.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.matricula.mapper.LiberacionExcepcionalPrerrequisitoMapper;
import pe.edu.upeu.lamb.matricula.repository.LiberacionExcepcionalPrerrequisitoRepository;

import java.time.Instant;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class LiberacionExcepcionalPrerrequisitoService {

    private final LiberacionExcepcionalPrerrequisitoRepository liberacionExcepcionalPrerrequisitoRepository;
    private final LiberacionExcepcionalPrerrequisitoMapper liberacionExcepcionalPrerrequisitoMapper;

    public List<LiberacionExcepcionalPrerrequisitoResponse> listar() {
        return liberacionExcepcionalPrerrequisitoRepository.findAll().stream()
                .map(liberacionExcepcionalPrerrequisitoMapper::toResponse)
                .toList();
    }

    public LiberacionExcepcionalPrerrequisitoResponse obtener(Long id) {
        return liberacionExcepcionalPrerrequisitoMapper.toResponse(buscarOFallar(id));
    }

    public LiberacionExcepcionalPrerrequisitoResponse crear(LiberacionExcepcionalPrerrequisitoRequest request) {
        LiberacionExcepcionalPrerrequisito liberacionExcepcionalPrerrequisito = liberacionExcepcionalPrerrequisitoMapper.toEntity(request);
        liberacionExcepcionalPrerrequisito.setFechaAutorizacion(Instant.now());
        return liberacionExcepcionalPrerrequisitoMapper.toResponse(liberacionExcepcionalPrerrequisitoRepository.save(liberacionExcepcionalPrerrequisito));
    }

    private LiberacionExcepcionalPrerrequisito buscarOFallar(Long id) {
        return liberacionExcepcionalPrerrequisitoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("LiberacionExcepcionalPrerrequisito no encontrada: " + id));
    }
}
