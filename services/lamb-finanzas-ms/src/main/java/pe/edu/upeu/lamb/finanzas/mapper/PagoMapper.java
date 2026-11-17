package pe.edu.upeu.lamb.finanzas.mapper;

import pe.edu.upeu.lamb.finanzas.dto.PagoRequest;
import pe.edu.upeu.lamb.finanzas.dto.PagoResponse;
import pe.edu.upeu.lamb.finanzas.entity.EstadoPago;
import pe.edu.upeu.lamb.finanzas.entity.Pago;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class PagoMapper {

    public Pago toEntity(PagoRequest request) {
        return Pago.builder()
                .idPersona(request.getIdPersona())
                .matriculaId(request.getMatriculaId())
                .concepto(request.getConcepto())
                .monto(request.getMonto())
                .metodo(request.getMetodo())
                .estado(EstadoPago.PENDIENTE)
                .fechaPago(Instant.now())
                .numeroOperacion(request.getNumeroOperacion())
                .bancoReferencia(request.getBancoReferencia())
                .fechaVoucher(request.getFechaVoucher())
                .archivoVoucher(request.getArchivoVoucher())
                .build();
    }

    public PagoResponse toResponse(Pago pago) {
        return PagoResponse.builder()
                .id(pago.getId())
                .idPersona(pago.getIdPersona())
                .matriculaId(pago.getMatriculaId())
                .concepto(pago.getConcepto())
                .monto(pago.getMonto())
                .metodo(pago.getMetodo())
                .estado(pago.getEstado())
                .fechaPago(pago.getFechaPago())
                .referenciaExterna(pago.getReferenciaExterna())
                .numeroOperacion(pago.getNumeroOperacion())
                .bancoReferencia(pago.getBancoReferencia())
                .fechaVoucher(pago.getFechaVoucher())
                .archivoVoucher(pago.getArchivoVoucher())
                .build();
    }
}
