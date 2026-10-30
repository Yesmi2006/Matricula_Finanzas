package pe.edu.upeu.lamb.matricula.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.matricula.dto.EstudianteObservadoSuspendidoRequest;
import pe.edu.upeu.lamb.matricula.dto.EstudianteObservadoSuspendidoResponse;
import pe.edu.upeu.lamb.matricula.entity.EstudianteObservadoSuspendido;

@Component
public class EstudianteObservadoSuspendidoMapper {

    public EstudianteObservadoSuspendido toEntity(EstudianteObservadoSuspendidoRequest request) {
        return EstudianteObservadoSuspendido.builder()
                .idPersona(request.getIdPersona())
                .tipo(request.getTipo())
                .motivo(request.getMotivo())
                .fechaInicio(request.getFechaInicio())
                .fechaFin(request.getFechaFin())
                .build();
    }

    public EstudianteObservadoSuspendidoResponse toResponse(EstudianteObservadoSuspendido entity) {
        return EstudianteObservadoSuspendidoResponse.builder()
                .id(entity.getId())
                .idPersona(entity.getIdPersona())
                .tipo(entity.getTipo())
                .motivo(entity.getMotivo())
                .fechaInicio(entity.getFechaInicio())
                .fechaFin(entity.getFechaFin())
                .build();
    }
}
