package pe.edu.upeu.lamb.matricula.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "cargas_academicas_periodo")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CargaAcademicaPeriodo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_persona", nullable = false)
    private Long idPersona;

    @Column(name = "periodo", nullable = false, length = 20)
    private String periodo;

    @Column(name = "total_creditos", nullable = false)
    private Integer totalCreditos;

    @Column(name = "total_cursos", nullable = false)
    private Integer totalCursos;

    @Column(name = "fecha_calculo", nullable = false)
    private Instant fechaCalculo;
}
