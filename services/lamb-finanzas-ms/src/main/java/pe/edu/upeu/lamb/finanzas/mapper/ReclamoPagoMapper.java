package pe.edu.upeu.lamb.finanzas.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.finanzas.dto.ReclamoPagoResponse;
import pe.edu.upeu.lamb.finanzas.entity.ReclamoPago;

@Component
public class ReclamoPagoMapper {

    public ReclamoPagoResponse toResponse(ReclamoPago entity) {
        return ReclamoPagoResponse.builder()
                .id(entity.getId())
                .idPago(entity.getPago().getId())
                .descripcion(entity.getDescripcion())
                .resuelto(entity.isResuelto())
                .fecha(entity.getFecha())
                .build();
    }
}
