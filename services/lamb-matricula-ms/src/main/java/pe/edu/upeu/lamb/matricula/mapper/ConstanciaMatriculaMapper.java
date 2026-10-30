package pe.edu.upeu.lamb.matricula.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.matricula.dto.ConstanciaMatriculaRequest;
import pe.edu.upeu.lamb.matricula.dto.ConstanciaMatriculaResponse;
import pe.edu.upeu.lamb.matricula.entity.ConstanciaMatricula;

@Component
public class ConstanciaMatriculaMapper {

    public ConstanciaMatricula toEntity(ConstanciaMatriculaRequest request) {
        return ConstanciaMatricula.builder()
                .idMatricula(request.getIdMatricula())
                .build();
    }

    public ConstanciaMatriculaResponse toResponse(ConstanciaMatricula entity) {
        return ConstanciaMatriculaResponse.builder()
                .id(entity.getId())
                .idMatricula(entity.getIdMatricula())
                .fechaEmision(entity.getFechaEmision())
                .codigoVerificacion(entity.getCodigoVerificacion())
                .urlDocumento(entity.getUrlDocumento())
                .build();
    }
}
