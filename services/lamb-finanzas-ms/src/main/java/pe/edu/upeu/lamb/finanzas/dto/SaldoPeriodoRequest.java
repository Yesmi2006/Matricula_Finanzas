package pe.edu.upeu.lamb.finanzas.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaldoPeriodoRequest {

    @NotNull
    private Long idCuenta;

    @NotNull
    @Size(max = 20)
    private String periodo;
}
