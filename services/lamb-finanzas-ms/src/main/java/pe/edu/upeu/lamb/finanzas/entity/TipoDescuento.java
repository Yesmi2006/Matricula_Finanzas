package pe.edu.upeu.lamb.finanzas.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

/**
 * Lote F3 - Descuentos y becas: catalogo "Tipo de Descuento" (fila sin numero, previa
 * al item 30 "Descuento aplicado" en el documento).
 */
@Entity
@Table(name = "tipos_descuento")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoDescuento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "porcentaje", nullable = false, precision = 5, scale = 2)
    private BigDecimal porcentaje;

    @Column(name = "descripcion", length = 255)
    private String descripcion;
}
