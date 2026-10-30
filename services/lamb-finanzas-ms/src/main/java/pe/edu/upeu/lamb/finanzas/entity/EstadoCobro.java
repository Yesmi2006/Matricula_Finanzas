package pe.edu.upeu.lamb.finanzas.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

/**
 * Lote Cobros (item 17 del documento): Estado de cobro (con deuda, sin deuda).
 * El documento marca este item como "JALA ID 15", y el item 15 (Saldo de Estudiante)
 * a su vez es JALA ID DE 64 (Catalogos y tarifas), que ya esta implementado localmente
 * como la entidad CuentaEstudiante. Por eso la referencia es una relacion real local
 * hacia CuentaEstudiante, en vez de un simple campo externo sin FK.
 */
@Entity
@Table(name = "estados_cobro")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EstadoCobro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cuenta_estudiante", nullable = false)
    private CuentaEstudiante cuentaEstudiante;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false, length = 20)
    private EstadoCobroTipo estado;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;
}
