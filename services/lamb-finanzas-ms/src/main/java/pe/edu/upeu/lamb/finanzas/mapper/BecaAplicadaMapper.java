package pe.edu.upeu.lamb.finanzas.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.finanzas.dto.BecaAplicadaResponse;
import pe.edu.upeu.lamb.finanzas.entity.BecaAplicada;

@Component
public class BecaAplicadaMapper {

    public BecaAplicadaResponse toResponse(BecaAplicada entity) {
        return BecaAplicadaResponse.builder()
                .id(entity.getId())
                .idPersona(entity.getIdPersona())
                .idTipoBeca(entity.getTipoBeca().getId())
                .porcentaje(entity.getPorcentaje())
                .fechaInicio(entity.getFechaInicio())
                .build();
    }
}
