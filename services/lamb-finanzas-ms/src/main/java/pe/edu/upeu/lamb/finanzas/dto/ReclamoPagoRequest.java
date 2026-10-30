package pe.edu.upeu.lamb.finanzas.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class ReclamoPagoRequest {

    @NotNull
    private Long idPago;

    @NotNull
    @Size(max = 500)
    private String descripcion;

    private boolean resuelto;

    @NotNull
    private Instant fecha;
}
