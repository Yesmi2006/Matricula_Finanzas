package pe.edu.upeu.lamb.finanzas.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upeu.lamb.finanzas.dto.SaldoPeriodoRequest;
import pe.edu.upeu.lamb.finanzas.dto.SaldoPeriodoResponse;
import pe.edu.upeu.lamb.finanzas.entity.SaldoPeriodo;
import pe.edu.upeu.lamb.finanzas.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.finanzas.mapper.SaldoPeriodoMapper;
import pe.edu.upeu.lamb.finanzas.repository.SaldoPeriodoRepository;

import java.time.Instant;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SaldoPeriodoService {

    private final SaldoPeriodoRepository saldoPeriodoRepository;
    private final SaldoPeriodoMapper saldoPeriodoMapper;

    public List<SaldoPeriodoResponse> listar() {
        return saldoPeriodoRepository.findAll().stream()
                .map(saldoPeriodoMapper::toResponse)
                .toList();
    }

    public SaldoPeriodoResponse obtener(Long id) {
        return saldoPeriodoMapper.toResponse(buscarOFallar(id));
    }

    @Transactional
    public SaldoPeriodoResponse crear(SaldoPeriodoRequest request) {
        SaldoPeriodo entity = saldoPeriodoMapper.toEntity(request);
        entity.setFechaCalculo(Instant.now());
        return saldoPeriodoMapper.toResponse(saldoPeriodoRepository.save(entity));
    }

    private SaldoPeriodo buscarOFallar(Long id) {
        return saldoPeriodoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Saldo de periodo no encontrado: " + id));
    }
}
