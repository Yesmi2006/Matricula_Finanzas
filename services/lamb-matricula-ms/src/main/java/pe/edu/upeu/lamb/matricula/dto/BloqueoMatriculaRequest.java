package pe.edu.upeu.lamb.matricula.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BloqueoMatriculaRequest {

    @NotNull
    private Long idPersona;

    @NotBlank
    @Size(max = 255)
    private String motivo;

    @NotNull
    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    @NotNull
    private Boolean activo;
}
