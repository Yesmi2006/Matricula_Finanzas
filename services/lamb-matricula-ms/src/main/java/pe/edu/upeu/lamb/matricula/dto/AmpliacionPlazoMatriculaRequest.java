package pe.edu.upeu.lamb.matricula.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AmpliacionPlazoMatriculaRequest {

    @NotNull
    private Long idCronograma;

    @NotNull
    private LocalDate fechaAmpliada;

    @NotBlank
    @Size(max = 255)
    private String motivo;

    @Size(max = 80)
    private String autorizadoPor;
}
