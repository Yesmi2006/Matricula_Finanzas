package pe.edu.upeu.lamb.matricula.dto;

import lombok.Builder;
import lombok.Getter;
import pe.edu.upeu.lamb.matricula.entity.EstadoMatricula;

import java.time.Instant;

@Getter
@Builder
public class HistorialEstadoMatriculaResponse {
    private Long id;
    private Long idMatricula;
    private EstadoMatricula estadoAnterior;
    private EstadoMatricula estadoNuevo;
    private Instant fechaCambio;
    private String observacion;
}
