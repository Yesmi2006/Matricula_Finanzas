package pe.edu.upeu.lamb.finanzas.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import pe.edu.upeu.lamb.finanzas.entity.TipoMovimientoBeca;

import java.time.LocalDate;

@Getter
@Setter
public class RenovacionSuspensionBecaRequest {

    @NotNull
    private Long idBecaAplicada;

    @NotNull
    private TipoMovimientoBeca tipo;

    @NotNull
    private LocalDate fecha;

    @Size(max = 255)
    private String motivo;
}
