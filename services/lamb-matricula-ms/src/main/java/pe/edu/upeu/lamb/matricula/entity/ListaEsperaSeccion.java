package pe.edu.upeu.lamb.matricula.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "listas_espera_seccion")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListaEsperaSeccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // JALA ID DE PLANIFICACION: la seccion la define y mantiene lamb-planificacion-ms.
    @Column(name = "id_seccion", nullable = false)
    private Long idSeccion;

    @Column(name = "id_persona", nullable = false)
    private Long idPersona;

    @Column(name = "posicion", nullable = false)
    private Integer posicion;

    @Column(name = "fecha_inscripcion", nullable = false)
    private LocalDate fechaInscripcion;
}
