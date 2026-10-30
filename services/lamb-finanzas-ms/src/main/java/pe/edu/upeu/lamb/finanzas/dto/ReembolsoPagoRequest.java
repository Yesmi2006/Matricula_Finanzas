package pe.edu.upeu.lamb.finanzas.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
public class ReembolsoPagoRequest {

    @NotNull
    private Long idSolicitudDevolucion;

    @NotNull
    private Long idCuentaEstudiante;

    @NotNull
    private BigDecimal montoReembolsado;

    @NotNull
    private Instant fecha;
}
