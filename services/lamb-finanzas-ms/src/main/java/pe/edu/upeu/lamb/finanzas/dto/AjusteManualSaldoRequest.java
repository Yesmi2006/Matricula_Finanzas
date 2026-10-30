package pe.edu.upeu.lamb.finanzas.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/** CRUD marcado con (*) en el documento: ajuste manual requiere autorizacion. */
@Getter
@Setter
public class AjusteManualSaldoRequest {

    @NotNull
    private Long idCuenta;

    @NotNull
    private BigDecimal monto;

    @NotNull
    @Size(max = 255)
    private String motivo;

    @NotNull
    @Size(max = 150)
    private String autorizadoPor;
}
