package pe.edu.upeu.lamb.finanzas.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * Item 58 del documento: "Estado de cuenta del estudiante (RETORNA AL ID 64 - CATALOGO Y TARIFAS)".
 * Operacion real. Referencia local real a la cuenta del estudiante (item 64/69, ya implementada
 * como CuentaEstudiante), pues el estado de cuenta es una foto del saldo que ya se gestiona
 * en este mismo microservicio.
 */
@Entity
@Table(name = "estados_cuenta_estudiante")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EstadoCuentaEstudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cuenta_estudiante", nullable = false)
    private CuentaEstudiante cuentaEstudiante;

    @Column(name = "monto_total_deuda", nullable = false, precision = 10, scale = 2)
    private BigDecimal montoTotalDeuda;

    @Column(name = "monto_pagado", nullable = false, precision = 10, scale = 2)
    private BigDecimal montoPagado;

    @Column(name = "saldo_pendiente", nullable = false, precision = 10, scale = 2)
    private BigDecimal saldoPendiente;

    @Column(name = "fecha", nullable = false)
    private Instant fecha;
}
