package pe.edu.upeu.lamb.matricula.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.upeu.lamb.matricula.dto.AnulacionMatriculaRequest;
import pe.edu.upeu.lamb.matricula.dto.AnulacionMatriculaResponse;
import pe.edu.upeu.lamb.matricula.entity.AnulacionMatricula;
import pe.edu.upeu.lamb.matricula.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.matricula.mapper.AnulacionMatriculaMapper;
import pe.edu.upeu.lamb.matricula.repository.AnulacionMatriculaRepository;

import java.time.Instant;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AnulacionMatriculaService {

    private final AnulacionMatriculaRepository anulacionMatriculaRepository;
    private final AnulacionMatriculaMapper anulacionMatriculaMapper;

    public List<AnulacionMatriculaResponse> listar() {
        return anulacionMatriculaRepository.findAll().stream()
                .map(anulacionMatriculaMapper::toResponse)
                .toList();
    }

    public AnulacionMatriculaResponse obtener(Long id) {
        return anulacionMatriculaMapper.toResponse(buscarOFallar(id));
    }

    public AnulacionMatriculaResponse crear(AnulacionMatriculaRequest request) {
        AnulacionMatricula entity = anulacionMatriculaMapper.toEntity(request);
        entity.setFechaAnulacion(Instant.now());
        return anulacionMatriculaMapper.toResponse(anulacionMatriculaRepository.save(entity));
    }

    private AnulacionMatricula buscarOFallar(Long id) {
        return anulacionMatriculaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Anulacion de matricula no encontrada: " + id));
    }
}
