package pe.edu.upeu.lamb.finanzas.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.upeu.lamb.finanzas.dto.DescuentoAplicadoRequest;
import pe.edu.upeu.lamb.finanzas.dto.DescuentoAplicadoResponse;
import pe.edu.upeu.lamb.finanzas.entity.DescuentoAplicado;
import pe.edu.upeu.lamb.finanzas.entity.TipoDescuento;
import pe.edu.upeu.lamb.finanzas.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.finanzas.mapper.DescuentoAplicadoMapper;
import pe.edu.upeu.lamb.finanzas.repository.DescuentoAplicadoRepository;
import pe.edu.upeu.lamb.finanzas.repository.TipoDescuentoRepository;

import java.util.List;

/**
 * Lote F3 - Descuentos y becas (item 30 del documento): Descuento aplicado.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class DescuentoAplicadoService {

    private final DescuentoAplicadoRepository descuentoAplicadoRepository;
    private final TipoDescuentoRepository tipoDescuentoRepository;
    private final DescuentoAplicadoMapper descuentoAplicadoMapper;

    public List<DescuentoAplicadoResponse> listar() {
        return descuentoAplicadoRepository.findAll().stream()
                .map(descuentoAplicadoMapper::toResponse)
                .toList();
    }

    public DescuentoAplicadoResponse obtener(Long id) {
        return descuentoAplicadoMapper.toResponse(buscarOFallar(id));
    }

    public DescuentoAplicadoResponse crear(DescuentoAplicadoRequest request) {
        TipoDescuento tipoDescuento = tipoDescuentoRepository.findById(request.getIdTipoDescuento())
                .orElseThrow(() -> new ResourceNotFoundException("Tipo de descuento no encontrado: " + request.getIdTipoDescuento()));

        DescuentoAplicado entity = DescuentoAplicado.builder()
                .idPersona(request.getIdPersona())
                .tipoDescuento(tipoDescuento)
                .porcentaje(request.getPorcentaje())
                .fechaInicio(request.getFechaInicio())
                .build();

        DescuentoAplicado guardado = descuentoAplicadoRepository.save(entity);
        return descuentoAplicadoMapper.toResponse(guardado);
    }

    DescuentoAplicado buscarOFallar(Long id) {
        return descuentoAplicadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Descuento aplicado no encontrado: " + id));
    }
}
