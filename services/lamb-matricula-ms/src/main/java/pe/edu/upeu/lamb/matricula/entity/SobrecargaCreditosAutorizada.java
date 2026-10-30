package pe.edu.upeu.lamb.matricula.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

/**
 * CRUD marcado con (*) en el documento de requerimientos: autorizacion excepcional
 * para matricularse por encima del tope normal de creditos del periodo.
 */
@Entity
@Table(name = "sobrecargas_creditos_autorizadas")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SobrecargaCreditosAutorizada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_matricula", nullable = false)
    private Long idMatricula;

    @Column(name = "creditos_autorizados", nullable = false)
    private Integer creditosAutorizados;

    @Column(name = "motivo", nullable = false, length = 255)
    private String motivo;

    @Column(name = "fecha_autorizacion", nullable = false)
    private Instant fechaAutorizacion;
}
