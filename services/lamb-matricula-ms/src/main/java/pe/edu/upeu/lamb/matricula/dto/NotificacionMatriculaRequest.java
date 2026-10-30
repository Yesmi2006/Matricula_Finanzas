package pe.edu.upeu.lamb.matricula.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificacionMatriculaRequest {

    @NotNull
    private Long idMatricula;

    @NotNull
    @Size(max = 40)
    private String tipo;

    @NotNull
    @Size(max = 20)
    private String canal;
}
