package pe.edu.upeu.lamb.finanzas.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.finanzas.dto.RenovacionSuspensionBecaResponse;
import pe.edu.upeu.lamb.finanzas.entity.RenovacionSuspensionBeca;

@Component
public class RenovacionSuspensionBecaMapper {

    public RenovacionSuspensionBecaResponse toResponse(RenovacionSuspensionBeca entity) {
        return RenovacionSuspensionBecaResponse.builder()
                .id(entity.getId())
                .idBecaAplicada(entity.getBecaAplicada().getId())
                .tipo(entity.getTipo())
                .fecha(entity.getFecha())
                .motivo(entity.getMotivo())
                .build();
    }
}
