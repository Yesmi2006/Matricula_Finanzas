package pe.edu.upeu.lamb.matricula.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EstudianteObservadoSuspendidoRequest {

    @NotNull
    private Long idPersona;

    @NotNull
    @Size(max = 20)
    private String tipo;

    @NotNull
    @Size(max = 255)
    private String motivo;

    @NotNull
    private LocalDate fechaInicio;

    private LocalDate fechaFin;
}
