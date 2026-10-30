package pe.edu.upeu.lamb.matricula.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.matricula.dto.NotificacionMatriculaRequest;
import pe.edu.upeu.lamb.matricula.dto.NotificacionMatriculaResponse;
import pe.edu.upeu.lamb.matricula.entity.NotificacionMatricula;

@Component
public class NotificacionMatriculaMapper {

    public NotificacionMatricula toEntity(NotificacionMatriculaRequest request) {
        return NotificacionMatricula.builder()
                .idMatricula(request.getIdMatricula())
                .tipo(request.getTipo())
                .canal(request.getCanal())
                .build();
    }

    public NotificacionMatriculaResponse toResponse(NotificacionMatricula entity) {
        return NotificacionMatriculaResponse.builder()
                .id(entity.getId())
                .idMatricula(entity.getIdMatricula())
                .tipo(entity.getTipo())
                .canal(entity.getCanal())
                .fechaEnvio(entity.getFechaEnvio())
                .estadoEnvio(entity.getEstadoEnvio())
                .build();
    }
}
