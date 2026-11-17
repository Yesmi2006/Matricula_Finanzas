package pe.edu.upeu.lamb.finanzas.dto;

import pe.edu.upeu.lamb.finanzas.entity.MetodoPago;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class PagoRequest {

    @NotNull
    private Long idPersona;

    @NotNull
    private Long matriculaId;

    @NotBlank
    @Size(max = 150)
    private String concepto;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal monto;

    @NotNull
    private MetodoPago metodo;

    @Size(max = 50)
    private String numeroOperacion;

    @Size(max = 100)
    private String bancoReferencia;

    private LocalDateTime fechaVoucher;

    @Size(max = 255)
    private String archivoVoucher;
}
