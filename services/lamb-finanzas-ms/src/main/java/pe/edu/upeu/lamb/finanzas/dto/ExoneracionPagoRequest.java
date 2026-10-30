package pe.edu.upeu.lamb.finanzas.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * CRUD marcado con (*) en el documento: "Exoneracion de pago".
 */
@Getter
@Setter
public class ExoneracionPagoRequest {

    @NotNull
    private Long idPago;

    @NotNull
    @Size(max = 255)
    private String motivo;

    @NotNull
    private LocalDate fecha;
}
