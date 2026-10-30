package pe.edu.upeu.lamb.finanzas.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;

/** CRUD marcado con (*) en el documento: ajuste manual requiere autorizacion. */
@Entity
@Table(name = "ajustes_manuales_saldo")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AjusteManualSaldo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_cuenta", nullable = false)
    private Long idCuenta;

    @Column(name = "monto", nullable = false, precision = 10, scale = 2)
    private BigDecimal monto;

    @Column(name = "motivo", nullable = false, length = 255)
    private String motivo;

    @Column(name = "autorizado_por", nullable = false, length = 150)
    private String autorizadoPor;

    @Column(name = "fecha", nullable = false)
    private Instant fecha;
}
