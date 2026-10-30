package pe.edu.upeu.lamb.finanzas.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.finanzas.dto.ReembolsoPagoResponse;
import pe.edu.upeu.lamb.finanzas.entity.ReembolsoPago;

@Component
public class ReembolsoPagoMapper {

    public ReembolsoPagoResponse toResponse(ReembolsoPago entity) {
        return ReembolsoPagoResponse.builder()
                .id(entity.getId())
                .idSolicitudDevolucion(entity.getSolicitudDevolucion().getId())
                .idCuentaEstudiante(entity.getCuentaEstudiante().getId())
                .montoReembolsado(entity.getMontoReembolsado())
                .fecha(entity.getFecha())
                .build();
    }
}
