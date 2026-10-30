package pe.edu.upeu.lamb.finanzas.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
public class EstadoCuentaEstudianteRequest {

    @NotNull
    private Long idCuentaEstudiante;

    @NotNull
    private BigDecimal montoTotalDeuda;

    @NotNull
    private BigDecimal montoPagado;

    @NotNull
    private BigDecimal saldoPendiente;

    @NotNull
    private Instant fecha;
}
