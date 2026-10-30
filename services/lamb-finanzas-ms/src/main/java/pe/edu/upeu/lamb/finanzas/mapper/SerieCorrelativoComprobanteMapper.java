package pe.edu.upeu.lamb.finanzas.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.finanzas.dto.SerieCorrelativoComprobanteRequest;
import pe.edu.upeu.lamb.finanzas.dto.SerieCorrelativoComprobanteResponse;
import pe.edu.upeu.lamb.finanzas.entity.SerieCorrelativoComprobante;

@Component
public class SerieCorrelativoComprobanteMapper {

    public SerieCorrelativoComprobante toEntity(SerieCorrelativoComprobanteRequest request) {
        return SerieCorrelativoComprobante.builder()
                .tipoDocumento(request.getTipoDocumento())
                .serie(request.getSerie())
                .ultimoCorrelativo(request.getUltimoCorrelativo())
                .build();
    }

    public SerieCorrelativoComprobanteResponse toResponse(SerieCorrelativoComprobante entity) {
        return SerieCorrelativoComprobanteResponse.builder()
                .id(entity.getId())
                .tipoDocumento(entity.getTipoDocumento())
                .serie(entity.getSerie())
                .ultimoCorrelativo(entity.getUltimoCorrelativo())
                .build();
    }
}
