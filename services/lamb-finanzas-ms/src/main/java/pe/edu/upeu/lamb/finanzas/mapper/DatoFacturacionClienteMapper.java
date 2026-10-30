package pe.edu.upeu.lamb.finanzas.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.finanzas.dto.DatoFacturacionClienteResponse;
import pe.edu.upeu.lamb.finanzas.entity.DatoFacturacionCliente;

@Component
public class DatoFacturacionClienteMapper {

    public DatoFacturacionClienteResponse toResponse(DatoFacturacionCliente entity) {
        return DatoFacturacionClienteResponse.builder()
                .id(entity.getId())
                .idDocumentoPago(entity.getDocumentoPago().getId())
                .dni(entity.getDni())
                .ruc(entity.getRuc())
                .razonSocial(entity.getRazonSocial())
                .build();
    }
}
