package pe.edu.upeu.lamb.finanzas.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DatoFacturacionClienteRequest {

    @NotNull
    private Long idDocumentoPago;

    @Size(max = 15)
    private String dni;

    @Size(max = 15)
    private String ruc;

    @Size(max = 150)
    private String razonSocial;
}
