package pe.edu.upeu.lamb.finanzas.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.edu.upeu.lamb.finanzas.entity.EstadoSolicitudDevolucion;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SolicitudDevolucionResponse {

    private Long id;
    private Long idPago;
    private String motivo;
    private BigDecimal montoSolicitado;
    private EstadoSolicitudDevolucion estado;
    private Instant fecha;
}
