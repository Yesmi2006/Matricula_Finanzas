package pe.edu.upeu.lamb.finanzas.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.finanzas.dto.DetalleCobroResponse;
import pe.edu.upeu.lamb.finanzas.entity.DetalleCobro;

@Component
public class DetalleCobroMapper {

    public DetalleCobroResponse toResponse(DetalleCobro entity) {
        return DetalleCobroResponse.builder()
                .id(entity.getId())
                .idEstadoCobro(entity.getEstadoCobro().getId())
                .concepto(entity.getConcepto())
                .monto(entity.getMonto())
                .idDescuentoAplicado(entity.getDescuentoAplicado() != null ? entity.getDescuentoAplicado().getId() : null)
                .build();
    }
}
