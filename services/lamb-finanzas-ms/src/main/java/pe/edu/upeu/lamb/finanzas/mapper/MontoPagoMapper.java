package pe.edu.upeu.lamb.finanzas.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.finanzas.dto.MontoPagoResponse;
import pe.edu.upeu.lamb.finanzas.entity.MontoPago;

@Component
public class MontoPagoMapper {

    public MontoPagoResponse toResponse(MontoPago entity) {
        return MontoPagoResponse.builder()
                .id(entity.getId())
                .idEstadoCobro(entity.getEstadoCobro().getId())
                .monto(entity.getMonto())
                .fecha(entity.getFecha())
                .build();
    }
}
