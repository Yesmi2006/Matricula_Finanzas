package pe.edu.upeu.lamb.matricula.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.matricula.dto.ObservacionMatriculaRequest;
import pe.edu.upeu.lamb.matricula.dto.ObservacionMatriculaResponse;
import pe.edu.upeu.lamb.matricula.entity.ObservacionMatricula;

@Component
public class ObservacionMatriculaMapper {

    public ObservacionMatricula toEntity(ObservacionMatriculaRequest request) {
        return ObservacionMatricula.builder()
                .idMatricula(request.getIdMatricula())
                .observacion(request.getObservacion())
                .usuarioRegistro(request.getUsuarioRegistro())
                .build();
    }

    public ObservacionMatriculaResponse toResponse(ObservacionMatricula entity) {
        return ObservacionMatriculaResponse.builder()
                .id(entity.getId())
                .idMatricula(entity.getIdMatricula())
                .observacion(entity.getObservacion())
                .fechaObservacion(entity.getFechaObservacion())
                .usuarioRegistro(entity.getUsuarioRegistro())
                .build();
    }
}
