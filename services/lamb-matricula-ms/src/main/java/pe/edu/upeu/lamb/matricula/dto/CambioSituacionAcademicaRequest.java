package pe.edu.upeu.lamb.matricula.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CambioSituacionAcademicaRequest {

    @NotNull
    private Long idSituacionAcademica;

    @Size(max = 30)
    private String situacionAnterior;

    @NotNull
    @Size(max = 30)
    private String situacionNueva;

    @NotNull
    @Size(max = 255)
    private String resolucion;
}
