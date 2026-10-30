package pe.edu.upeu.lamb.finanzas.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class DescuentoAplicadoRequest {

    // JALA ID DE USUARIOS/PERSONAS: la persona/estudiante es dato propio de otro microservicio.
    @NotNull
    private Long idPersona;

    @NotNull
    private Long idTipoDescuento;

    @NotNull
    private BigDecimal porcentaje;

    @NotNull
    private LocalDate fechaInicio;
}
