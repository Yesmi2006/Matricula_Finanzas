package pe.edu.upeu.lamb.finanzas.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.upeu.lamb.finanzas.dto.VoucherRequest;
import pe.edu.upeu.lamb.finanzas.dto.VoucherResponse;
import pe.edu.upeu.lamb.finanzas.entity.Pago;
import pe.edu.upeu.lamb.finanzas.entity.Voucher;
import pe.edu.upeu.lamb.finanzas.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.finanzas.mapper.VoucherMapper;
import pe.edu.upeu.lamb.finanzas.repository.PagoRepository;
import pe.edu.upeu.lamb.finanzas.repository.VoucherRepository;

import java.util.List;

/**
 * Item 27 del documento: "Estado de voucher (aceptado, rechazado y en proceso)".
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class VoucherService {

    private final VoucherRepository voucherRepository;
    private final PagoRepository pagoRepository;
    private final VoucherMapper voucherMapper;

    public List<VoucherResponse> listar() {
        return voucherRepository.findAll().stream()
                .map(voucherMapper::toResponse)
                .toList();
    }

    public VoucherResponse obtener(Long id) {
        return voucherMapper.toResponse(buscarOFallar(id));
    }

    public VoucherResponse crear(VoucherRequest request) {
        Pago pago = pagoRepository.findById(request.getIdPago())
                .orElseThrow(() -> new ResourceNotFoundException("Pago no encontrado: " + request.getIdPago()));

        Voucher entity = Voucher.builder()
                .pago(pago)
                .numeroVoucher(request.getNumeroVoucher())
                .estado(request.getEstado())
                .fecha(request.getFecha())
                .build();

        Voucher guardado = voucherRepository.save(entity);
        return voucherMapper.toResponse(guardado);
    }

    private Voucher buscarOFallar(Long id) {
        return voucherRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Voucher no encontrado: " + id));
    }
}
