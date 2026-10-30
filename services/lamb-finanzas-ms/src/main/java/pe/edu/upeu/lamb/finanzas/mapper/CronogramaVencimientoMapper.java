package pe.edu.upeu.lamb.finanzas.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.finanzas.dto.CronogramaVencimientoRequest;
import pe.edu.upeu.lamb.finanzas.dto.CronogramaVencimientoResponse;
import pe.edu.upeu.lamb.finanzas.entity.CronogramaVencimiento;

@Component
public class CronogramaVencimientoMapper {

    public CronogramaVencimiento toEntity(CronogramaVencimientoRequest request) {
        return CronogramaVencimiento.builder()
                .periodo(request.getPeriodo())
                .descripcion(request.getDescripcion())
                .fechaVencimiento(request.getFechaVencimiento())
                .build();
    }

    public CronogramaVencimientoResponse toResponse(CronogramaVencimiento entity) {
        return CronogramaVencimientoResponse.builder()
                .id(entity.getId())
                .periodo(entity.getPeriodo())
                .descripcion(entity.getDescripcion())
                .fechaVencimiento(entity.getFechaVencimiento())
                .build();
    }
}
