package pe.edu.upeu.lamb.finanzas.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/** CRUD opcional: depende de la universidad. */
@Getter
@Setter
public class ReservaSaldoDevolucionRequest {

    @NotNull
    private Long idCuenta;

    @NotNull
    private BigDecimal monto;

    @NotNull
    @Size(max = 255)
    private String motivo;
}
