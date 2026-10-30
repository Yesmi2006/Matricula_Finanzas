package pe.edu.upeu.lamb.finanzas.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.finanzas.dto.AnulacionComprobanteResponse;
import pe.edu.upeu.lamb.finanzas.entity.AnulacionComprobante;

@Component
public class AnulacionComprobanteMapper {

    public AnulacionComprobanteResponse toResponse(AnulacionComprobante entity) {
        return AnulacionComprobanteResponse.builder()
                .id(entity.getId())
                .idDocumentoPago(entity.getDocumentoPago().getId())
                .motivo(entity.getMotivo())
                .fecha(entity.getFecha())
                .build();
    }
}
