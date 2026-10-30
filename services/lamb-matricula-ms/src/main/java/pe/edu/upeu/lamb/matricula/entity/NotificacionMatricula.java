package pe.edu.upeu.lamb.matricula.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "notificaciones_matricula")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificacionMatricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_matricula", nullable = false)
    private Long idMatricula;

    @Column(name = "tipo", nullable = false, length = 40)
    private String tipo;

    @Column(name = "canal", nullable = false, length = 20)
    private String canal;

    @Column(name = "fecha_envio", nullable = false)
    private Instant fechaEnvio;

    @Column(name = "estado_envio", length = 20)
    private String estadoEnvio;
}
