package pe.edu.upeu.lamb.matricula.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.matricula.dto.RehabilitacionMatriculaRequest;
import pe.edu.upeu.lamb.matricula.dto.RehabilitacionMatriculaResponse;
import pe.edu.upeu.lamb.matricula.entity.RehabilitacionMatricula;

@Component
public class RehabilitacionMatriculaMapper {

    public RehabilitacionMatricula toEntity(RehabilitacionMatriculaRequest request) {
        return RehabilitacionMatricula.builder()
                .idMatricula(request.getIdMatricula())
                .motivo(request.getMotivo())
                .build();
    }

    public RehabilitacionMatriculaResponse toResponse(RehabilitacionMatricula entity) {
        return RehabilitacionMatriculaResponse.builder()
                .id(entity.getId())
                .idMatricula(entity.getIdMatricula())
                .motivo(entity.getMotivo())
                .fechaRehabilitacion(entity.getFechaRehabilitacion())
                .build();
    }
}
