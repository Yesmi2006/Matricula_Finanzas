package pe.edu.upeu.lamb.matricula.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.upeu.lamb.matricula.dto.SituacionAcademicaEstudianteRequest;
import pe.edu.upeu.lamb.matricula.dto.SituacionAcademicaEstudianteResponse;
import pe.edu.upeu.lamb.matricula.entity.SituacionAcademicaEstudiante;
import pe.edu.upeu.lamb.matricula.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.matricula.mapper.SituacionAcademicaEstudianteMapper;
import pe.edu.upeu.lamb.matricula.repository.SituacionAcademicaEstudianteRepository;

import java.time.Instant;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SituacionAcademicaEstudianteService {

    private final SituacionAcademicaEstudianteRepository repository;
    private final SituacionAcademicaEstudianteMapper mapper;

    public List<SituacionAcademicaEstudianteResponse> listar() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    public SituacionAcademicaEstudianteResponse obtener(Long id) {
        return mapper.toResponse(buscarOFallar(id));
    }

    public SituacionAcademicaEstudianteResponse crear(SituacionAcademicaEstudianteRequest request) {
        SituacionAcademicaEstudiante entity = mapper.toEntity(request);
        entity.setFechaRegistro(Instant.now());
        return mapper.toResponse(repository.save(entity));
    }

    SituacionAcademicaEstudiante buscarOFallar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SituacionAcademicaEstudiante no encontrada: " + id));
    }
}
