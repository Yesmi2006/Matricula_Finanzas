package pe.edu.upeu.lamb.finanzas.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

/**
 * CRUD opcional: depende de la universidad. Item 35 del documento: "Convenio institucional
 * con descuento (Instituciones Adventistas)".
 */
@Entity
@Table(name = "convenios_institucionales_descuento")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConvenioInstitucionalDescuento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_institucion", nullable = false, length = 150)
    private String nombreInstitucion;

    @Column(name = "porcentaje_descuento", nullable = false, precision = 5, scale = 2)
    private BigDecimal porcentajeDescuento;
}
