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
public class CruceHorarioAutorizadoResponse {
    private Long id;
    private Long idMatricula;
    private Long idSeccion1;
    private Long idSeccion2;
    private String motivo;
    private Instant fechaAutorizacion;
}
