package pe.edu.upeu.lamb.matricula.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/** CRUD opcional: depende de la universidad. */
@Getter
@Setter
public class RehabilitacionMatriculaRequest {

    @NotNull
    private Long idMatricula;

    @NotNull
    @Size(max = 255)
    private String motivo;
}
