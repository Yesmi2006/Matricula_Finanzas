package pe.edu.upeu.lamb.finanzas.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * CRUD marcado con (*) en el documento: "Categoria de concepto (OTRO CRUD)" se modela
 * como catalogo propio, separado de Concepto de pago, para fusion posterior con el equipo.
 */
@Entity
@Table(name = "categorias_concepto")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaConcepto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "descripcion", length = 255)
    private String descripcion;
}
