package pe.edu.upeu.lamb.finanzas.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.finanzas.dto.CuentaEstudianteRequest;
import pe.edu.upeu.lamb.finanzas.dto.CuentaEstudianteResponse;
import pe.edu.upeu.lamb.finanzas.entity.CuentaEstudiante;

@Component
public class CuentaEstudianteMapper {

    public CuentaEstudiante toEntity(CuentaEstudianteRequest request) {
        return CuentaEstudiante.builder()
                .idPersona(request.getIdPersona())
                .saldoActual(request.getSaldoActual())
                .build();
    }

    public CuentaEstudianteResponse toResponse(CuentaEstudiante entity) {
        return CuentaEstudianteResponse.builder()
                .id(entity.getId())
                .idPersona(entity.getIdPersona())
                .saldoActual(entity.getSaldoActual())
                .fechaApertura(entity.getFechaApertura())
                .build();
    }
}
