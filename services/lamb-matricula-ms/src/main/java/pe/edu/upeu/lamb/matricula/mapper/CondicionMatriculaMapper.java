package pe.edu.upeu.lamb.matricula.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.matricula.dto.CondicionMatriculaRequest;
import pe.edu.upeu.lamb.matricula.dto.CondicionMatriculaResponse;
import pe.edu.upeu.lamb.matricula.entity.CondicionMatricula;

@Component
public class CondicionMatriculaMapper {

    public CondicionMatricula toEntity(CondicionMatriculaRequest request) {
        return CondicionMatricula.builder()
                .nombre(request.getNombre())
                .descripcion(request.getDescripcion())
                .build();
    }

    public CondicionMatriculaResponse toResponse(CondicionMatricula entity) {
        return CondicionMatriculaResponse.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .descripcion(entity.getDescripcion())
                .build();
    }
}
