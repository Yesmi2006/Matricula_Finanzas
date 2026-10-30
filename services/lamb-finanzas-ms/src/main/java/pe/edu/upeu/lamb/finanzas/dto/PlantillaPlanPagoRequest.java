package pe.edu.upeu.lamb.finanzas.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import pe.edu.upeu.lamb.finanzas.entity.TipoPlanPago;

@Getter
@Setter
public class PlantillaPlanPagoRequest {

    @NotNull
    @Size(max = 150)
    private String nombre;

    @NotNull
    private TipoPlanPago tipo;

    @NotNull
    private Integer numeroCuotas;
}
