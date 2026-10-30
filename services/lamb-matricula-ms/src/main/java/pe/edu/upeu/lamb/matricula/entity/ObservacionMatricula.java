package pe.edu.upeu.lamb.matricula.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "observaciones_matricula")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ObservacionMatricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_matricula", nullable = false)
    private Long idMatricula;

    @Column(name = "observacion", nullable = false, length = 500)
    private String observacion;

    @Column(name = "fecha_observacion", nullable = false)
    private Instant fechaObservacion;

    @Column(name = "usuario_registro", length = 80)
    private String usuarioRegistro;
}
