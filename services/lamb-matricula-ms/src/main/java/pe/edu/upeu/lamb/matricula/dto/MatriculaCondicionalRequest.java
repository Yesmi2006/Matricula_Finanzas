package pe.edu.upeu.lamb.matricula.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class MatriculaCondicionalRequest {

    @NotNull
    private Long idMatricula;

    @NotNull
    @Size(max = 255)
    private String motivo;

    @NotNull
    private LocalDate fechaCondicion;
}
