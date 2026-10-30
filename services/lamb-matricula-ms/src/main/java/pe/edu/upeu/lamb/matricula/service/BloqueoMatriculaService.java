package pe.edu.upeu.lamb.matricula.service;

import pe.edu.upeu.lamb.matricula.dto.BloqueoMatriculaRequest;
import pe.edu.upeu.lamb.matricula.dto.BloqueoMatriculaResponse;
import pe.edu.upeu.lamb.matricula.entity.BloqueoMatricula;
import pe.edu.upeu.lamb.matricula.exception.BusinessRuleException;
import pe.edu.upeu.lamb.matricula.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.matricula.mapper.BloqueoMatriculaMapper;
import pe.edu.upeu.lamb.matricula.repository.BloqueoMatriculaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BloqueoMatriculaService {

    private final BloqueoMatriculaRepository bloqueoMatriculaRepository;
    private final BloqueoMatriculaMapper bloqueoMatriculaMapper;

    public List<BloqueoMatriculaResponse> listar() {
        return bloqueoMatriculaRepository.findAll().stream()
                .map(bloqueoMatriculaMapper::toResponse)
                .toList();
    }

    public BloqueoMatriculaResponse obtener(Long id) {
        return bloqueoMatriculaMapper.toResponse(buscarOFallar(id));
    }

    public BloqueoMatriculaResponse crear(BloqueoMatriculaRequest request) {
        BloqueoMatricula entity = bloqueoMatriculaMapper.toEntity(request);
        entity.setActivo(Boolean.TRUE);
        return bloqueoMatriculaMapper.toResponse(bloqueoMatriculaRepository.save(entity));
    }

    public BloqueoMatriculaResponse levantar(Long id) {
        BloqueoMatricula bloqueo = buscarOFallar(id);
        if (Boolean.FALSE.equals(bloqueo.getActivo())) {
            log.warn("component=processor bloqueoId={} status=ignored motivo=\"ya estaba levantado\"", id);
            return bloqueoMatriculaMapper.toResponse(bloqueo);
        }
        if (Boolean.TRUE.equals(bloqueo.getActivo())) {
            bloqueo.setActivo(Boolean.FALSE);
            return bloqueoMatriculaMapper.toResponse(bloqueoMatriculaRepository.save(bloqueo));
        }
        throw new BusinessRuleException("No se puede levantar el bloqueo " + id + ": estado invalido");
    }

    private BloqueoMatricula buscarOFallar(Long id) {
        return bloqueoMatriculaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bloqueo de matricula no encontrado: " + id));
    }
}
