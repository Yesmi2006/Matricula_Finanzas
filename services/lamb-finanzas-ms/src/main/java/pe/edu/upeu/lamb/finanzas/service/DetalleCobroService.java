package pe.edu.upeu.lamb.finanzas.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.upeu.lamb.finanzas.dto.DetalleCobroRequest;
import pe.edu.upeu.lamb.finanzas.dto.DetalleCobroResponse;
import pe.edu.upeu.lamb.finanzas.entity.DescuentoAplicado;
import pe.edu.upeu.lamb.finanzas.entity.DetalleCobro;
import pe.edu.upeu.lamb.finanzas.entity.EstadoCobro;
import pe.edu.upeu.lamb.finanzas.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.finanzas.mapper.DetalleCobroMapper;
import pe.edu.upeu.lamb.finanzas.repository.DescuentoAplicadoRepository;
import pe.edu.upeu.lamb.finanzas.repository.DetalleCobroRepository;
import pe.edu.upeu.lamb.finanzas.repository.EstadoCobroRepository;

import java.util.List;

/**
 * CRUD opcional: depende de la universidad. Item 18 del documento: "Detalle de cobro".
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class DetalleCobroService {

    private final DetalleCobroRepository detalleCobroRepository;
    private final EstadoCobroRepository estadoCobroRepository;
    private final DescuentoAplicadoRepository descuentoAplicadoRepository;
    private final DetalleCobroMapper detalleCobroMapper;

    public List<DetalleCobroResponse> listar() {
        return detalleCobroRepository.findAll().stream()
                .map(detalleCobroMapper::toResponse)
                .toList();
    }

    public DetalleCobroResponse obtener(Long id) {
        return detalleCobroMapper.toResponse(buscarOFallar(id));
    }

    public DetalleCobroResponse crear(DetalleCobroRequest request) {
        EstadoCobro estadoCobro = estadoCobroRepository.findById(request.getIdEstadoCobro())
                .orElseThrow(() -> new ResourceNotFoundException("Estado de cobro no encontrado: " + request.getIdEstadoCobro()));

        DescuentoAplicado descuentoAplicado = null;
        if (request.getIdDescuentoAplicado() != null) {
            descuentoAplicado = descuentoAplicadoRepository.findById(request.getIdDescuentoAplicado())
                    .orElseThrow(() -> new ResourceNotFoundException("Descuento aplicado no encontrado: " + request.getIdDescuentoAplicado()));
        }

        DetalleCobro entity = DetalleCobro.builder()
                .estadoCobro(estadoCobro)
                .concepto(request.getConcepto())
                .monto(request.getMonto())
                .descuentoAplicado(descuentoAplicado)
                .build();

        DetalleCobro guardado = detalleCobroRepository.save(entity);
        return detalleCobroMapper.toResponse(guardado);
    }

    private DetalleCobro buscarOFallar(Long id) {
        return detalleCobroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Detalle de cobro no encontrado: " + id));
    }
}
