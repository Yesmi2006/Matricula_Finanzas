package pe.edu.upeu.lamb.matricula.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class MatriculaCondicionalResponse {
    private Long id;
    private Long idMatricula;
    private String motivo;
    private LocalDate fechaCondicion;
    private Boolean levantada;
}
