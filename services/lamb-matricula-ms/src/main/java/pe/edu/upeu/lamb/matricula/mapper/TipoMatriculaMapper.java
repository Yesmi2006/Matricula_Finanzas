package pe.edu.upeu.lamb.matricula.mapper;

import pe.edu.upeu.lamb.matricula.dto.TipoMatriculaRequest;
import pe.edu.upeu.lamb.matricula.dto.TipoMatriculaResponse;
import pe.edu.upeu.lamb.matricula.entity.TipoMatricula;
import org.springframework.stereotype.Component;

@Component
public class TipoMatriculaMapper {

    public TipoMatricula toEntity(TipoMatriculaRequest request) {
        return TipoMatricula.builder()
                .codigo(request.getCodigo())
                .nombre(request.getNombre())
                .descripcion(request.getDescripcion())
                .activo(request.getActivo())
                .build();
    }

    public TipoMatriculaResponse toResponse(TipoMatricula entity) {
        return TipoMatriculaResponse.builder()
                .id(entity.getId())
                .codigo(entity.getCodigo())
                .nombre(entity.getNombre())
                .descripcion(entity.getDescripcion())
                .activo(entity.getActivo())
                .build();
    }
}
