package pe.edu.upeu.lamb.matricula.service;

import pe.edu.upeu.lamb.matricula.dto.AmpliacionPlazoMatriculaRequest;
import pe.edu.upeu.lamb.matricula.dto.AmpliacionPlazoMatriculaResponse;
import pe.edu.upeu.lamb.matricula.entity.AmpliacionPlazoMatricula;
import pe.edu.upeu.lamb.matricula.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.matricula.mapper.AmpliacionPlazoMatriculaMapper;
import pe.edu.upeu.lamb.matricula.repository.AmpliacionPlazoMatriculaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AmpliacionPlazoMatriculaService {

    private final AmpliacionPlazoMatriculaRepository ampliacionPlazoMatriculaRepository;
    private final AmpliacionPlazoMatriculaMapper ampliacionPlazoMatriculaMapper;

    public List<AmpliacionPlazoMatriculaResponse> listar() {
        return ampliacionPlazoMatriculaRepository.findAll().stream()
                .map(ampliacionPlazoMatriculaMapper::toResponse)
                .toList();
    }

    public AmpliacionPlazoMatriculaResponse obtener(Long id) {
        return ampliacionPlazoMatriculaMapper.toResponse(buscarOFallar(id));
    }

    public AmpliacionPlazoMatriculaResponse crear(AmpliacionPlazoMatriculaRequest request) {
        AmpliacionPlazoMatricula entity = ampliacionPlazoMatriculaMapper.toEntity(request);
        return ampliacionPlazoMatriculaMapper.toResponse(ampliacionPlazoMatriculaRepository.save(entity));
    }

    private AmpliacionPlazoMatricula buscarOFallar(Long id) {
        return ampliacionPlazoMatriculaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ampliacion de plazo de matricula no encontrada: " + id));
    }
}
