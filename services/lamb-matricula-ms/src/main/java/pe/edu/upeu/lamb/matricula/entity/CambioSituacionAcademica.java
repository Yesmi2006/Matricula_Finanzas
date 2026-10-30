package pe.edu.upeu.lamb.matricula.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "cambios_situacion_academica")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CambioSituacionAcademica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_situacion_academica", nullable = false)
    private Long idSituacionAcademica;

    @Column(name = "situacion_anterior", length = 30)
    private String situacionAnterior;

    @Column(name = "situacion_nueva", nullable = false, length = 30)
    private String situacionNueva;

    @Column(name = "resolucion", nullable = false, length = 255)
    private String resolucion;

    @Column(name = "fecha_cambio", nullable = false)
    private Instant fechaCambio;
}
