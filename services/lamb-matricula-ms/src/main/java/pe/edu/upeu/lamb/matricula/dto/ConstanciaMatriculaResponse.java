package pe.edu.upeu.lamb.matricula.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

@Getter
@Builder
public class ConstanciaMatriculaResponse {
    private Long id;
    private Long idMatricula;
    private Instant fechaEmision;
    private String codigoVerificacion;
    private String urlDocumento;
}
