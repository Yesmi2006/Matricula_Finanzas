package pe.edu.upeu.lamb.matricula.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * Evento pago.aceptado del topic pago-aceptado-eventos (key = idPersona). Lo publica finanzas
 * cuando ADMIN/COORDINADOR acepta un pago EN_PROCESO; lo consume matricula para confirmar
 * la matricula asociada (saga paga-antes-de-confirmar).
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PagoAceptadoEvento {

    private String tipoEvento;
    private Long idPago;
    private Long matriculaId;
    private Long idPersona;
    private BigDecimal monto;
    private Instant fechaAceptacion;
}
