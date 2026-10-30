package pe.edu.upeu.lamb.matricula.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnulacionMasivaImpagoRequest {

    @NotNull
    @Size(max = 20)
    private String periodo;

    @NotNull
    private Integer totalMatriculasAnuladas;

    @NotNull
    @Size(max = 255)
    private String motivo;
}
