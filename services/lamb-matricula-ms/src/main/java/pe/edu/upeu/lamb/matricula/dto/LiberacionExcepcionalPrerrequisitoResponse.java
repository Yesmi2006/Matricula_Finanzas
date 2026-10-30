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
public class LiberacionExcepcionalPrerrequisitoResponse {
    private Long id;
    private Long idPersona;
    private Long idCurso;
    private Long idPrerrequisito;
    private String motivo;
    private Instant fechaAutorizacion;
}
