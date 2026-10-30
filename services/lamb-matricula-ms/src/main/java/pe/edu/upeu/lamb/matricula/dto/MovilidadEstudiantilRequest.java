package pe.edu.upeu.lamb.matricula.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * CRUD opcional (depende de la universidad): movilidad / intercambio estudiantil.
 */
@Getter
@Setter
public class MovilidadEstudiantilRequest {

    @NotNull
    private Long idPersona;

    @NotNull
    @Size(max = 150)
    private String institucionDestino;

    @NotNull
    @Size(max = 20)
    private String tipoMovilidad;

    @NotNull
    @Size(max = 20)
    private String periodo;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;
}
