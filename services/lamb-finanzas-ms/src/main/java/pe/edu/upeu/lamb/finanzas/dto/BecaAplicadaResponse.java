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
public class BecaAplicadaResponse {

    private Long id;
    private Long idPersona;
    private Long idTipoBeca;
    private BigDecimal porcentaje;
    private LocalDate fechaInicio;
}
