package pe.edu.upeu.lamb.matricula.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

/**
 * CRUD marcado con (*) en el documento de requerimientos: autorizacion excepcional
 * para matricularse por debajo del minimo normal de creditos del periodo.
 */
@Entity
@Table(name = "cargas_minimas_autorizadas")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CargaMinimaAutorizada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_matricula", nullable = false)
    private Long idMatricula;

    @Column(name = "creditos_minimos", nullable = false)
    private Integer creditosMinimos;

    @Column(name = "motivo", nullable = false, length = 255)
    private String motivo;

    @Column(name = "fecha_autorizacion", nullable = false)
    private Instant fechaAutorizacion;
}
