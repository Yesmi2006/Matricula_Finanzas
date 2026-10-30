package pe.edu.upeu.lamb.finanzas.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tarifarios_escuela_ciclo")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TarifarioEscuelaCiclo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_concepto_pago", nullable = false)
    private ConceptoPago conceptoPago;

    // JALA ID DE CURRICULO: escuela es dato propio de Curriculo, no se duplica aqui.
    @Column(name = "id_escuela", nullable = false)
    private Long idEscuela;

    @Column(name = "ciclo", nullable = false, length = 20)
    private String ciclo;

    @Column(name = "monto", nullable = false, precision = 10, scale = 2)
    private BigDecimal monto;
}
