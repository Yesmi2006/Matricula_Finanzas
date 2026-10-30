package pe.edu.upeu.lamb.finanzas.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class AnulacionComprobanteRequest {

    @NotNull
    private Long idDocumentoPago;

    @NotNull
    @Size(max = 255)
    private String motivo;

    @NotNull
    private Instant fecha;
}
