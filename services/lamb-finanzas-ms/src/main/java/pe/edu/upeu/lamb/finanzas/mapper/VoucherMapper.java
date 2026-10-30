package pe.edu.upeu.lamb.finanzas.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.finanzas.dto.VoucherResponse;
import pe.edu.upeu.lamb.finanzas.entity.Voucher;

@Component
public class VoucherMapper {

    public VoucherResponse toResponse(Voucher entity) {
        return VoucherResponse.builder()
                .id(entity.getId())
                .idPago(entity.getPago().getId())
                .numeroVoucher(entity.getNumeroVoucher())
                .estado(entity.getEstado())
                .fecha(entity.getFecha())
                .build();
    }
}
