package pe.edu.upeu.lamb.matricula.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class CronogramaMatriculaResponse {
    private Long id;
    private String periodo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String descripcion;
}
