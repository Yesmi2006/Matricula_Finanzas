package pe.edu.upeu.lamb.finanzas.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class ConstanciaNoAdeudoRequest {

    @NotNull
    private Long idEstadoCobro;

    @NotNull
    @Size(max = 50)
    private String codigoConstancia;

    @NotNull
    private Instant fechaEmision;
}
