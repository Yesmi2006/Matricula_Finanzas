package pe.edu.upeu.lamb.matricula.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

/**
 * Registra el numero de intento (1ra, 2da, 3ra matricula) de una persona en un curso.
 * idCurso referencia al microservicio de Curriculo (JALA ID): no se modela como FK local,
 * solo se guarda el identificador para que el equipo de Curriculo lo resuelva en su fusion.
 */
@Entity
@Table(name = "intentos_curso")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IntentoCurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_persona", nullable = false)
    private Long idPersona;

    // JALA ID DE CURRICULO: identificador de curso gestionado por el microservicio de Curriculo.
    @Column(name = "id_curso", nullable = false)
    private Long idCurso;

    @Column(name = "numero_intento", nullable = false)
    private Integer numeroIntento;

    @Column(name = "periodo", nullable = false, length = 20)
    private String periodo;

    @Column(name = "fecha_registro", nullable = false)
    private Instant fechaRegistro;
}
