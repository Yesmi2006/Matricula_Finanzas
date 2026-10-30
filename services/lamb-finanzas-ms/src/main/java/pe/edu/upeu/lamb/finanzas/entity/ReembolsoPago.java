package pe.edu.upeu.lamb.finanzas.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * Item 53 del documento: "Reembolso de pago (RETORNA AL ID 69 - SALDO DE ESTUDIANTE)". Operacion real.
 * Referencia local real a la solicitud de devolucion (item 52) y a la cuenta del estudiante
 * (item 64/69, ya implementada como CuentaEstudiante), ya que el saldo se acredita en este
 * mismo microservicio.
 */
@Entity
@Table(name = "reembolsos_pago")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReembolsoPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_solicitud_devolucion", nullable = false)
    private SolicitudDevolucion solicitudDevolucion;

    @ManyToOne
    @JoinColumn(name = "id_cuenta_estudiante", nullable = false)
    private CuentaEstudiante cuentaEstudiante;

    @Column(name = "monto_reembolsado", nullable = false, precision = 10, scale = 2)
    private BigDecimal montoReembolsado;

    @Column(name = "fecha", nullable = false)
    private Instant fecha;
}
