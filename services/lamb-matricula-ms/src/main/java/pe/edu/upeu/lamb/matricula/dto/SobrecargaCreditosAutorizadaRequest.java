package pe.edu.upeu.lamb.matricula.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/** CRUD marcado con (*) en el documento: autorizacion excepcional de sobrecarga de creditos. */
@Getter
@Setter
public class SobrecargaCreditosAutorizadaRequest {

    @NotNull
    private Long idMatricula;

    @NotNull
    private Integer creditosAutorizados;

    @NotNull
    @Size(max = 255)
    private String motivo;
}
