package pe.edu.upeu.lamb.matricula.service;

import pe.edu.upeu.lamb.matricula.dto.TipoMatriculaRequest;
import pe.edu.upeu.lamb.matricula.dto.TipoMatriculaResponse;
import pe.edu.upeu.lamb.matricula.entity.TipoMatricula;
import pe.edu.upeu.lamb.matricula.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.matricula.mapper.TipoMatriculaMapper;
import pe.edu.upeu.lamb.matricula.repository.TipoMatriculaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TipoMatriculaService {

    private final TipoMatriculaRepository tipoMatriculaRepository;
    private final TipoMatriculaMapper tipoMatriculaMapper;

    public List<TipoMatriculaResponse> listar() {
        return tipoMatriculaRepository.findAll().stream()
                .map(tipoMatriculaMapper::toResponse)
                .toList();
    }

    public TipoMatriculaResponse obtener(Long id) {
        return tipoMatriculaMapper.toResponse(buscarOFallar(id));
    }

    public TipoMatriculaResponse crear(TipoMatriculaRequest request) {
        TipoMatricula entity = tipoMatriculaMapper.toEntity(request);
        return tipoMatriculaMapper.toResponse(tipoMatriculaRepository.save(entity));
    }

    private TipoMatricula buscarOFallar(Long id) {
        return tipoMatriculaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tipo de matricula no encontrado: " + id));
    }
}
