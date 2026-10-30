package pe.edu.upeu.lamb.matricula.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "situaciones_academicas_estudiante")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SituacionAcademicaEstudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_persona", nullable = false)
    private Long idPersona;

    @Column(name = "periodo", nullable = false, length = 20)
    private String periodo;

    @Column(name = "situacion", nullable = false, length = 30)
    private String situacion;

    @Column(name = "fecha_registro", nullable = false)
    private Instant fechaRegistro;
}
