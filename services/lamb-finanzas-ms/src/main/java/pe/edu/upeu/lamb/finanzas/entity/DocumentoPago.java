package pe.edu.upeu.lamb.finanzas.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * Item 37 del documento: "Documento de pago (boleta o factura)". Nucleo.
 */
@Entity
@Table(name = "documentos_pago")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentoPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_pago", nullable = false)
    private Pago pago;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false, length = 20)
    private TipoDocumentoPago tipo;

    @Column(name = "serie", nullable = false, length = 10)
    private String serie;

    @Column(name = "correlativo", nullable = false, length = 20)
    private String correlativo;

    @Column(name = "monto", nullable = false, precision = 10, scale = 2)
    private BigDecimal monto;

    @Column(name = "fecha_emision", nullable = false)
    private Instant fechaEmision;
}
