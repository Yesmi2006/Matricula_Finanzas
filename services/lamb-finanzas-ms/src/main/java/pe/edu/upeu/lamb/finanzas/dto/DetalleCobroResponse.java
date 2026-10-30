package pe.edu.upeu.lamb.finanzas.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetalleCobroResponse {

    private Long id;
    private Long idEstadoCobro;
    private String concepto;
    private BigDecimal monto;
    private Long idDescuentoAplicado;
}
