package pe.edu.upeu.lamb.finanzas.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * Item 55 del documento: "Transferencia de pago entre cobros o conceptos". Operacion real.
 * Referencias locales reales a pagos y a conceptos de pago, pues ambos son entidades propias
 * de este microservicio.
 */
@Entity
@Table(name = "transferencias_pago")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransferenciaPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_pago", nullable = false)
    private Pago pago;

    @ManyToOne
    @JoinColumn(name = "id_concepto_origen", nullable = false)
    private ConceptoPago conceptoOrigen;

    @ManyToOne
    @JoinColumn(name = "id_concepto_destino", nullable = false)
    private ConceptoPago conceptoDestino;

    @Column(name = "monto", nullable = false, precision = 10, scale = 2)
    private BigDecimal monto;

    @Column(name = "fecha", nullable = false)
    private Instant fecha;
}
