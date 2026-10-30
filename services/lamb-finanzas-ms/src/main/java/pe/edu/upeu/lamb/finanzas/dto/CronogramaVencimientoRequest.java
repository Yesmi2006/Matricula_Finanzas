package pe.edu.upeu.lamb.finanzas.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CronogramaVencimientoRequest {

    @NotNull
    @Size(max = 20)
    private String periodo;

    @NotNull
    @Size(max = 150)
    private String descripcion;

    @NotNull
    private LocalDate fechaVencimiento;
}
