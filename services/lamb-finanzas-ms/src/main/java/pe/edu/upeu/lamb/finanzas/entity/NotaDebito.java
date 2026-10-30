package pe.edu.upeu.lamb.finanzas.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * CRUD marcado con (*) en el documento: "Nota de debito" (item 42). Opcional.
 */
@Entity
@Table(name = "notas_debito")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotaDebito {

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
