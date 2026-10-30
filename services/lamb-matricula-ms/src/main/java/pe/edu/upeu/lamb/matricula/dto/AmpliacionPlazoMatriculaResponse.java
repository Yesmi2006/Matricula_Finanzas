package pe.edu.upeu.lamb.matricula.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class AmpliacionPlazoMatriculaResponse {
    private Long id;
    private Long idCronograma;
    private LocalDate fechaAmpliada;
    private String motivo;
    private String autorizadoPor;
}
