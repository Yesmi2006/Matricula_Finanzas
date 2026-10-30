package pe.edu.upeu.lamb.matricula.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "retiros_oficio")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RetiroOficio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_matricula", nullable = false)
    private Long idMatricula;

    @Column(name = "motivo", nullable = false, length = 255)
    private String motivo;

    @Column(name = "fecha_retiro", nullable = false)
    private Instant fechaRetiro;
}
