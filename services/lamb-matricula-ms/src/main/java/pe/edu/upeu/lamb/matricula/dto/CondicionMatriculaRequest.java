package pe.edu.upeu.lamb.matricula.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CondicionMatriculaRequest {

    @NotNull
    @Size(max = 40)
    private String nombre;

    @Size(max = 255)
    private String descripcion;
}
