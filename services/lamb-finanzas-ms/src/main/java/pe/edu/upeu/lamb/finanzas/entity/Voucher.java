package pe.edu.upeu.lamb.finanzas.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

/**
 * Item 27 del documento: "Estado de voucher (aceptado, rechazado y en proceso)". Operacion real.
 * El voucher queda asociado a un Pago local (relacion local real, no es un JALA ID).
 */
@Entity
@Table(name = "vouchers")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Voucher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_pago", nullable = false)
    private Pago pago;

    @Column(name = "numero_voucher", nullable = false, length = 50)
    private String numeroVoucher;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false, length = 20)
    private EstadoVoucherTipo estado;

    @Column(name = "fecha", nullable = false)
    private Instant fecha;
}
