package pe.edu.upeu.lamb.matricula.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

@Getter
@Builder
public class ObservacionMatriculaResponse {
    private Long id;
    private Long idMatricula;
    private String observacion;
    private Instant fechaObservacion;
    private String usuarioRegistro;
}
