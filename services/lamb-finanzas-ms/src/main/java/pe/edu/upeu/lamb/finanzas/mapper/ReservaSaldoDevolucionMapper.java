package pe.edu.upeu.lamb.finanzas.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.finanzas.dto.ReservaSaldoDevolucionRequest;
import pe.edu.upeu.lamb.finanzas.dto.ReservaSaldoDevolucionResponse;
import pe.edu.upeu.lamb.finanzas.entity.ReservaSaldoDevolucion;

@Component
public class ReservaSaldoDevolucionMapper {

    public ReservaSaldoDevolucion toEntity(ReservaSaldoDevolucionRequest request) {
        return ReservaSaldoDevolucion.builder()
                .idCuenta(request.getIdCuenta())
                .monto(request.getMonto())
                .motivo(request.getMotivo())
                .build();
    }

    public ReservaSaldoDevolucionResponse toResponse(ReservaSaldoDevolucion entity) {
        return ReservaSaldoDevolucionResponse.builder()
                .id(entity.getId())
                .idCuenta(entity.getIdCuenta())
                .monto(entity.getMonto())
                .motivo(entity.getMotivo())
                .fecha(entity.getFecha())
                .build();
    }
}
