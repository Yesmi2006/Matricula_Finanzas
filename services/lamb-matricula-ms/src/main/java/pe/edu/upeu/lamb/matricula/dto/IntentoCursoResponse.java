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
public class IntentoCursoResponse {
    private Long id;
    private Long idPersona;
    private Long idCurso;
    private Integer numeroIntento;
    private String periodo;
    private Instant fechaRegistro;
}
