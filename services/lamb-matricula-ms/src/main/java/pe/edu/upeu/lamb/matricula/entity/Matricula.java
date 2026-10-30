package pe.edu.upeu.lamb.matricula.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "matriculas")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_persona", nullable = false)
    private Long idPersona;

    @Column(name = "periodo", nullable = false, length = 20)
    private String periodo;

    @Column(name = "fecha", nullable = false)
    private Instant fecha;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false, length = 20)
    private EstadoMatricula estado;

    @Builder.Default
    @OneToMany(mappedBy = "matricula", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<DetalleMatricula> detalles = new ArrayList<>();

    /**
     * Relacion muchos a muchos real: una matricula puede tener varias condiciones
     * (ingresante, reingresante, repitente, traslado) y cada condicion aplica a
     * muchas matriculas. Tabla intermedia matricula_condicion.
     */
    @Builder.Default
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "matricula_condicion",
            joinColumns = @JoinColumn(name = "id_matricula"),
            inverseJoinColumns = @JoinColumn(name = "id_condicion")
    )
    private List<CondicionMatricula> condiciones = new ArrayList<>();
}
