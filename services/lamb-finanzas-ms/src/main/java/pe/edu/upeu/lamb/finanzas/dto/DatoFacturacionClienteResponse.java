package pe.edu.upeu.lamb.finanzas.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DatoFacturacionClienteResponse {

    private Long id;
    private Long idDocumentoPago;
    private String dni;
    private String ruc;
    private String razonSocial;
}
