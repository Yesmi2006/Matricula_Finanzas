package pe.edu.upeu.lamb.finanzas.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "cuentas_estudiante")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CuentaEstudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_persona", nullable = false, unique = true)
    private Long idPersona;

    @Column(name = "saldo_actual", nullable = false, precision = 10, scale = 2)
    private BigDecimal saldoActual;

    @Column(name = "fecha_apertura", nullable = false)
    private Instant fechaApertura;
}
