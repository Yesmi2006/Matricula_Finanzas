package pe.edu.upeu.lamb.finanzas.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class ConceptoPagoRequest {

    @NotNull
    private Long idCategoria;

    @NotNull
    @Size(max = 150)
    private String nombre;

    @NotNull
    private BigDecimal monto;

    @NotNull
    private LocalDate vigenciaDesde;

    private LocalDate vigenciaHasta;
}
