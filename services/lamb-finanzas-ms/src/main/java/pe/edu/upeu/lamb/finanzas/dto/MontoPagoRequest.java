package pe.edu.upeu.lamb.finanzas.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class MontoPagoRequest {

    @NotNull
    private Long idEstadoCobro;

    @NotNull
    private BigDecimal monto;

    @NotNull
    private LocalDate fecha;
}
