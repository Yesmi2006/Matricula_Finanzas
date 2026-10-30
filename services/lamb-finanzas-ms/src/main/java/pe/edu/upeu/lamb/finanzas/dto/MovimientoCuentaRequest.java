package pe.edu.upeu.lamb.finanzas.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import pe.edu.upeu.lamb.finanzas.entity.TipoMovimientoCuenta;

import java.math.BigDecimal;

@Getter
@Setter
public class MovimientoCuentaRequest {

    @NotNull
    private Long idCuenta;

    @NotNull
    private TipoMovimientoCuenta tipo;

    @NotNull
    private BigDecimal monto;

    @NotNull
    @Size(max = 150)
    private String concepto;
}
