package pe.edu.upeu.lamb.finanzas.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.upeu.lamb.finanzas.dto.RenovacionSuspensionBecaRequest;
import pe.edu.upeu.lamb.finanzas.dto.RenovacionSuspensionBecaResponse;
import pe.edu.upeu.lamb.finanzas.entity.BecaAplicada;
import pe.edu.upeu.lamb.finanzas.entity.RenovacionSuspensionBeca;
import pe.edu.upeu.lamb.finanzas.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.finanzas.mapper.RenovacionSuspensionBecaMapper;
import pe.edu.upeu.lamb.finanzas.repository.BecaAplicadaRepository;
import pe.edu.upeu.lamb.finanzas.repository.RenovacionSuspensionBecaRepository;

import java.util.List;

/**
 * Lote F3 - Descuentos y becas (item 33 del documento): Renovacion o suspension de beca.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class RenovacionSuspensionBecaService {

    private final RenovacionSuspensionBecaRepository renovacionSuspensionBecaRepository;
    private final BecaAplicadaRepository becaAplicadaRepository;
    private final RenovacionSuspensionBecaMapper renovacionSuspensionBecaMapper;

    public List<RenovacionSuspensionBecaResponse> listar() {
        return renovacionSuspensionBecaRepository.findAll().stream()
                .map(renovacionSuspensionBecaMapper::toResponse)
                .toList();
    }

    public RenovacionSuspensionBecaResponse obtener(Long id) {
        return renovacionSuspensionBecaMapper.toResponse(buscarOFallar(id));
    }

    public RenovacionSuspensionBecaResponse crear(RenovacionSuspensionBecaRequest request) {
        BecaAplicada becaAplicada = becaAplicadaRepository.findById(request.getIdBecaAplicada())
                .orElseThrow(() -> new ResourceNotFoundException("Beca aplicada no encontrada: " + request.getIdBecaAplicada()));

        RenovacionSuspensionBeca entity = RenovacionSuspensionBeca.builder()
                .becaAplicada(becaAplicada)
                .tipo(request.getTipo())
                .fecha(request.getFecha())
                .motivo(request.getMotivo())
                .build();

        RenovacionSuspensionBeca guardado = renovacionSuspensionBecaRepository.save(entity);
        return renovacionSuspensionBecaMapper.toResponse(guardado);
    }

    private RenovacionSuspensionBeca buscarOFallar(Long id) {
        return renovacionSuspensionBecaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Renovacion/suspension de beca no encontrada: " + id));
    }
}
