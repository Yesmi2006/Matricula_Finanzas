package pe.edu.upeu.lamb.matricula.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.matricula.dto.LiberacionExcepcionalPrerrequisitoRequest;
import pe.edu.upeu.lamb.matricula.dto.LiberacionExcepcionalPrerrequisitoResponse;
import pe.edu.upeu.lamb.matricula.entity.LiberacionExcepcionalPrerrequisito;

@Component
public class LiberacionExcepcionalPrerrequisitoMapper {

    public LiberacionExcepcionalPrerrequisito toEntity(LiberacionExcepcionalPrerrequisitoRequest request) {
        return LiberacionExcepcionalPrerrequisito.builder()
                .idPersona(request.getIdPersona())
                .idCurso(request.getIdCurso())
                .idPrerrequisito(request.getIdPrerrequisito())
                .motivo(request.getMotivo())
                .build();
    }

    public LiberacionExcepcionalPrerrequisitoResponse toResponse(LiberacionExcepcionalPrerrequisito entity) {
        return LiberacionExcepcionalPrerrequisitoResponse.builder()
                .id(entity.getId())
                .idPersona(entity.getIdPersona())
                .idCurso(entity.getIdCurso())
                .idPrerrequisito(entity.getIdPrerrequisito())
                .motivo(entity.getMotivo())
                .fechaAutorizacion(entity.getFechaAutorizacion())
                .build();
    }
}
