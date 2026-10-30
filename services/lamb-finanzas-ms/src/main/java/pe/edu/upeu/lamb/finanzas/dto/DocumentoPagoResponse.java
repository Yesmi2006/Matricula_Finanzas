package pe.edu.upeu.lamb.finanzas.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.edu.upeu.lamb.finanzas.entity.TipoDocumentoPago;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentoPagoResponse {

    private Long id;
    private Long idPago;
    private TipoDocumentoPago tipo;
    private String serie;
    private String correlativo;
    private BigDecimal monto;
    private Instant fechaEmision;
}
