package pe.edu.upeu.lamb.matricula.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "matriculas_condicionales")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MatriculaCondicional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_matricula", nullable = false)
    private Long idMatricula;

    @Column(name = "motivo", nullable = false, length = 255)
    private String motivo;

    @Column(name = "fecha_condicion", nullable = false)
    private LocalDate fechaCondicion;

    @Column(name = "levantada", nullable = false)
    private Boolean levantada;
}
