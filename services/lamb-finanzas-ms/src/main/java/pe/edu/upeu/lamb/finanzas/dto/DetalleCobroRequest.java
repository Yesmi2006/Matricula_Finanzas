package pe.edu.upeu.lamb.finanzas.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * CRUD opcional: depende de la universidad.
 */
@Getter
@Setter
public class DetalleCobroRequest {

    @NotNull
    private Long idEstadoCobro;

    @NotNull
    @Size(max = 150)
    private String concepto;

    @NotNull
    private BigDecimal monto;

    // Opcional: no todo cargo tiene un descuento aplicado.
    private Long idDescuentoAplicado;
}
