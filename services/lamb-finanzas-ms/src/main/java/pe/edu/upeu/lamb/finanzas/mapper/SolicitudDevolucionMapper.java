package pe.edu.upeu.lamb.finanzas.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.finanzas.dto.SolicitudDevolucionResponse;
import pe.edu.upeu.lamb.finanzas.entity.SolicitudDevolucion;

@Component
public class SolicitudDevolucionMapper {

    public SolicitudDevolucionResponse toResponse(SolicitudDevolucion entity) {
        return SolicitudDevolucionResponse.builder()
                .id(entity.getId())
                .idPago(entity.getPago().getId())
                .motivo(entity.getMotivo())
                .montoSolicitado(entity.getMontoSolicitado())
                .estado(entity.getEstado())
                .fecha(entity.getFecha())
                .build();
    }
}
