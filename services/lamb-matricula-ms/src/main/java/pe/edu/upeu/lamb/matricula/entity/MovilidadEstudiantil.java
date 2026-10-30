package pe.edu.upeu.lamb.matricula.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

/**
 * CRUD opcional (depende de la universidad): movilidad / intercambio estudiantil.
 * No todas las instituciones ofrecen convenios de movilidad, por eso este CRUD
 * se marca como Opcional en el documento de requerimientos.
 */
@Entity
@Table(name = "movilidades_estudiantiles")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovilidadEstudiantil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_persona", nullable = false)
    private Long idPersona;

    @Column(name = "institucion_destino", nullable = false, length = 150)
    private String institucionDestino;

    @Column(name = "tipo_movilidad", nullable = false, length = 20)
    private String tipoMovilidad;

    @Column(name = "periodo", nullable = false, length = 20)
    private String periodo;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @Column(name = "estado", length = 20)
    private String estado;
}
