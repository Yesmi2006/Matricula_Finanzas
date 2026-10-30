package pe.edu.upeu.lamb.finanzas.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Lote F3 - Descuentos y becas (item 30 del documento): Descuento aplicado.
 */
@Entity
@Table(name = "descuentos_aplicados")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DescuentoAplicado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // JALA ID DE USUARIOS/PERSONAS: la persona/estudiante es dato propio de otro microservicio, no se duplica aqui.
    @Column(name = "id_persona", nullable = false)
    private Long idPersona;

    @ManyToOne
    @JoinColumn(name = "id_tipo_descuento", nullable = false)
    private TipoDescuento tipoDescuento;

    @Column(name = "porcentaje", nullable = false, precision = 5, scale = 2)
    private BigDecimal porcentaje;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;
}
