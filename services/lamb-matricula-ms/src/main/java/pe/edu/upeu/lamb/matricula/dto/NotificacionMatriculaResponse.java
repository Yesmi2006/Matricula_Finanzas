package pe.edu.upeu.lamb.matricula.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

@Getter
@Builder
public class NotificacionMatriculaResponse {
    private Long id;
    private Long idMatricula;
    private String tipo;
    private String canal;
    private Instant fechaEnvio;
    private String estadoEnvio;
}
