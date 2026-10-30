package pe.edu.upeu.lamb.matricula.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "solicitudes_rectificacion")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SolicitudRectificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_matricula", nullable = false)
    private Long idMatricula;

    @Column(name = "motivo", nullable = false, length = 255)
    private String motivo;

    @Column(name = "estado", nullable = false, length = 30)
    private String estado;

    @Column(name = "fecha_solicitud", nullable = false)
    private Instant fechaSolicitud;
}
