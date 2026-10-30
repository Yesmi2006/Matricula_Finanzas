package pe.edu.upeu.lamb.finanzas.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.upeu.lamb.finanzas.dto.TipoDescuentoRequest;
import pe.edu.upeu.lamb.finanzas.dto.TipoDescuentoResponse;
import pe.edu.upeu.lamb.finanzas.entity.TipoDescuento;
import pe.edu.upeu.lamb.finanzas.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.finanzas.mapper.TipoDescuentoMapper;
import pe.edu.upeu.lamb.finanzas.repository.TipoDescuentoRepository;

import java.util.List;

/**
 * Lote F3 - Descuentos y becas (item 30 del documento): Tipo de Descuento.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class TipoDescuentoService {

    private final TipoDescuentoRepository tipoDescuentoRepository;
    private final TipoDescuentoMapper tipoDescuentoMapper;

    public List<TipoDescuentoResponse> listar() {
        return tipoDescuentoRepository.findAll().stream()
                .map(tipoDescuentoMapper::toResponse)
                .toList();
    }

    public TipoDescuentoResponse obtener(Long id) {
        return tipoDescuentoMapper.toResponse(buscarOFallar(id));
    }

    public TipoDescuentoResponse crear(TipoDescuentoRequest request) {
        TipoDescuento entity = tipoDescuentoMapper.toEntity(request);
        TipoDescuento guardado = tipoDescuentoRepository.save(entity);
        return tipoDescuentoMapper.toResponse(guardado);
    }

    private TipoDescuento buscarOFallar(Long id) {
        return tipoDescuentoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tipo de descuento no encontrado: " + id));
    }
}
