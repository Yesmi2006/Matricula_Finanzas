package pe.edu.upeu.lamb.finanzas.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

/**
 * Item 57 del documento: "Reclamo / observacion de pago". Operacion real.
 * Referencia local real al pago (ya implementado), pues el pago reclamado es un
 * registro propio de este microservicio.
 */
@Entity
@Table(name = "reclamos_pago")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReclamoPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_pago", nullable = false)
    private Pago pago;

    @Column(name = "descripcion", nullable = false, length = 500)
    private String descripcion;

    @Column(name = "resuelto", nullable = false)
    private boolean resuelto;

    @Column(name = "fecha", nullable = false)
    private Instant fecha;
}
