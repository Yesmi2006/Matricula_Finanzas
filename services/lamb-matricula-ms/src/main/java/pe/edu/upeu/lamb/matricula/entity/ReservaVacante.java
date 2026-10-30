package pe.edu.upeu.lamb.matricula.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "reservas_vacante")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservaVacante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // JALA ID DE PLANIFICACION: la seccion/grupo (cupo, apertura y cierre) la define
    // y mantiene lamb-planificacion-ms. Aqui solo se referencia su id externo, sin FK local.
    @Column(name = "id_seccion", nullable = false)
    private Long idSeccion;

    @Column(name = "id_persona", nullable = false)
    private Long idPersona;

    @Column(name = "fecha_reserva", nullable = false)
    private LocalDate fechaReserva;

    @Column(name = "vigencia_hasta", nullable = false)
    private LocalDate vigenciaHasta;

    @Column(name = "estado", length = 20, nullable = false)
    private String estado;
}
