package pe.edu.upeu.lamb.finanzas.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.finanzas.dto.MovimientoCuentaResponse;
import pe.edu.upeu.lamb.finanzas.entity.MovimientoCuenta;

@Component
public class MovimientoCuentaMapper {

    public MovimientoCuentaResponse toResponse(MovimientoCuenta entity) {
        return MovimientoCuentaResponse.builder()
                .id(entity.getId())
                .idCuenta(entity.getCuenta().getId())
                .tipo(entity.getTipo())
                .monto(entity.getMonto())
                .concepto(entity.getConcepto())
                .fecha(entity.getFecha())
                .build();
    }
}
