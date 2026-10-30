package pe.edu.upeu.lamb.finanzas.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.finanzas.dto.AjusteManualSaldoRequest;
import pe.edu.upeu.lamb.finanzas.dto.AjusteManualSaldoResponse;
import pe.edu.upeu.lamb.finanzas.entity.AjusteManualSaldo;

@Component
public class AjusteManualSaldoMapper {

    public AjusteManualSaldo toEntity(AjusteManualSaldoRequest request) {
        return AjusteManualSaldo.builder()
                .idCuenta(request.getIdCuenta())
                .monto(request.getMonto())
                .motivo(request.getMotivo())
                .autorizadoPor(request.getAutorizadoPor())
                .build();
    }

    public AjusteManualSaldoResponse toResponse(AjusteManualSaldo entity) {
        return AjusteManualSaldoResponse.builder()
                .id(entity.getId())
                .idCuenta(entity.getIdCuenta())
                .monto(entity.getMonto())
                .motivo(entity.getMotivo())
                .autorizadoPor(entity.getAutorizadoPor())
                .fecha(entity.getFecha())
                .build();
    }
}
