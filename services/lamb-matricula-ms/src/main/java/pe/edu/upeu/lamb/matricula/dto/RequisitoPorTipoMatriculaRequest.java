package pe.edu.upeu.lamb.matricula.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequisitoPorTipoMatriculaRequest {

    @NotNull
    private Long idTipoMatricula;

    // JALA ID DE CURRICULO: id externo del requisito definido en lamb-curriculo-ms.
    @NotNull
    private Long idRequisitoCurriculo;

    @Size(max = 255)
    private String descripcion;

    @NotNull
    private Boolean obligatorio;
}
