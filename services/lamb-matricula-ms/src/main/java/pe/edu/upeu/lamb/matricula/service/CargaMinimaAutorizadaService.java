package pe.edu.upeu.lamb.matricula.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.upeu.lamb.matricula.dto.CargaMinimaAutorizadaRequest;
import pe.edu.upeu.lamb.matricula.dto.CargaMinimaAutorizadaResponse;
import pe.edu.upeu.lamb.matricula.entity.CargaMinimaAutorizada;
import pe.edu.upeu.lamb.matricula.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.matricula.mapper.CargaMinimaAutorizadaMapper;
import pe.edu.upeu.lamb.matricula.repository.CargaMinimaAutorizadaRepository;

import java.time.Instant;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CargaMinimaAutorizadaService {

    private final CargaMinimaAutorizadaRepository cargaMinimaAutorizadaRepository;
    private final CargaMinimaAutorizadaMapper cargaMinimaAutorizadaMapper;

    public List<CargaMinimaAutorizadaResponse> listar() {
        return cargaMinimaAutorizadaRepository.findAll().stream()
                .map(cargaMinimaAutorizadaMapper::toResponse)
                .toList();
    }

    public CargaMinimaAutorizadaResponse obtener(Long id) {
        return cargaMinimaAutorizadaMapper.toResponse(buscarOFallar(id));
    }

    public CargaMinimaAutorizadaResponse crear(CargaMinimaAutorizadaRequest request) {
        CargaMinimaAutorizada cargaMinimaAutorizada = cargaMinimaAutorizadaMapper.toEntity(request);
        cargaMinimaAutorizada.setFechaAutorizacion(Instant.now());
        return cargaMinimaAutorizadaMapper.toResponse(cargaMinimaAutorizadaRepository.save(cargaMinimaAutorizada));
    }

    private CargaMinimaAutorizada buscarOFallar(Long id) {
        return cargaMinimaAutorizadaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CargaMinimaAutorizada no encontrada: " + id));
    }
}
