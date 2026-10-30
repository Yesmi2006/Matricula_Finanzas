package pe.edu.upeu.lamb.finanzas.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.finanzas.dto.TipoDescuentoRequest;
import pe.edu.upeu.lamb.finanzas.dto.TipoDescuentoResponse;
import pe.edu.upeu.lamb.finanzas.entity.TipoDescuento;

@Component
public class TipoDescuentoMapper {

    public TipoDescuento toEntity(TipoDescuentoRequest request) {
        return TipoDescuento.builder()
                .nombre(request.getNombre())
                .porcentaje(request.getPorcentaje())
                .descripcion(request.getDescripcion())
                .build();
    }

    public TipoDescuentoResponse toResponse(TipoDescuento entity) {
        return TipoDescuentoResponse.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .porcentaje(entity.getPorcentaje())
                .descripcion(entity.getDescripcion())
                .build();
    }
}
