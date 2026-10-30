package pe.edu.upeu.lamb.finanzas.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.finanzas.dto.EstadoCobroResponse;
import pe.edu.upeu.lamb.finanzas.entity.EstadoCobro;

@Component
public class EstadoCobroMapper {

    public EstadoCobroResponse toResponse(EstadoCobro entity) {
        return EstadoCobroResponse.builder()
                .id(entity.getId())
                .idCuentaEstudiante(entity.getCuentaEstudiante().getId())
                .estado(entity.getEstado())
                .fecha(entity.getFecha())
                .build();
    }
}
