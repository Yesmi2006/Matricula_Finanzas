package pe.edu.upeu.lamb.finanzas.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

/**
 * Item 59 del documento: "Constancia de no adeudo (JALA ID 17 - COBROS)". Operacion real.
 * El documento marca este item como JALA ID 17, y el item 17 (Estado de cobro) ya esta
 * implementado localmente como la entidad EstadoCobro, por lo que se usa una referencia
 * real local en vez de un campo externo sin FK.
 */
@Entity
@Table(name = "constancias_no_adeudo")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConstanciaNoAdeudo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_estado_cobro", nullable = false)
    private EstadoCobro estadoCobro;

    @Column(name = "codigo_constancia", nullable = false, length = 50, unique = true)
    private String codigoConstancia;

    @Column(name = "fecha_emision", nullable = false)
    private Instant fechaEmision;
}
