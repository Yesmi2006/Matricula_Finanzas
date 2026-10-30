package pe.edu.upeu.lamb.finanzas.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * CRUD marcado con (*) en el documento: "Nota de credito". Opcional.
 */
@Getter
@Setter
public class NotaCreditoRequest {

    @NotNull
    private Long idDocumentoPago;

    @NotNull
    @Size(max = 255)
    private String motivo;

    @NotNull
    private BigDecimal monto;

    @NotNull
    private Instant fecha;
}
