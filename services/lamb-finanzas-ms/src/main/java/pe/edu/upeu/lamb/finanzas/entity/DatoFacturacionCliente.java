package pe.edu.upeu.lamb.finanzas.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Item 39 del documento: "Datos de facturacion del cliente (DNI, RUC, razon social)". Operacion real.
 */
@Entity
@Table(name = "datos_facturacion_cliente")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DatoFacturacionCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_documento_pago", nullable = false)
    private DocumentoPago documentoPago;

    @Column(name = "dni", length = 15)
    private String dni;

    @Column(name = "ruc", length = 15)
    private String ruc;

    @Column(name = "razon_social", length = 150)
    private String razonSocial;
}
