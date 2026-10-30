package pe.edu.upeu.lamb.finanzas.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.finanzas.dto.TransferenciaPagoResponse;
import pe.edu.upeu.lamb.finanzas.entity.TransferenciaPago;

@Component
public class TransferenciaPagoMapper {

    public TransferenciaPagoResponse toResponse(TransferenciaPago entity) {
        return TransferenciaPagoResponse.builder()
                .id(entity.getId())
                .idPago(entity.getPago().getId())
                .idConceptoOrigen(entity.getConceptoOrigen().getId())
                .idConceptoDestino(entity.getConceptoDestino().getId())
                .monto(entity.getMonto())
                .fecha(entity.getFecha())
                .build();
    }
}
