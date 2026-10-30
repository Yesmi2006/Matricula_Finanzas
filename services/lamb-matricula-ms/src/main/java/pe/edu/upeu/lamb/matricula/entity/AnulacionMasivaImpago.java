package pe.edu.upeu.lamb.matricula.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "anulaciones_masivas_impago")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnulacionMasivaImpago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "periodo", nullable = false, length = 20)
    private String periodo;

    @Column(name = "total_matriculas_anuladas", nullable = false)
    private Integer totalMatriculasAnuladas;

    @Column(name = "motivo", nullable = false, length = 255)
    private String motivo;

    @Column(name = "fecha_ejecucion", nullable = false)
    private Instant fechaEjecucion;
}
