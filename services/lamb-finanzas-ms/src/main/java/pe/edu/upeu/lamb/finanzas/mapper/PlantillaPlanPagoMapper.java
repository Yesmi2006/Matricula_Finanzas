package pe.edu.upeu.lamb.finanzas.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.finanzas.dto.PlantillaPlanPagoRequest;
import pe.edu.upeu.lamb.finanzas.dto.PlantillaPlanPagoResponse;
import pe.edu.upeu.lamb.finanzas.entity.PlantillaPlanPago;

@Component
public class PlantillaPlanPagoMapper {

    public PlantillaPlanPago toEntity(PlantillaPlanPagoRequest request) {
        return PlantillaPlanPago.builder()
                .nombre(request.getNombre())
                .tipo(request.getTipo())
                .numeroCuotas(request.getNumeroCuotas())
                .build();
    }

    public PlantillaPlanPagoResponse toResponse(PlantillaPlanPago entity) {
        return PlantillaPlanPagoResponse.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .tipo(entity.getTipo())
                .numeroCuotas(entity.getNumeroCuotas())
                .build();
    }
}
