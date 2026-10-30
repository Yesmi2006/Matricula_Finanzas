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
public class TarifarioEscuelaCicloResponse {

    private Long id;
    private Long idConceptoPago;
    private Long idEscuela;
    private String ciclo;
    private BigDecimal monto;
}
