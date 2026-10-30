package pe.edu.upeu.lamb.matricula.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CruceHorarioAutorizadoRequest {

    @NotNull
    private Long idMatricula;

    @NotNull
    private Long idSeccion1;

    @NotNull
    private Long idSeccion2;

    @NotNull
    @Size(max = 255)
    private String motivo;
}
