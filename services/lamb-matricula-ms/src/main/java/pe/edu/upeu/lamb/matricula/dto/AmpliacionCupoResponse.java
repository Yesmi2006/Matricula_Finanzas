package pe.edu.upeu.lamb.matricula.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AmpliacionCupoResponse {
    private Long id;
    private Long idSeccion;
    private Integer cupoAdicional;
    private String motivo;
    private String autorizadoPor;
}
