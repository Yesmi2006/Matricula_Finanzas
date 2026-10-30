package pe.edu.upeu.lamb.finanzas.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * Item 52 del documento: "Solicitud de devolucion". Operacion real.
 * Referencia local real a pagos (ya implementado), pues el pago que se solicita
 * devolver es un registro propio de este microservicio.
 */
@Entity
@Table(name = "solicitudes_devolucion")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SolicitudDevolucion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_pago", nullable = false)
    private Pago pago;

    @Column(name = "motivo", nullable = false, length = 255)
    private String motivo;

    @Column(name = "monto_solicitado", nullable = false, precision = 10, scale = 2)
    private BigDecimal montoSolicitado;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false, length = 20)
    private EstadoSolicitudDevolucion estado;

    @Column(name = "fecha", nullable = false)
    private Instant fecha;
}
