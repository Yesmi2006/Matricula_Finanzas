package pe.edu.upeu.lamb.matricula.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.matricula.dto.HistorialEstadoMatriculaRequest;
import pe.edu.upeu.lamb.matricula.dto.HistorialEstadoMatriculaResponse;
import pe.edu.upeu.lamb.matricula.entity.HistorialEstadoMatricula;

@Component
public class HistorialEstadoMatriculaMapper {

    public HistorialEstadoMatricula toEntity(HistorialEstadoMatriculaRequest request) {
        return HistorialEstadoMatricula.builder()
                .idMatricula(request.getIdMatricula())
                .estadoAnterior(request.getEstadoAnterior())
                .estadoNuevo(request.getEstadoNuevo())
                .observacion(request.getObservacion())
                .build();
    }

    public HistorialEstadoMatriculaResponse toResponse(HistorialEstadoMatricula entity) {
        return HistorialEstadoMatriculaResponse.builder()
                .id(entity.getId())
                .idMatricula(entity.getIdMatricula())
                .estadoAnterior(entity.getEstadoAnterior())
                .estadoNuevo(entity.getEstadoNuevo())
                .fechaCambio(entity.getFechaCambio())
                .observacion(entity.getObservacion())
                .build();
    }
}
