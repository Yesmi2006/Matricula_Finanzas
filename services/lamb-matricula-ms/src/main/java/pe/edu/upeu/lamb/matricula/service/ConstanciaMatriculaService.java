package pe.edu.upeu.lamb.matricula.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.upeu.lamb.matricula.dto.ConstanciaMatriculaRequest;
import pe.edu.upeu.lamb.matricula.dto.ConstanciaMatriculaResponse;
import pe.edu.upeu.lamb.matricula.entity.ConstanciaMatricula;
import pe.edu.upeu.lamb.matricula.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.matricula.mapper.ConstanciaMatriculaMapper;
import pe.edu.upeu.lamb.matricula.repository.ConstanciaMatriculaRepository;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ConstanciaMatriculaService {

    private final ConstanciaMatriculaRepository constanciaMatriculaRepository;
    private final ConstanciaMatriculaMapper constanciaMatriculaMapper;

    public List<ConstanciaMatriculaResponse> listar() {
        return constanciaMatriculaRepository.findAll().stream()
                .map(constanciaMatriculaMapper::toResponse)
                .toList();
    }

    public ConstanciaMatriculaResponse obtener(Long id) {
        return constanciaMatriculaMapper.toResponse(buscarOFallar(id));
    }

    public ConstanciaMatriculaResponse crear(ConstanciaMatriculaRequest request) {
        ConstanciaMatricula entity = constanciaMatriculaMapper.toEntity(request);
        entity.setFechaEmision(Instant.now());
        entity.setCodigoVerificacion(UUID.randomUUID().toString());
        return constanciaMatriculaMapper.toResponse(constanciaMatriculaRepository.save(entity));
    }

    private ConstanciaMatricula buscarOFallar(Long id) {
        return constanciaMatriculaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Constancia de matricula no encontrada: " + id));
    }
}
