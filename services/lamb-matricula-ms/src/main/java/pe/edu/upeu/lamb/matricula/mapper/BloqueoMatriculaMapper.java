package pe.edu.upeu.lamb.matricula.mapper;

import pe.edu.upeu.lamb.matricula.dto.BloqueoMatriculaRequest;
import pe.edu.upeu.lamb.matricula.dto.BloqueoMatriculaResponse;
import pe.edu.upeu.lamb.matricula.entity.BloqueoMatricula;
import org.springframework.stereotype.Component;

@Component
public class BloqueoMatriculaMapper {

    public BloqueoMatricula toEntity(BloqueoMatriculaRequest request) {
        return BloqueoMatricula.builder()
                .idPersona(request.getIdPersona())
                .motivo(request.getMotivo())
                .fechaInicio(request.getFechaInicio())
                .fechaFin(request.getFechaFin())
                .activo(request.getActivo())
                .build();
    }

    public BloqueoMatriculaResponse toResponse(BloqueoMatricula entity) {
        return BloqueoMatriculaResponse.builder()
                .id(entity.getId())
                .idPersona(entity.getIdPersona())
                .motivo(entity.getMotivo())
                .fechaInicio(entity.getFechaInicio())
                .fechaFin(entity.getFechaFin())
                .activo(entity.getActivo())
                .build();
    }
}
