package pe.edu.upeu.lamb.finanzas.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class CancelacionCargoMatriculaRequest {

    @NotNull
    private Long idPago;

    @NotNull
    private Long idMatricula;

    @NotNull
    @Size(max = 255)
    private String motivo;

    @NotNull
    private Instant fecha;
}
