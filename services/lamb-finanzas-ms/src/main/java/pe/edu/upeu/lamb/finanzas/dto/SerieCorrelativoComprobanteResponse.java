package pe.edu.upeu.lamb.finanzas.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.edu.upeu.lamb.finanzas.entity.TipoDocumentoPago;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SerieCorrelativoComprobanteResponse {

    private Long id;
    private TipoDocumentoPago tipoDocumento;
    private String serie;
    private Long ultimoCorrelativo;
}
