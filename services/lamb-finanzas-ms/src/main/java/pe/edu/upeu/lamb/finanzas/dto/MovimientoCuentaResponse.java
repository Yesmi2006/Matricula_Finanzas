package pe.edu.upeu.lamb.finanzas.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.edu.upeu.lamb.finanzas.entity.TipoMovimientoCuenta;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovimientoCuentaResponse {
    private Long id;
    private Long idCuenta;
    private TipoMovimientoCuenta tipo;
    private BigDecimal monto;
    private String concepto;
    private Instant fecha;
}
