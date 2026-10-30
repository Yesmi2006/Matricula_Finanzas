package pe.edu.upeu.lamb.matricula.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/** CRUD marcado con (*) en el documento: excepcion administrativa poco frecuente. */
@Getter
@Setter
public class LiberacionExcepcionalPrerrequisitoRequest {

    @NotNull
    private Long idPersona;

    @NotNull
    private Long idCurso;

    @NotNull
    private Long idPrerrequisito;

    @NotNull
    @Size(max = 255)
    private String motivo;
}
