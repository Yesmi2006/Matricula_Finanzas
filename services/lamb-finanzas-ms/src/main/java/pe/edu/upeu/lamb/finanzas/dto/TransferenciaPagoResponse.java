package pe.edu.upeu.lamb.finanzas.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransferenciaPagoResponse {

    private Long id;
    private Long idPago;
    private Long idConceptoOrigen;
    private Long idConceptoDestino;
    private BigDecimal monto;
    private Instant fecha;
}
