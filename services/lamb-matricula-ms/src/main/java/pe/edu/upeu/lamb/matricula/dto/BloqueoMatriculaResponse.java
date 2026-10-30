package pe.edu.upeu.lamb.matricula.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class BloqueoMatriculaResponse {
    private Long id;
    private Long idPersona;
    private String motivo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Boolean activo;
}
