package pe.edu.upeu.lamb.finanzas.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

/**
 * Item 54 del documento: "Cancelacion de cargo por anulacion de matricula". Operacion real.
 * El cargo (pago) cancelado es un registro local de este microservicio, por lo que se usa
 * una referencia real. La matricula anulada que origina esta cancelacion pertenece a
 * lamb-matricula-ms y se conserva solo como identificador externo.
 */
@Entity
@Table(name = "cancelaciones_cargo_matricula")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CancelacionCargoMatricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_pago", nullable = false)
    private Pago pago;

    // JALA ID DE MATRICULA: la matricula anulada que origina esta cancelacion se gestiona en lamb-matricula-ms.
    @Column(name = "id_matricula", nullable = false)
    private Long idMatricula;

    @Column(name = "motivo", nullable = false, length = 255)
    private String motivo;

    @Column(name = "fecha", nullable = false)
    private Instant fecha;
}
