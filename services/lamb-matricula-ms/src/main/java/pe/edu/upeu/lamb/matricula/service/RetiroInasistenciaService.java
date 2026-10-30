package pe.edu.upeu.lamb.matricula.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.upeu.lamb.matricula.dto.RetiroInasistenciaRequest;
import pe.edu.upeu.lamb.matricula.dto.RetiroInasistenciaResponse;
import pe.edu.upeu.lamb.matricula.entity.RetiroInasistencia;
import pe.edu.upeu.lamb.matricula.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.matricula.mapper.RetiroInasistenciaMapper;
import pe.edu.upeu.lamb.matricula.repository.RetiroInasistenciaRepository;

import java.time.Instant;
import java.util.List;

/** CRUD opcional: depende de la universidad. */
@Slf4j
@Service
@RequiredArgsConstructor
public class RetiroInasistenciaService {

    private final RetiroInasistenciaRepository repository;
    private final RetiroInasistenciaMapper mapper;

    public List<RetiroInasistenciaResponse> listar() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    public RetiroInasistenciaResponse obtener(Long id) {
        return mapper.toResponse(buscarOFallar(id));
    }

    public RetiroInasistenciaResponse crear(RetiroInasistenciaRequest request) {
        RetiroInasistencia entity = mapper.toEntity(request);
        entity.setFechaRetiro(Instant.now());
        return mapper.toResponse(repository.save(entity));
    }

    private RetiroInasistencia buscarOFallar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RetiroInasistencia no encontrado: " + id));
    }
}
