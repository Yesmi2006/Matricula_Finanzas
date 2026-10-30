package pe.edu.upeu.lamb.matricula.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.matricula.dto.MatriculaCondicionalRequest;
import pe.edu.upeu.lamb.matricula.dto.MatriculaCondicionalResponse;
import pe.edu.upeu.lamb.matricula.entity.MatriculaCondicional;

@Component
public class MatriculaCondicionalMapper {

    public MatriculaCondicional toEntity(MatriculaCondicionalRequest request) {
        return MatriculaCondicional.builder()
                .idMatricula(request.getIdMatricula())
                .motivo(request.getMotivo())
                .fechaCondicion(request.getFechaCondicion())
                .build();
    }

    public MatriculaCondicionalResponse toResponse(MatriculaCondicional entity) {
        return MatriculaCondicionalResponse.builder()
                .id(entity.getId())
                .idMatricula(entity.getIdMatricula())
                .motivo(entity.getMotivo())
                .fechaCondicion(entity.getFechaCondicion())
                .levantada(entity.getLevantada())
                .build();
    }
}
