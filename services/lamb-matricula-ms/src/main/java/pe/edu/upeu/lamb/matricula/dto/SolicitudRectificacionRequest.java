package pe.edu.upeu.lamb.matricula.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SolicitudRectificacionRequest {

    @NotNull
    private Long idMatricula;

    @NotNull
    @Size(max = 255)
    private String motivo;

    @NotNull
    @Size(max = 30)
    private String estado;
}
