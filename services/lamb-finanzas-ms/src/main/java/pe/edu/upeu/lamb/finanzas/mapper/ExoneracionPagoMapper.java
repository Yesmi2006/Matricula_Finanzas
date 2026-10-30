package pe.edu.upeu.lamb.finanzas.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.finanzas.dto.ExoneracionPagoResponse;
import pe.edu.upeu.lamb.finanzas.entity.ExoneracionPago;

@Component
public class ExoneracionPagoMapper {

    public ExoneracionPagoResponse toResponse(ExoneracionPago entity) {
        return ExoneracionPagoResponse.builder()
                .id(entity.getId())
                .idPago(entity.getPago().getId())
                .motivo(entity.getMotivo())
                .fecha(entity.getFecha())
                .build();
    }
}
