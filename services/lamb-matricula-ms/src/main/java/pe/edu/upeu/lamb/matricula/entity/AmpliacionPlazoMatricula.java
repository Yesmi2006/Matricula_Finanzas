package pe.edu.upeu.lamb.matricula.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "ampliaciones_plazo_matricula")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AmpliacionPlazoMatricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_cronograma", nullable = false)
    private Long idCronograma;

    @Column(name = "fecha_ampliada", nullable = false)
    private LocalDate fechaAmpliada;

    @Column(name = "motivo", nullable = false, length = 255)
    private String motivo;

    @Column(name = "autorizado_por", length = 80)
    private String autorizadoPor;
}
