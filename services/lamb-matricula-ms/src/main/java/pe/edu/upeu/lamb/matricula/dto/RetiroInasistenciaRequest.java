package pe.edu.upeu.lamb.matricula.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/** CRUD opcional: depende de la universidad. */
@Getter
@Setter
public class RetiroInasistenciaRequest {

    @NotNull
    private Long idMatricula;

    @NotNull
    private Integer numeroInasistencias;
}
