package pe.edu.upeu.lamb.finanzas.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConstanciaNoAdeudoResponse {

    private Long id;
    private Long idEstadoCobro;
    private String codigoConstancia;
    private Instant fechaEmision;
}
