package pe.edu.upeu.lamb.finanzas.dto;

import pe.edu.upeu.lamb.finanzas.entity.EstadoPago;
import pe.edu.upeu.lamb.finanzas.entity.MetodoPago;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PagoResponse {
    private Long id;
    private Long idPersona;
    private Long matriculaId;
    private String concepto;
    private BigDecimal monto;
    private MetodoPago metodo;
    private EstadoPago estado;
    private Instant fechaPago;
    private String referenciaExterna;
    private String numeroOperacion;
    private String bancoReferencia;
    private LocalDateTime fechaVoucher;
    private String archivoVoucher;
}
