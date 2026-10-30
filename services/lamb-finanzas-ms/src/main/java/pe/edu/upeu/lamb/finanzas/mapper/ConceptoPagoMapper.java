package pe.edu.upeu.lamb.finanzas.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.finanzas.dto.ConceptoPagoResponse;
import pe.edu.upeu.lamb.finanzas.entity.ConceptoPago;

@Component
public class ConceptoPagoMapper {

    public ConceptoPagoResponse toResponse(ConceptoPago entity) {
        return ConceptoPagoResponse.builder()
                .id(entity.getId())
                .idCategoria(entity.getCategoria().getId())
                .nombre(entity.getNombre())
                .monto(entity.getMonto())
                .vigenciaDesde(entity.getVigenciaDesde())
                .vigenciaHasta(entity.getVigenciaHasta())
                .build();
    }
}
