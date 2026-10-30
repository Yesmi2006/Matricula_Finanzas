package pe.edu.upeu.lamb.finanzas.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.finanzas.dto.ConvenioInstitucionalDescuentoRequest;
import pe.edu.upeu.lamb.finanzas.dto.ConvenioInstitucionalDescuentoResponse;
import pe.edu.upeu.lamb.finanzas.entity.ConvenioInstitucionalDescuento;

@Component
public class ConvenioInstitucionalDescuentoMapper {

    public ConvenioInstitucionalDescuento toEntity(ConvenioInstitucionalDescuentoRequest request) {
        return ConvenioInstitucionalDescuento.builder()
                .nombreInstitucion(request.getNombreInstitucion())
                .porcentajeDescuento(request.getPorcentajeDescuento())
                .build();
    }

    public ConvenioInstitucionalDescuentoResponse toResponse(ConvenioInstitucionalDescuento entity) {
        return ConvenioInstitucionalDescuentoResponse.builder()
                .id(entity.getId())
                .nombreInstitucion(entity.getNombreInstitucion())
                .porcentajeDescuento(entity.getPorcentajeDescuento())
                .build();
    }
}
