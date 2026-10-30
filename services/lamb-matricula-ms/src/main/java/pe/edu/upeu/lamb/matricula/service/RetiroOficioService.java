package pe.edu.upeu.lamb.matricula.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.upeu.lamb.matricula.dto.RetiroOficioRequest;
import pe.edu.upeu.lamb.matricula.dto.RetiroOficioResponse;
import pe.edu.upeu.lamb.matricula.entity.RetiroOficio;
import pe.edu.upeu.lamb.matricula.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.matricula.mapper.RetiroOficioMapper;
import pe.edu.upeu.lamb.matricula.repository.RetiroOficioRepository;

import java.time.Instant;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RetiroOficioService {

    private final RetiroOficioRepository repository;
    private final RetiroOficioMapper mapper;

    public List<RetiroOficioResponse> listar() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    public RetiroOficioResponse obtener(Long id) {
        return mapper.toResponse(buscarOFallar(id));
    }

    public RetiroOficioResponse crear(RetiroOficioRequest request) {
        RetiroOficio entity = mapper.toEntity(request);
        entity.setFechaRetiro(Instant.now());
        return mapper.toResponse(repository.save(entity));
    }

    private RetiroOficio buscarOFallar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RetiroOficio no encontrado: " + id));
    }
}
