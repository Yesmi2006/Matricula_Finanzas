package pe.edu.upeu.lamb.matricula.mapper;

import pe.edu.upeu.lamb.matricula.dto.ModalidadMatriculaRequest;
import pe.edu.upeu.lamb.matricula.dto.ModalidadMatriculaResponse;
import pe.edu.upeu.lamb.matricula.entity.ModalidadMatricula;
import org.springframework.stereotype.Component;

@Component
public class ModalidadMatriculaMapper {

    public ModalidadMatricula toEntity(ModalidadMatriculaRequest request) {
        return ModalidadMatricula.builder()
                .codigo(request.getCodigo())
                .nombre(request.getNombre())
                .descripcion(request.getDescripcion())
                .activo(request.getActivo())
                .build();
    }

    public ModalidadMatriculaResponse toResponse(ModalidadMatricula entity) {
        return ModalidadMatriculaResponse.builder()
                .id(entity.getId())
                .codigo(entity.getCodigo())
                .nombre(entity.getNombre())
                .descripcion(entity.getDescripcion())
                .activo(entity.getActivo())
                .build();
    }
}
