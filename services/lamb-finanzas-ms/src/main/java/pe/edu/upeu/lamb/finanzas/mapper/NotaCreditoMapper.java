package pe.edu.upeu.lamb.finanzas.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.finanzas.dto.NotaCreditoResponse;
import pe.edu.upeu.lamb.finanzas.entity.NotaCredito;

/**
 * CRUD marcado con (*) en el documento: "Nota de credito". Opcional.
 */
@Component
public class NotaCreditoMapper {

    public NotaCreditoResponse toResponse(NotaCredito entity) {
        return NotaCreditoResponse.builder()
                .id(entity.getId())
                .idDocumentoPago(entity.getDocumentoPago().getId())
                .motivo(entity.getMotivo())
                .monto(entity.getMonto())
                .fecha(entity.getFecha())
                .build();
    }
}
