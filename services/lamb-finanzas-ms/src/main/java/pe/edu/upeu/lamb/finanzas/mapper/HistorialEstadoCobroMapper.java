package pe.edu.upeu.lamb.finanzas.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.finanzas.dto.HistorialEstadoCobroResponse;
import pe.edu.upeu.lamb.finanzas.entity.HistorialEstadoCobro;

@Component
public class HistorialEstadoCobroMapper {

    public HistorialEstadoCobroResponse toResponse(HistorialEstadoCobro entity) {
        return HistorialEstadoCobroResponse.builder()
                .id(entity.getId())
                .idEstadoCobro(entity.getEstadoCobro().getId())
                .estado(entity.getEstado())
                .fecha(entity.getFecha())
                .build();
    }
}
