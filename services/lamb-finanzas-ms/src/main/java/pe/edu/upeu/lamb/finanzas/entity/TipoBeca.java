package pe.edu.upeu.lamb.finanzas.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Lote F3 - Descuentos y becas (item 31 del documento): Tipo de Beca.
 */
@Entity
@Table(name = "tipos_beca")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoBeca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "descripcion", length = 255)
    private String descripcion;
}
