package pe.edu.upeu.lamb.matricula.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.upeu.lamb.matricula.dto.IntentoCursoRequest;
import pe.edu.upeu.lamb.matricula.dto.IntentoCursoResponse;
import pe.edu.upeu.lamb.matricula.entity.IntentoCurso;
import pe.edu.upeu.lamb.matricula.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.matricula.mapper.IntentoCursoMapper;
import pe.edu.upeu.lamb.matricula.repository.IntentoCursoRepository;

import java.time.Instant;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class IntentoCursoService {

    private final IntentoCursoRepository intentoCursoRepository;
    private final IntentoCursoMapper intentoCursoMapper;

    public List<IntentoCursoResponse> listar() {
        return intentoCursoRepository.findAll().stream()
                .map(intentoCursoMapper::toResponse)
                .toList();
    }

    public IntentoCursoResponse obtener(Long id) {
        return intentoCursoMapper.toResponse(buscarOFallar(id));
    }

    public IntentoCursoResponse crear(IntentoCursoRequest request) {
        IntentoCurso intentoCurso = intentoCursoMapper.toEntity(request);
        intentoCurso.setFechaRegistro(Instant.now());
        return intentoCursoMapper.toResponse(intentoCursoRepository.save(intentoCurso));
    }

    private IntentoCurso buscarOFallar(Long id) {
        return intentoCursoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("IntentoCurso no encontrado: " + id));
    }
}
