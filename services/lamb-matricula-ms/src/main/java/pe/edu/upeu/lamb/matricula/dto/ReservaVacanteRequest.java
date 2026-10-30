package pe.edu.upeu.lamb.matricula.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ReservaVacanteRequest {

    // JALA ID DE PLANIFICACION: id externo de la seccion/grupo definido en lamb-planificacion-ms.
    @NotNull
    private Long idSeccion;

    @NotNull
    private Long idPersona;

    @NotNull
    private LocalDate fechaReserva;

    @NotNull
    private LocalDate vigenciaHasta;

    @Size(max = 20)
    private String estado;
}
