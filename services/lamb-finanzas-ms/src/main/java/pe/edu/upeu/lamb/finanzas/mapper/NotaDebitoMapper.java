package pe.edu.upeu.lamb.finanzas.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.finanzas.dto.NotaDebitoResponse;
import pe.edu.upeu.lamb.finanzas.entity.NotaDebito;

/**
 * CRUD marcado con (*) en el documento: "Nota de debito". Opcional.
 */
@Component
public class NotaDebitoMapper {

    public NotaDebitoResponse toResponse(NotaDebito entity) {
        return NotaDebitoResponse.builder()
                .id(entity.getId())
                .idDocumentoPago(entity.getDocumentoPago().getId())
                .motivo(entity.getMotivo())
                .monto(entity.getMonto())
                .fecha(entity.getFecha())
                .build();
    }
}
