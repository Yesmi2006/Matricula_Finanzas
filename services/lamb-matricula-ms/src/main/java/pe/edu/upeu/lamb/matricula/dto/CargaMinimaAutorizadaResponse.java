package pe.edu.upeu.lamb.matricula.dto;

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
public class CargaMinimaAutorizadaResponse {
    private Long id;
    private Long idMatricula;
    private Integer creditosMinimos;
    private String motivo;
    private Instant fechaAutorizacion;
}
