package pe.edu.upeu.lamb.finanzas.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.finanzas.dto.CategoriaConceptoRequest;
import pe.edu.upeu.lamb.finanzas.dto.CategoriaConceptoResponse;
import pe.edu.upeu.lamb.finanzas.entity.CategoriaConcepto;

@Component
public class CategoriaConceptoMapper {

    public CategoriaConcepto toEntity(CategoriaConceptoRequest request) {
        return CategoriaConcepto.builder()
                .nombre(request.getNombre())
                .descripcion(request.getDescripcion())
                .build();
    }

    public CategoriaConceptoResponse toResponse(CategoriaConcepto entity) {
        return CategoriaConceptoResponse.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .descripcion(entity.getDescripcion())
                .build();
    }
}
