package pe.edu.upeu.lamb.finanzas.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "saldos_periodo")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaldoPeriodo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_cuenta", nullable = false)
    private Long idCuenta;

    @Column(name = "periodo", nullable = false, length = 20)
    private String periodo;

    @Column(name = "saldo_calculado", nullable = false, precision = 10, scale = 2)
    private BigDecimal saldoCalculado;

    @Column(name = "fecha_calculo", nullable = false)
    private Instant fechaCalculo;
}
