package pe.edu.upeu.lamb.finanzas.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
public class TransferenciaPagoRequest {

    @NotNull
    private Long idPago;

    @NotNull
    private Long idConceptoOrigen;

    @NotNull
    private Long idConceptoDestino;

    @NotNull
    private BigDecimal monto;

    @NotNull
    private Instant fecha;
}
