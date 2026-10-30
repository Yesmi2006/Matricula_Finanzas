package pe.edu.upeu.lamb.matricula.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

/**
 * idCurso referencia al microservicio de Curriculo (JALA ID): el catalogo de cursos
 * electivos vive en Curriculo, aqui solo se registra la eleccion de la persona.
 */
@Entity
@Table(name = "elecciones_curso_electivo")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EleccionCursoElectivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_persona", nullable = false)
    private Long idPersona;

    // JALA ID DE CURRICULO
    @Column(name = "id_curso", nullable = false)
    private Long idCurso;

    @Column(name = "periodo", nullable = false, length = 20)
    private String periodo;

    @Column(name = "fecha_eleccion", nullable = false)
    private Instant fechaEleccion;
}
