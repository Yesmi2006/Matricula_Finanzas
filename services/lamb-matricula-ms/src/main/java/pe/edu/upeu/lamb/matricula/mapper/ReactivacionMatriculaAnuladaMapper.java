package pe.edu.upeu.lamb.matricula.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.matricula.dto.ReactivacionMatriculaAnuladaRequest;
import pe.edu.upeu.lamb.matricula.dto.ReactivacionMatriculaAnuladaResponse;
import pe.edu.upeu.lamb.matricula.entity.ReactivacionMatriculaAnulada;

@Component
public class ReactivacionMatriculaAnuladaMapper {

    public ReactivacionMatriculaAnulada toEntity(ReactivacionMatriculaAnuladaRequest request) {
        return ReactivacionMatriculaAnulada.builder()
                .idMatricula(request.getIdMatricula())
                .motivo(request.getMotivo())
                .build();
    }

    public ReactivacionMatriculaAnuladaResponse toResponse(ReactivacionMatriculaAnulada entity) {
        return ReactivacionMatriculaAnuladaResponse.builder()
                .id(entity.getId())
                .idMatricula(entity.getIdMatricula())
                .motivo(entity.getMotivo())
                .fechaReactivacion(entity.getFechaReactivacion())
                .build();
    }
}
