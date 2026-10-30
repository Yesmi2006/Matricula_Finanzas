package pe.edu.upeu.lamb.finanzas.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

/**
 * CRUD marcado con (*) en el documento: "Exoneracion de pago". Exonerar un pago requiere
 * autorizacion; referencia real al Pago local.
 */
@Entity
@Table(name = "exoneraciones_pago")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExoneracionPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_pago", nullable = false)
    private Pago pago;

    @Column(name = "motivo", nullable = false, length = 255)
    private String motivo;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;
}
