package pe.edu.upeu.lamb.matricula.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.upeu.lamb.matricula.dto.SobrecargaCreditosAutorizadaRequest;
import pe.edu.upeu.lamb.matricula.dto.SobrecargaCreditosAutorizadaResponse;
import pe.edu.upeu.lamb.matricula.entity.SobrecargaCreditosAutorizada;
import pe.edu.upeu.lamb.matricula.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.matricula.mapper.SobrecargaCreditosAutorizadaMapper;
import pe.edu.upeu.lamb.matricula.repository.SobrecargaCreditosAutorizadaRepository;

import java.time.Instant;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SobrecargaCreditosAutorizadaService {

    private final SobrecargaCreditosAutorizadaRepository sobrecargaCreditosAutorizadaRepository;
    private final SobrecargaCreditosAutorizadaMapper sobrecargaCreditosAutorizadaMapper;

    public List<SobrecargaCreditosAutorizadaResponse> listar() {
        return sobrecargaCreditosAutorizadaRepository.findAll().stream()
                .map(sobrecargaCreditosAutorizadaMapper::toResponse)
                .toList();
    }

    public SobrecargaCreditosAutorizadaResponse obtener(Long id) {
        return sobrecargaCreditosAutorizadaMapper.toResponse(buscarOFallar(id));
    }

    public SobrecargaCreditosAutorizadaResponse crear(SobrecargaCreditosAutorizadaRequest request) {
        SobrecargaCreditosAutorizada sobrecargaCreditosAutorizada = sobrecargaCreditosAutorizadaMapper.toEntity(request);
        sobrecargaCreditosAutorizada.setFechaAutorizacion(Instant.now());
        return sobrecargaCreditosAutorizadaMapper.toResponse(sobrecargaCreditosAutorizadaRepository.save(sobrecargaCreditosAutorizada));
    }

    private SobrecargaCreditosAutorizada buscarOFallar(Long id) {
        return sobrecargaCreditosAutorizadaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SobrecargaCreditosAutorizada no encontrada: " + id));
    }
}
