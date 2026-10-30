package pe.edu.upeu.lamb.matricula.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import pe.edu.upeu.lamb.matricula.entity.EstadoMatricula;

@Getter
@Setter
public class HistorialEstadoMatriculaRequest {

    @NotNull
    private Long idMatricula;

    private EstadoMatricula estadoAnterior;

    @NotNull
    private EstadoMatricula estadoNuevo;

    @Size(max = 255)
    private String observacion;
}
