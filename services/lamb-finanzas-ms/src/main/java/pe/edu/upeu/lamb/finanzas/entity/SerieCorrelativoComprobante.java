package pe.edu.upeu.lamb.finanzas.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Item 38 del documento: "Serie y correlativo de comprobantes". Nucleo.
 */
@Entity
@Table(name = "series_correlativos_comprobante")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SerieCorrelativoComprobante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_documento", nullable = false, length = 20)
    private TipoDocumentoPago tipoDocumento;

    @Column(name = "serie", nullable = false, length = 10)
    private String serie;

    @Column(name = "ultimo_correlativo", nullable = false)
    private Long ultimoCorrelativo;
}
