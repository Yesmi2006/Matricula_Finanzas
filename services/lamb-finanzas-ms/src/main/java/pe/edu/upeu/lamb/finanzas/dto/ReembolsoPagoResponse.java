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
public class ReembolsoPagoResponse {

    private Long id;
    private Long idSolicitudDevolucion;
    private Long idCuentaEstudiante;
    private BigDecimal montoReembolsado;
    private Instant fecha;
}
