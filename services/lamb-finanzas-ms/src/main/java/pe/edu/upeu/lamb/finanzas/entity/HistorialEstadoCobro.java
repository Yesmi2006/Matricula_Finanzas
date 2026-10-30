package pe.edu.upeu.lamb.finanzas.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

/**
 * Item 20 del documento: "Historial de estados del cobro", hijo de composicion real
 * de EstadoCobro (item 17), registra cada cambio de estado a lo largo del tiempo.
 */
@Entity
@Table(name = "historiales_estado_cobro")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HistorialEstadoCobro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_estado_cobro", nullable = false)
    private EstadoCobro estadoCobro;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false, length = 20)
    private EstadoCobroTipo estado;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;
}
