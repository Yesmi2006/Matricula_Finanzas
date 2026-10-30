package pe.edu.upeu.lamb.matricula.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class ListaEsperaSeccionResponse {
    private Long id;
    private Long idSeccion;
    private Long idPersona;
    private Integer posicion;
    private LocalDate fechaInscripcion;
}
