package pe.edu.upeu.lamb.matricula.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

/**
 * idSeccion1/idSeccion2 referencian al microservicio de Planificacion (JALA ID),
 * igual que idSeccion en DetalleMatricula: no son FK locales.
 */
@Entity
@Table(name = "cruces_horario_autorizados")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CruceHorarioAutorizado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_matricula", nullable = false)
    private Long idMatricula;

    // JALA ID DE PLANIFICACION
    @Column(name = "id_seccion_1", nullable = false)
    private Long idSeccion1;

    // JALA ID DE PLANIFICACION
    @Column(name = "id_seccion_2", nullable = false)
    private Long idSeccion2;

    @Column(name = "motivo", nullable = false, length = 255)
    private String motivo;

    @Column(name = "fecha_autorizacion", nullable = false)
    private Instant fechaAutorizacion;
}
