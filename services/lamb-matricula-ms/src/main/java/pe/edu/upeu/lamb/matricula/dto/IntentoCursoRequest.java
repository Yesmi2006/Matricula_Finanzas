package pe.edu.upeu.lamb.matricula.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IntentoCursoRequest {

    @NotNull
    private Long idPersona;

    @NotNull
    private Long idCurso;

    @NotNull
    private Integer numeroIntento;

    @NotNull
    @Size(max = 20)
    private String periodo;
}
