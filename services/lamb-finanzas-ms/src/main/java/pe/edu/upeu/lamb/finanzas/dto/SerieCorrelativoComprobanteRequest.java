package pe.edu.upeu.lamb.finanzas.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import pe.edu.upeu.lamb.finanzas.entity.TipoDocumentoPago;

@Getter
@Setter
public class SerieCorrelativoComprobanteRequest {

    @NotNull
    private TipoDocumentoPago tipoDocumento;

    @NotNull
    @Size(max = 10)
    private String serie;

    @NotNull
    private Long ultimoCorrelativo;
}
