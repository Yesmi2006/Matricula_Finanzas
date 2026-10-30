package pe.edu.upeu.lamb.matricula.dto;

import pe.edu.upeu.lamb.matricula.entity.EstadoMatricula;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MatriculaResponse {
    private Long id;
    private Long idPersona;
    private String periodo;
    private Instant fecha;
    private EstadoMatricula estado;
    private List<DetalleMatriculaResponse> detalles;
    private List<CondicionMatriculaResponse> condiciones;
}
