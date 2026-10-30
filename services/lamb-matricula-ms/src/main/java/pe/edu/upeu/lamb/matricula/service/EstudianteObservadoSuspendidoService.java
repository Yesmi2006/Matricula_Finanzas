package pe.edu.upeu.lamb.matricula.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.upeu.lamb.matricula.dto.EstudianteObservadoSuspendidoRequest;
import pe.edu.upeu.lamb.matricula.dto.EstudianteObservadoSuspendidoResponse;
import pe.edu.upeu.lamb.matricula.entity.EstudianteObservadoSuspendido;
import pe.edu.upeu.lamb.matricula.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.matricula.mapper.EstudianteObservadoSuspendidoMapper;
import pe.edu.upeu.lamb.matricula.repository.EstudianteObservadoSuspendidoRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class EstudianteObservadoSuspendidoService {

    private final EstudianteObservadoSuspendidoRepository repository;
    private final EstudianteObservadoSuspendidoMapper mapper;

    public List<EstudianteObservadoSuspendidoResponse> listar() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    public EstudianteObservadoSuspendidoResponse obtener(Long id) {
        return mapper.toResponse(buscarOFallar(id));
    }

    public EstudianteObservadoSuspendidoResponse crear(EstudianteObservadoSuspendidoRequest request) {
        EstudianteObservadoSuspendido entity = mapper.toEntity(request);
        return mapper.toResponse(repository.save(entity));
    }

    EstudianteObservadoSuspendido buscarOFallar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EstudianteObservadoSuspendido no encontrado: " + id));
    }
}
