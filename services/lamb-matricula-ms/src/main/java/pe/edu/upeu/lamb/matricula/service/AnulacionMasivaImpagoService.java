package pe.edu.upeu.lamb.matricula.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.upeu.lamb.matricula.dto.AnulacionMasivaImpagoRequest;
import pe.edu.upeu.lamb.matricula.dto.AnulacionMasivaImpagoResponse;
import pe.edu.upeu.lamb.matricula.entity.AnulacionMasivaImpago;
import pe.edu.upeu.lamb.matricula.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.matricula.mapper.AnulacionMasivaImpagoMapper;
import pe.edu.upeu.lamb.matricula.repository.AnulacionMasivaImpagoRepository;

import java.time.Instant;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AnulacionMasivaImpagoService {

    private final AnulacionMasivaImpagoRepository repository;
    private final AnulacionMasivaImpagoMapper mapper;

    public List<AnulacionMasivaImpagoResponse> listar() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    public AnulacionMasivaImpagoResponse obtener(Long id) {
        return mapper.toResponse(buscarOFallar(id));
    }

    public AnulacionMasivaImpagoResponse crear(AnulacionMasivaImpagoRequest request) {
        AnulacionMasivaImpago entity = mapper.toEntity(request);
        entity.setFechaEjecucion(Instant.now());
        return mapper.toResponse(repository.save(entity));
    }

    private AnulacionMasivaImpago buscarOFallar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("AnulacionMasivaImpago no encontrada: " + id));
    }
}
