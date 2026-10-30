package pe.edu.upeu.lamb.finanzas.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import pe.edu.upeu.lamb.finanzas.entity.EstadoVoucherTipo;

import java.time.Instant;

@Getter
@Setter
public class VoucherRequest {

    @NotNull
    private Long idPago;

    @NotNull
    @Size(max = 50)
    private String numeroVoucher;

    @NotNull
    private EstadoVoucherTipo estado;

    @NotNull
    private Instant fecha;
}
