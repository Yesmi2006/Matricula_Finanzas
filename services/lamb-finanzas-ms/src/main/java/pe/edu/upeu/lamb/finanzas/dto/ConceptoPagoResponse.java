package pe.edu.upeu.lamb.finanzas.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConceptoPagoResponse {

    private Long id;
    private Long idCategoria;
    private String nombre;
    private BigDecimal monto;
    private LocalDate vigenciaDesde;
    private LocalDate vigenciaHasta;
}
