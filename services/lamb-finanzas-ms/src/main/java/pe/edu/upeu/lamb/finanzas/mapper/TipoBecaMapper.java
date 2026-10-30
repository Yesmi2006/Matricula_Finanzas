package pe.edu.upeu.lamb.finanzas.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.finanzas.dto.TipoBecaRequest;
import pe.edu.upeu.lamb.finanzas.dto.TipoBecaResponse;
import pe.edu.upeu.lamb.finanzas.entity.TipoBeca;

@Component
public class TipoBecaMapper {

    public TipoBeca toEntity(TipoBecaRequest request) {
        return TipoBeca.builder()
                .nombre(request.getNombre())
                .descripcion(request.getDescripcion())
                .build();
    }

    public TipoBecaResponse toResponse(TipoBeca entity) {
        return TipoBecaResponse.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .descripcion(entity.getDescripcion())
                .build();
    }
}
