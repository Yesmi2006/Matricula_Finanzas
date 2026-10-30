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
public class CancelacionCargoMatriculaResponse {

    private Long id;
    private Long idPago;
    private Long idMatricula;
    private String motivo;
    private Instant fecha;
}
