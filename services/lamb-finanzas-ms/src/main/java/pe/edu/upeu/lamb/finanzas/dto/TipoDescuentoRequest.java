package pe.edu.upeu.lamb.finanzas.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TipoDescuentoRequest {

    @NotNull
    @Size(max = 100)
    private String nombre;

    @NotNull
    private BigDecimal porcentaje;

    @Size(max = 255)
    private String descripcion;
}
