package pe.edu.upeu.lamb.finanzas.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.finanzas.dto.DocumentoPagoResponse;
import pe.edu.upeu.lamb.finanzas.entity.DocumentoPago;

@Component
public class DocumentoPagoMapper {

    public DocumentoPagoResponse toResponse(DocumentoPago entity) {
        return DocumentoPagoResponse.builder()
                .id(entity.getId())
                .idPago(entity.getPago().getId())
                .tipo(entity.getTipo())
                .serie(entity.getSerie())
                .correlativo(entity.getCorrelativo())
                .monto(entity.getMonto())
                .fechaEmision(entity.getFechaEmision())
                .build();
    }
}
