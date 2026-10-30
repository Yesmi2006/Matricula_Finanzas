package pe.edu.upeu.lamb.finanzas.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.finanzas.dto.ConstanciaNoAdeudoResponse;
import pe.edu.upeu.lamb.finanzas.entity.ConstanciaNoAdeudo;

@Component
public class ConstanciaNoAdeudoMapper {

    public ConstanciaNoAdeudoResponse toResponse(ConstanciaNoAdeudo entity) {
        return ConstanciaNoAdeudoResponse.builder()
                .id(entity.getId())
                .idEstadoCobro(entity.getEstadoCobro().getId())
                .codigoConstancia(entity.getCodigoConstancia())
                .fechaEmision(entity.getFechaEmision())
                .build();
    }
}
