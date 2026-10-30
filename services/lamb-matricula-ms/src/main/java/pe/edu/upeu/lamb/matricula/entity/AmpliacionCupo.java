package pe.edu.upeu.lamb.matricula.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ampliaciones_cupo")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AmpliacionCupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // JALA ID DE PLANIFICACION: la seccion/grupo cuyo cupo se ampliase define en lamb-planificacion-ms.
    @Column(name = "id_seccion", nullable = false)
    private Long idSeccion;

    @Column(name = "cupo_adicional", nullable = false)
    private Integer cupoAdicional;

    @Column(name = "motivo", length = 255)
    private String motivo;

    @Column(name = "autorizado_por", length = 80)
    private String autorizadoPor;
}
