package pe.edu.upeu.lamb.finanzas.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upeu.lamb.finanzas.dto.AjusteManualSaldoRequest;
import pe.edu.upeu.lamb.finanzas.dto.AjusteManualSaldoResponse;
import pe.edu.upeu.lamb.finanzas.entity.AjusteManualSaldo;
import pe.edu.upeu.lamb.finanzas.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.finanzas.mapper.AjusteManualSaldoMapper;
import pe.edu.upeu.lamb.finanzas.repository.AjusteManualSaldoRepository;

import java.time.Instant;
import java.util.List;

/**
 * CRUD marcado con (*) en el documento: ajuste manual requiere autorizacion.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AjusteManualSaldoService {

    private final AjusteManualSaldoRepository ajusteManualSaldoRepository;
    private final AjusteManualSaldoMapper ajusteManualSaldoMapper;

    public List<AjusteManualSaldoResponse> listar() {
        return ajusteManualSaldoRepository.findAll().stream()
                .map(ajusteManualSaldoMapper::toResponse)
                .toList();
    }

    public AjusteManualSaldoResponse obtener(Long id) {
        return ajusteManualSaldoMapper.toResponse(buscarOFallar(id));
    }

    @Transactional
    public AjusteManualSaldoResponse crear(AjusteManualSaldoRequest request) {
        AjusteManualSaldo entity = ajusteManualSaldoMapper.toEntity(request);
        entity.setFecha(Instant.now());
        return ajusteManualSaldoMapper.toResponse(ajusteManualSaldoRepository.save(entity));
    }

    private AjusteManualSaldo buscarOFallar(Long id) {
        return ajusteManualSaldoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ajuste manual de saldo no encontrado: " + id));
    }
}
