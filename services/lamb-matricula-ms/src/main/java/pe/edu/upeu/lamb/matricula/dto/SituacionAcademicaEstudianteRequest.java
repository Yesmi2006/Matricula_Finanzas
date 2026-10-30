package pe.edu.upeu.lamb.matricula.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SituacionAcademicaEstudianteRequest {

    @NotNull
    private Long idPersona;

    @NotNull
    @Size(max = 20)
    private String periodo;

    @NotNull
    @Size(max = 30)
    private String situacion;
}
