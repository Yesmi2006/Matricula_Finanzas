package pe.edu.upeu.lamb.matricula.service;

import pe.edu.upeu.lamb.matricula.dto.CronogramaMatriculaRequest;
import pe.edu.upeu.lamb.matricula.dto.CronogramaMatriculaResponse;
import pe.edu.upeu.lamb.matricula.entity.CronogramaMatricula;
import pe.edu.upeu.lamb.matricula.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.matricula.mapper.CronogramaMatriculaMapper;
import pe.edu.upeu.lamb.matricula.repository.CronogramaMatriculaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CronogramaMatriculaService {

    private final CronogramaMatriculaRepository cronogramaMatriculaRepository;
    private final CronogramaMatriculaMapper cronogramaMatriculaMapper;

    public List<CronogramaMatriculaResponse> listar() {
        return cronogramaMatriculaRepository.findAll().stream()
                .map(cronogramaMatriculaMapper::toResponse)
                .toList();
    }

    public CronogramaMatriculaResponse obtener(Long id) {
        return cronogramaMatriculaMapper.toResponse(buscarOFallar(id));
    }

    public CronogramaMatriculaResponse crear(CronogramaMatriculaRequest request) {
        CronogramaMatricula entity = cronogramaMatriculaMapper.toEntity(request);
        return cronogramaMatriculaMapper.toResponse(cronogramaMatriculaRepository.save(entity));
    }

    private CronogramaMatricula buscarOFallar(Long id) {
        return cronogramaMatriculaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cronograma de matricula no encontrado: " + id));
    }
}
