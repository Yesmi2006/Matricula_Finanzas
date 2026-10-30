package pe.edu.upeu.lamb.finanzas.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import pe.edu.upeu.lamb.finanzas.entity.TipoDocumentoPago;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
public class DocumentoPagoRequest {

    @NotNull
    private Long idPago;

    @NotNull
    private TipoDocumentoPago tipo;

    @NotNull
    @Size(max = 10)
    private String serie;

    @NotNull
    @Size(max = 20)
    private String correlativo;

    @NotNull
    private BigDecimal monto;

    @NotNull
    private Instant fechaEmision;
}
