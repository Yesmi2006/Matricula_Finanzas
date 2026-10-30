package pe.edu.upeu.lamb.matricula.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.upeu.lamb.matricula.dto.ReactivacionMatriculaAnuladaRequest;
import pe.edu.upeu.lamb.matricula.dto.ReactivacionMatriculaAnuladaResponse;
import pe.edu.upeu.lamb.matricula.entity.ReactivacionMatriculaAnulada;
import pe.edu.upeu.lamb.matricula.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.matricula.mapper.ReactivacionMatriculaAnuladaMapper;
import pe.edu.upeu.lamb.matricula.repository.ReactivacionMatriculaAnuladaRepository;

import java.time.Instant;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReactivacionMatriculaAnuladaService {

    private final ReactivacionMatriculaAnuladaRepository repository;
    private final ReactivacionMatriculaAnuladaMapper mapper;

    public List<ReactivacionMatriculaAnuladaResponse> listar() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    public ReactivacionMatriculaAnuladaResponse obtener(Long id) {
        return mapper.toResponse(buscarOFallar(id));
    }

    public ReactivacionMatriculaAnuladaResponse crear(ReactivacionMatriculaAnuladaRequest request) {
        ReactivacionMatriculaAnulada entity = mapper.toEntity(request);
        entity.setFechaReactivacion(Instant.now());
        return mapper.toResponse(repository.save(entity));
    }

    private ReactivacionMatriculaAnulada buscarOFallar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ReactivacionMatriculaAnulada no encontrada: " + id));
    }
}
