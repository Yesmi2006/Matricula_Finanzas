package pe.edu.upeu.lamb.finanzas.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.upeu.lamb.finanzas.dto.TipoBecaRequest;
import pe.edu.upeu.lamb.finanzas.dto.TipoBecaResponse;
import pe.edu.upeu.lamb.finanzas.entity.TipoBeca;
import pe.edu.upeu.lamb.finanzas.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.finanzas.mapper.TipoBecaMapper;
import pe.edu.upeu.lamb.finanzas.repository.TipoBecaRepository;

import java.util.List;

/**
 * Lote F3 - Descuentos y becas (item 31 del documento): Tipo de Beca.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class TipoBecaService {

    private final TipoBecaRepository tipoBecaRepository;
    private final TipoBecaMapper tipoBecaMapper;

    public List<TipoBecaResponse> listar() {
        return tipoBecaRepository.findAll().stream()
                .map(tipoBecaMapper::toResponse)
                .toList();
    }

    public TipoBecaResponse obtener(Long id) {
        return tipoBecaMapper.toResponse(buscarOFallar(id));
    }

    public TipoBecaResponse crear(TipoBecaRequest request) {
        TipoBeca entity = tipoBecaMapper.toEntity(request);
        TipoBeca guardado = tipoBecaRepository.save(entity);
        return tipoBecaMapper.toResponse(guardado);
    }

    private TipoBeca buscarOFallar(Long id) {
        return tipoBecaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tipo de beca no encontrado: " + id));
    }
}
