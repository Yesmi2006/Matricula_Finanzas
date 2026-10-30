package pe.edu.upeu.lamb.finanzas.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.edu.upeu.lamb.finanzas.entity.TipoPlanPago;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlantillaPlanPagoResponse {

    private Long id;
    private String nombre;
    private TipoPlanPago tipo;
    private Integer numeroCuotas;
}
