package pe.edu.upeu.lamb.matricula.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RequisitoPorTipoMatriculaResponse {
    private Long id;
    private Long idTipoMatricula;
    private Long idRequisitoCurriculo;
    private String descripcion;
    private Boolean obligatorio;
}
