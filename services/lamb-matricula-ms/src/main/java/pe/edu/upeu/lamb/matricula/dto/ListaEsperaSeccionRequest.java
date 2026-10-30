package pe.edu.upeu.lamb.matricula.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ListaEsperaSeccionRequest {

    // JALA ID DE PLANIFICACION: id externo de la seccion definido en lamb-planificacion-ms.
    @NotNull
    private Long idSeccion;

    @NotNull
    private Long idPersona;

    @NotNull
    private Integer posicion;

    @NotNull
    private LocalDate fechaInscripcion;
}
