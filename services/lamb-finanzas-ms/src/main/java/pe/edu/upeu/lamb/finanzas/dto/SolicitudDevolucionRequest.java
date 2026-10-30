package pe.edu.upeu.lamb.finanzas.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import pe.edu.upeu.lamb.finanzas.entity.EstadoSolicitudDevolucion;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
public class SolicitudDevolucionRequest {

    @NotNull
    private Long idPago;

    @NotNull
    @Size(max = 255)
    private String motivo;

    @NotNull
    private BigDecimal montoSolicitado;

    @NotNull
    private EstadoSolicitudDevolucion estado;

    @NotNull
    private Instant fecha;
}
