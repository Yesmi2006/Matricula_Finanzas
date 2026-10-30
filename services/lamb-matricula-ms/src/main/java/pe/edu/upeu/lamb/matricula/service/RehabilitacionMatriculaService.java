package pe.edu.upeu.lamb.matricula.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.upeu.lamb.matricula.dto.RehabilitacionMatriculaRequest;
import pe.edu.upeu.lamb.matricula.dto.RehabilitacionMatriculaResponse;
import pe.edu.upeu.lamb.matricula.entity.RehabilitacionMatricula;
import pe.edu.upeu.lamb.matricula.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.matricula.mapper.RehabilitacionMatriculaMapper;
import pe.edu.upeu.lamb.matricula.repository.RehabilitacionMatriculaRepository;

import java.time.Instant;
import java.util.List;

/** CRUD opcional: depende de la universidad. */
@Slf4j
@Service
@RequiredArgsConstructor
public class RehabilitacionMatriculaService {

    private final RehabilitacionMatriculaRepository repository;
    private final RehabilitacionMatriculaMapper mapper;

    public List<RehabilitacionMatriculaResponse> listar() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    public RehabilitacionMatriculaResponse obtener(Long id) {
        return mapper.toResponse(buscarOFallar(id));
    }

    public RehabilitacionMatriculaResponse crear(RehabilitacionMatriculaRequest request) {
        RehabilitacionMatricula entity = mapper.toEntity(request);
        entity.setFechaRehabilitacion(Instant.now());
        return mapper.toResponse(repository.save(entity));
    }

    private RehabilitacionMatricula buscarOFallar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RehabilitacionMatricula no encontrada: " + id));
    }
}
