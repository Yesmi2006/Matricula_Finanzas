package pe.edu.upeu.lamb.matricula.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "constancias_matricula")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConstanciaMatricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_matricula", nullable = false)
    private Long idMatricula;

    @Column(name = "fecha_emision", nullable = false)
    private Instant fechaEmision;

    @Column(name = "codigo_verificacion", nullable = false, length = 40)
    private String codigoVerificacion;

    @Column(name = "url_documento", length = 255)
    private String urlDocumento;
}
