package pe.edu.upeu.lamb.matricula.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.upeu.lamb.matricula.dto.CambioSituacionAcademicaRequest;
import pe.edu.upeu.lamb.matricula.dto.CambioSituacionAcademicaResponse;
import pe.edu.upeu.lamb.matricula.entity.CambioSituacionAcademica;
import pe.edu.upeu.lamb.matricula.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.matricula.mapper.CambioSituacionAcademicaMapper;
import pe.edu.upeu.lamb.matricula.repository.CambioSituacionAcademicaRepository;

import java.time.Instant;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CambioSituacionAcademicaService {

    private final CambioSituacionAcademicaRepository repository;
    private final CambioSituacionAcademicaMapper mapper;

    public List<CambioSituacionAcademicaResponse> listar() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    public CambioSituacionAcademicaResponse obtener(Long id) {
        return mapper.toResponse(buscarOFallar(id));
    }

    public CambioSituacionAcademicaResponse crear(CambioSituacionAcademicaRequest request) {
        CambioSituacionAcademica entity = mapper.toEntity(request);
        entity.setFechaCambio(Instant.now());
        return mapper.toResponse(repository.save(entity));
    }

    CambioSituacionAcademica buscarOFallar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CambioSituacionAcademica no encontrado: " + id));
    }
}
