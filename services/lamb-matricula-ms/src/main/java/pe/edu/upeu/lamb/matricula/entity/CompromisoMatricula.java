package pe.edu.upeu.lamb.matricula.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "compromisos_matricula")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompromisoMatricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_matricula", nullable = false)
    private Long idMatricula;

    @Column(name = "monto_comprometido", nullable = false, precision = 10, scale = 2)
    private BigDecimal montoComprometido;

    @Column(name = "fecha_firma", nullable = false)
    private LocalDate fechaFirma;

    @Column(name = "documento_url", length = 255)
    private String documentoUrl;
}
