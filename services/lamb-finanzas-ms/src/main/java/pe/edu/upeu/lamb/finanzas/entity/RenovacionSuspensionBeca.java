package pe.edu.upeu.lamb.finanzas.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

/**
 * Lote F3 - Descuentos y becas (item 33 del documento): Renovacion o suspension de beca.
 * Hijo de composicion real de BecaAplicada (pertenece exclusivamente a esa beca).
 */
@Entity
@Table(name = "renovaciones_suspensiones_beca")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RenovacionSuspensionBeca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_beca_aplicada", nullable = false)
    private BecaAplicada becaAplicada;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false, length = 20)
    private TipoMovimientoBeca tipo;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "motivo", length = 255)
    private String motivo;
}
