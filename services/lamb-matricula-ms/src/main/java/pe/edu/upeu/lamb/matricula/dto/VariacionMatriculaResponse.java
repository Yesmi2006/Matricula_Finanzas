package pe.edu.upeu.lamb.matricula.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class VariacionMatriculaResponse {
    private Long id;
    private Long idCronograma;
    private String tipo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String descripcion;
}
