package pe.edu.upeu.lamb.matricula.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ObservacionMatriculaRequest {

    @NotNull
    private Long idMatricula;

    @NotNull
    @Size(max = 500)
    private String observacion;

    @Size(max = 80)
    private String usuarioRegistro;
}
