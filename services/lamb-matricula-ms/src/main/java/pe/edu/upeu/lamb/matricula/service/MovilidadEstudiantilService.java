package pe.edu.upeu.lamb.matricula.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.upeu.lamb.matricula.dto.MovilidadEstudiantilRequest;
import pe.edu.upeu.lamb.matricula.dto.MovilidadEstudiantilResponse;
import pe.edu.upeu.lamb.matricula.entity.MovilidadEstudiantil;
import pe.edu.upeu.lamb.matricula.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.matricula.mapper.MovilidadEstudiantilMapper;
import pe.edu.upeu.lamb.matricula.repository.MovilidadEstudiantilRepository;

import java.util.List;

/**
 * CRUD opcional (depende de la universidad): movilidad / intercambio estudiantil.
 * No todas las instituciones ofrecen convenios de movilidad, por eso este CRUD
 * se marca como Opcional en el documento de requerimientos.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class MovilidadEstudiantilService {

    private final MovilidadEstudiantilRepository repository;
    private final MovilidadEstudiantilMapper mapper;

    public List<MovilidadEstudiantilResponse> listar() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    public MovilidadEstudiantilResponse obtener(Long id) {
        return mapper.toResponse(buscarOFallar(id));
    }

    public MovilidadEstudiantilResponse crear(MovilidadEstudiantilRequest request) {
        MovilidadEstudiantil entity = mapper.toEntity(request);
        return mapper.toResponse(repository.save(entity));
    }

    MovilidadEstudiantil buscarOFallar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("MovilidadEstudiantil no encontrada: " + id));
    }
}
