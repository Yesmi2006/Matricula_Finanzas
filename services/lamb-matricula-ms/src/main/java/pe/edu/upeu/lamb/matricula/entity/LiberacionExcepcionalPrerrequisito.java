package pe.edu.upeu.lamb.matricula.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

/**
 * CRUD marcado con (*) en el documento de requerimientos: excepcion administrativa
 * poco frecuente, usada solo cuando la escuela autoriza saltarse un prerrequisito.
 * idCurso e idPrerrequisito referencian al microservicio de Curriculo (JALA ID).
 */
@Entity
@Table(name = "liberaciones_excepcionales_prerrequisito")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LiberacionExcepcionalPrerrequisito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_persona", nullable = false)
    private Long idPersona;

    // JALA ID DE CURRICULO
    @Column(name = "id_curso", nullable = false)
    private Long idCurso;

    // JALA ID DE CURRICULO
    @Column(name = "id_prerrequisito", nullable = false)
    private Long idPrerrequisito;

    @Column(name = "motivo", nullable = false, length = 255)
    private String motivo;

    @Column(name = "fecha_autorizacion", nullable = false)
    private Instant fechaAutorizacion;
}
