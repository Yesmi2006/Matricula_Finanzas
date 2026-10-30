package pe.edu.upeu.lamb.finanzas.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.finanzas.dto.RecaudacionVentanillaResponse;
import pe.edu.upeu.lamb.finanzas.entity.RecaudacionVentanilla;

@Component
public class RecaudacionVentanillaMapper {

    public RecaudacionVentanillaResponse toResponse(RecaudacionVentanilla entity) {
        return RecaudacionVentanillaResponse.builder()
                .id(entity.getId())
                .idPago(entity.getPago().getId())
                .idCajero(entity.getIdCajero())
                .numeroVentanilla(entity.getNumeroVentanilla())
                .montoRecaudado(entity.getMontoRecaudado())
                .fecha(entity.getFecha())
                .build();
    }
}
