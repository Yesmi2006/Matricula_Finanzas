package pe.edu.upeu.lamb.finanzas.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Item 21 del documento: "Monto de Pago", vinculado al cobro al que corresponde
 * (referencia real local a EstadoCobro, item 17).
 */
@Entity
@Table(name = "montos_pago")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MontoPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_estado_cobro", nullable = false)
    private EstadoCobro estadoCobro;

    @Column(name = "monto", nullable = false, precision = 10, scale = 2)
    private BigDecimal monto;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;
}
