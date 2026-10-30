package pe.edu.upeu.lamb.finanzas.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * Item 29 del documento: "Recaudacion en ventanilla". Operacion real.
 */
@Entity
@Table(name = "recaudaciones_ventanilla")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecaudacionVentanilla {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_pago", nullable = false)
    private Pago pago;

    // JALA ID DE USUARIOS/PERSONAS: el cajero que atendio la recaudacion se gestiona en otro microservicio.
    @Column(name = "id_cajero", nullable = false)
    private Long idCajero;

    @Column(name = "numero_ventanilla", nullable = false, length = 20)
    private String numeroVentanilla;

    @Column(name = "monto_recaudado", nullable = false, precision = 10, scale = 2)
    private BigDecimal montoRecaudado;

    @Column(name = "fecha", nullable = false)
    private Instant fecha;
}
