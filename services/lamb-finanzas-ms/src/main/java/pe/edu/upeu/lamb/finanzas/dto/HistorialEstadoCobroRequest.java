package pe.edu.upeu.lamb.finanzas.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import pe.edu.upeu.lamb.finanzas.entity.EstadoCobroTipo;

import java.time.LocalDate;

@Getter
@Setter
public class HistorialEstadoCobroRequest {

    @NotNull
    private Long idEstadoCobro;

    @NotNull
    private EstadoCobroTipo estado;

    @NotNull
    private LocalDate fecha;
}
