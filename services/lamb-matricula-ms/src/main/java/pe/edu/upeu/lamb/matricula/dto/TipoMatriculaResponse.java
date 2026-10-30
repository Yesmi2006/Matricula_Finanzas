package pe.edu.upeu.lamb.matricula.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TipoMatriculaResponse {
    private Long id;
    private String codigo;
    private String nombre;
    private String descripcion;
    private Boolean activo;
}
