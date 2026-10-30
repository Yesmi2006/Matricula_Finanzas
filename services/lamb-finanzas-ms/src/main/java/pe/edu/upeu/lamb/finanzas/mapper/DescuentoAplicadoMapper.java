package pe.edu.upeu.lamb.finanzas.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.finanzas.dto.DescuentoAplicadoResponse;
import pe.edu.upeu.lamb.finanzas.entity.DescuentoAplicado;

@Component
public class DescuentoAplicadoMapper {

    public DescuentoAplicadoResponse toResponse(DescuentoAplicado entity) {
        return DescuentoAplicadoResponse.builder()
                .id(entity.getId())
                .idPersona(entity.getIdPersona())
                .idTipoDescuento(entity.getTipoDescuento().getId())
                .porcentaje(entity.getPorcentaje())
                .fechaInicio(entity.getFechaInicio())
                .build();
    }
}
