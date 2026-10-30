package pe.edu.upeu.lamb.finanzas.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.edu.upeu.lamb.finanzas.entity.TipoMovimientoBeca;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RenovacionSuspensionBecaResponse {

    private Long id;
    private Long idBecaAplicada;
    private TipoMovimientoBeca tipo;
    private LocalDate fecha;
    private String motivo;
}
