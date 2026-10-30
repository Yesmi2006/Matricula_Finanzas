package pe.edu.upeu.lamb.matricula.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

/** CRUD opcional: depende de la universidad. */
@Entity
@Table(name = "retiros_inasistencia")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RetiroInasistencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_matricula", nullable = false)
    private Long idMatricula;

    @Column(name = "numero_inasistencias", nullable = false)
    private Integer numeroInasistencias;

    @Column(name = "fecha_retiro", nullable = false)
    private Instant fechaRetiro;
}
