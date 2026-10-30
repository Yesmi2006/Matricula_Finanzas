package pe.edu.upeu.lamb.finanzas.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

/**
 * CRUD opcional: depende de la universidad. Item 18 del documento: "Detalle de cobro",
 * hijo de composicion real de EstadoCobro (item 17).
 *
 * El item 16 "Descuento aplicado" del documento esta marcado como "JALA ID DE 30 -
 * DESCUENTOS Y BECAS", pero el item 30 ya esta implementado localmente en
 * lamb-finanzas-ms como DescuentoAplicado, por lo que se modela como relacion JPA real
 * (nullable: no todo cargo tiene descuento aplicado).
 */
@Entity
@Table(name = "detalles_cobro")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetalleCobro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_estado_cobro", nullable = false)
    private EstadoCobro estadoCobro;

    @Column(name = "concepto", nullable = false, length = 150)
    private String concepto;

    @Column(name = "monto", nullable = false, precision = 10, scale = 2)
    private BigDecimal monto;

    @ManyToOne
    @JoinColumn(name = "id_descuento_aplicado")
    private DescuentoAplicado descuentoAplicado;
}
