package pe.edu.upeu.lamb.finanzas.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TarifarioEscuelaCicloRequest {

    @NotNull
    private Long idConceptoPago;

    // JALA ID DE CURRICULO: escuela es dato propio de Curriculo, no se duplica aqui.
    @NotNull
    private Long idEscuela;

    @NotNull
    @Size(max = 20)
    private String ciclo;

    @NotNull
    private BigDecimal monto;
}
