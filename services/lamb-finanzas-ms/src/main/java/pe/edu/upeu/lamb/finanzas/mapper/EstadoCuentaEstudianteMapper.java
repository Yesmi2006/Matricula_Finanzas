package pe.edu.upeu.lamb.finanzas.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.finanzas.dto.EstadoCuentaEstudianteResponse;
import pe.edu.upeu.lamb.finanzas.entity.EstadoCuentaEstudiante;

@Component
public class EstadoCuentaEstudianteMapper {

    public EstadoCuentaEstudianteResponse toResponse(EstadoCuentaEstudiante entity) {
        return EstadoCuentaEstudianteResponse.builder()
                .id(entity.getId())
                .idCuentaEstudiante(entity.getCuentaEstudiante().getId())
                .montoTotalDeuda(entity.getMontoTotalDeuda())
                .montoPagado(entity.getMontoPagado())
                .saldoPendiente(entity.getSaldoPendiente())
                .fecha(entity.getFecha())
                .build();
    }
}
