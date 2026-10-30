package pe.edu.upeu.lamb.finanzas.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
public class RecaudacionVentanillaRequest {

    @NotNull
    private Long idPago;

    @NotNull
    private Long idCajero;

    @NotNull
    @Size(max = 20)
    private String numeroVentanilla;

    @NotNull
    private BigDecimal montoRecaudado;

    @NotNull
    private Instant fecha;
}
