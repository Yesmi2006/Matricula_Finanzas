package pe.edu.upeu.lamb.matricula.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AmpliacionCupoRequest {

    // JALA ID DE PLANIFICACION: id externo de la seccion/grupo definido en lamb-planificacion-ms.
    @NotNull
    private Long idSeccion;

    @NotNull
    private Integer cupoAdicional;

    @Size(max = 255)
    private String motivo;

    @Size(max = 80)
    private String autorizadoPor;
}
