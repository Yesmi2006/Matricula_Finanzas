package pe.edu.upeu.lamb.matricula.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.matricula.dto.SolicitudRectificacionRequest;
import pe.edu.upeu.lamb.matricula.dto.SolicitudRectificacionResponse;
import pe.edu.upeu.lamb.matricula.entity.SolicitudRectificacion;

@Component
public class SolicitudRectificacionMapper {

    public SolicitudRectificacion toEntity(SolicitudRectificacionRequest request) {
        return SolicitudRectificacion.builder()
                .idMatricula(request.getIdMatricula())
                .motivo(request.getMotivo())
                .estado(request.getEstado())
                .build();
    }

    public SolicitudRectificacionResponse toResponse(SolicitudRectificacion entity) {
        return SolicitudRectificacionResponse.builder()
                .id(entity.getId())
                .idMatricula(entity.getIdMatricula())
                .motivo(entity.getMotivo())
                .estado(entity.getEstado())
                .fechaSolicitud(entity.getFechaSolicitud())
                .build();
    }
}
