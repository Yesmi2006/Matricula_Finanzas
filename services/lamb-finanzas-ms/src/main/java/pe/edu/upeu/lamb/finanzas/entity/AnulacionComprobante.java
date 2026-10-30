package pe.edu.upeu.lamb.finanzas.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

/**
 * Item 40 del documento: "Anulacion de comprobante". Operacion real.
 */
@Entity
@Table(name = "anulaciones_comprobante")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnulacionComprobante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_documento_pago", nullable = false)
    private DocumentoPago documentoPago;

    @Column(name = "motivo", nullable = false, length = 255)
    private String motivo;

    @Column(name = "fecha", nullable = false)
    private Instant fecha;
}
