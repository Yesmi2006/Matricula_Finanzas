package pe.edu.upeu.lamb.matricula.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConstanciaMatriculaRequest {

    @NotNull
    private Long idMatricula;
}
