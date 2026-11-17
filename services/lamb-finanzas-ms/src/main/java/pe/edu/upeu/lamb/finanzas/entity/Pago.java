package pe.edu.upeu.lamb.finanzas.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Table(name = "pagos")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_persona", nullable = false)
    private Long idPersona;

    // Matricula asociada. Ya no es unica a nivel de columna: puede existir el cargo
    // (PENDIENTE) y el intento de pago del estudiante (EN_PROCESO/APROBADO) para la misma
    // matricula. Unicidad real: indice parcial uk_pagos_matricula_id_activo (solo EN_PROCESO/APROBADO).
    @Column(name = "matricula_id")
    private Long matriculaId;

    @Column(name = "concepto", nullable = false, length = 150)
    private String concepto;

    @Column(name = "monto", nullable = false, precision = 10, scale = 2)
    private BigDecimal monto;

    // Nulo mientras el cargo esta PENDIENTE (recien generado, sin canal de pago elegido todavia).
    @Enumerated(EnumType.STRING)
    @Column(name = "metodo", length = 20)
    private MetodoPago metodo;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false, length = 20)
    private EstadoPago estado;

    @Column(name = "fecha_pago", nullable = false)
    private Instant fechaPago;

    @Column(name = "referencia_externa", length = 100)
    private String referenciaExterna;

    @Column(name = "numero_operacion", length = 50)
    private String numeroOperacion;

    @Column(name = "banco_referencia", length = 100)
    private String bancoReferencia;

    @Column(name = "fecha_voucher")
    private LocalDateTime fechaVoucher;

    // Solo guarda una referencia (ruta o URL) al archivo, no el binario.
    @Column(name = "archivo_voucher", length = 255)
    private String archivoVoucher;
}
