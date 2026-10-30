package pe.edu.upeu.lamb.matricula.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

@Getter
@Builder
public class AnulacionMatriculaResponse {
    private Long id;
    private Long idMatricula;
    private String motivo;
    private Instant fechaAnulacion;
    private String autorizadoPor;
}
