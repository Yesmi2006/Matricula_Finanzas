package pe.edu.upeu.lamb.matricula.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.upeu.lamb.matricula.dto.MatriculaCondicionalRequest;
import pe.edu.upeu.lamb.matricula.dto.MatriculaCondicionalResponse;
import pe.edu.upeu.lamb.matricula.entity.MatriculaCondicional;
import pe.edu.upeu.lamb.matricula.exception.BusinessRuleException;
import pe.edu.upeu.lamb.matricula.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.matricula.mapper.MatriculaCondicionalMapper;
import pe.edu.upeu.lamb.matricula.repository.MatriculaCondicionalRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MatriculaCondicionalService {

    private final MatriculaCondicionalRepository matriculaCondicionalRepository;
    private final MatriculaCondicionalMapper matriculaCondicionalMapper;

    public List<MatriculaCondicionalResponse> listar() {
        return matriculaCondicionalRepository.findAll().stream()
                .map(matriculaCondicionalMapper::toResponse)
                .toList();
    }

    public MatriculaCondicionalResponse obtener(Long id) {
        return matriculaCondicionalMapper.toResponse(buscarOFallar(id));
    }

    public MatriculaCondicionalResponse crear(MatriculaCondicionalRequest request) {
        MatriculaCondicional entity = matriculaCondicionalMapper.toEntity(request);
        entity.setLevantada(false);
        return matriculaCondicionalMapper.toResponse(matriculaCondicionalRepository.save(entity));
    }

    public MatriculaCondicionalResponse levantar(Long id) {
        MatriculaCondicional entity = buscarOFallar(id);
        if (Boolean.TRUE.equals(entity.getLevantada())) {
            throw new BusinessRuleException("La condicion de matricula " + id + " ya fue levantada");
        }
        entity.setLevantada(true);
        return matriculaCondicionalMapper.toResponse(matriculaCondicionalRepository.save(entity));
    }

    private MatriculaCondicional buscarOFallar(Long id) {
        return matriculaCondicionalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Matricula condicional no encontrada: " + id));
    }
}
