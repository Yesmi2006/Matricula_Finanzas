package pe.edu.upeu.lamb.finanzas.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * CRUD marcado con (*) en el documento: "Nota de credito" (item 41). Opcional.
 */
@Entity
@Table(name = "notas_credito")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotaCredito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_documento_pago", nullable = false)
    private DocumentoPago documentoPago;

    @Column(name = "motivo", nullable = false, length = 255)
    private String motivo;

    @Column(name = "monto", nullable = false, precision = 10, scale = 2)
    private BigDecimal monto;

    @Column(name = "fecha", nullable = false)
    private Instant fecha;
}
