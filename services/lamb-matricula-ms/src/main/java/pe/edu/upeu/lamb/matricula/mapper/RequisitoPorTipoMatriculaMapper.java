package pe.edu.upeu.lamb.matricula.mapper;

import pe.edu.upeu.lamb.matricula.dto.RequisitoPorTipoMatriculaRequest;
import pe.edu.upeu.lamb.matricula.dto.RequisitoPorTipoMatriculaResponse;
import pe.edu.upeu.lamb.matricula.entity.RequisitoPorTipoMatricula;
import org.springframework.stereotype.Component;

@Component
public class RequisitoPorTipoMatriculaMapper {

    public RequisitoPorTipoMatricula toEntity(RequisitoPorTipoMatriculaRequest request) {
        return RequisitoPorTipoMatricula.builder()
                .idTipoMatricula(request.getIdTipoMatricula())
                .idRequisitoCurriculo(request.getIdRequisitoCurriculo())
                .descripcion(request.getDescripcion())
                .obligatorio(request.getObligatorio())
                .build();
    }

    public RequisitoPorTipoMatriculaResponse toResponse(RequisitoPorTipoMatricula entity) {
        return RequisitoPorTipoMatriculaResponse.builder()
                .id(entity.getId())
                .idTipoMatricula(entity.getIdTipoMatricula())
                .idRequisitoCurriculo(entity.getIdRequisitoCurriculo())
                .descripcion(entity.getDescripcion())
                .obligatorio(entity.getObligatorio())
                .build();
    }
}
