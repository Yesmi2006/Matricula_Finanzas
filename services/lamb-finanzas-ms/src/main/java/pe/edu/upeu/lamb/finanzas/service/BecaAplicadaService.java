package pe.edu.upeu.lamb.finanzas.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.upeu.lamb.finanzas.dto.BecaAplicadaRequest;
import pe.edu.upeu.lamb.finanzas.dto.BecaAplicadaResponse;
import pe.edu.upeu.lamb.finanzas.entity.BecaAplicada;
import pe.edu.upeu.lamb.finanzas.entity.TipoBeca;
import pe.edu.upeu.lamb.finanzas.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.finanzas.mapper.BecaAplicadaMapper;
import pe.edu.upeu.lamb.finanzas.repository.BecaAplicadaRepository;
import pe.edu.upeu.lamb.finanzas.repository.TipoBecaRepository;

import java.util.List;

/**
 * Lote F3 - Descuentos y becas (item 32 del documento): Beca aplicada.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class BecaAplicadaService {

    private final BecaAplicadaRepository becaAplicadaRepository;
    private final TipoBecaRepository tipoBecaRepository;
    private final BecaAplicadaMapper becaAplicadaMapper;

    public List<BecaAplicadaResponse> listar() {
        return becaAplicadaRepository.findAll().stream()
                .map(becaAplicadaMapper::toResponse)
                .toList();
    }

    public BecaAplicadaResponse obtener(Long id) {
        return becaAplicadaMapper.toResponse(buscarOFallar(id));
    }

    public BecaAplicadaResponse crear(BecaAplicadaRequest request) {
        TipoBeca tipoBeca = tipoBecaRepository.findById(request.getIdTipoBeca())
                .orElseThrow(() -> new ResourceNotFoundException("Tipo de beca no encontrado: " + request.getIdTipoBeca()));

        BecaAplicada entity = BecaAplicada.builder()
                .idPersona(request.getIdPersona())
                .tipoBeca(tipoBeca)
                .porcentaje(request.getPorcentaje())
                .fechaInicio(request.getFechaInicio())
                .build();

        BecaAplicada guardado = becaAplicadaRepository.save(entity);
        return becaAplicadaMapper.toResponse(guardado);
    }

    private BecaAplicada buscarOFallar(Long id) {
        return becaAplicadaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Beca aplicada no encontrada: " + id));
    }
}
