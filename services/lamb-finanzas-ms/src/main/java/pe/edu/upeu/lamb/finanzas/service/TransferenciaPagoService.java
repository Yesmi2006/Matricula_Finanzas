package pe.edu.upeu.lamb.finanzas.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.upeu.lamb.finanzas.dto.TransferenciaPagoRequest;
import pe.edu.upeu.lamb.finanzas.dto.TransferenciaPagoResponse;
import pe.edu.upeu.lamb.finanzas.entity.ConceptoPago;
import pe.edu.upeu.lamb.finanzas.entity.Pago;
import pe.edu.upeu.lamb.finanzas.entity.TransferenciaPago;
import pe.edu.upeu.lamb.finanzas.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.finanzas.mapper.TransferenciaPagoMapper;
import pe.edu.upeu.lamb.finanzas.repository.ConceptoPagoRepository;
import pe.edu.upeu.lamb.finanzas.repository.PagoRepository;
import pe.edu.upeu.lamb.finanzas.repository.TransferenciaPagoRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransferenciaPagoService {

    private final TransferenciaPagoRepository transferenciaPagoRepository;
    private final PagoRepository pagoRepository;
    private final ConceptoPagoRepository conceptoPagoRepository;
    private final TransferenciaPagoMapper transferenciaPagoMapper;

    public List<TransferenciaPagoResponse> listar() {
        return transferenciaPagoRepository.findAll().stream()
                .map(transferenciaPagoMapper::toResponse)
                .toList();
    }

    public TransferenciaPagoResponse obtener(Long id) {
        return transferenciaPagoMapper.toResponse(buscarOFallar(id));
    }

    public TransferenciaPagoResponse crear(TransferenciaPagoRequest request) {
        Pago pago = pagoRepository.findById(request.getIdPago())
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro el pago con id " + request.getIdPago()));
        ConceptoPago conceptoOrigen = conceptoPagoRepository.findById(request.getIdConceptoOrigen())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "No se encontro el concepto de pago origen con id " + request.getIdConceptoOrigen()));
        ConceptoPago conceptoDestino = conceptoPagoRepository.findById(request.getIdConceptoDestino())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "No se encontro el concepto de pago destino con id " + request.getIdConceptoDestino()));

        TransferenciaPago entity = TransferenciaPago.builder()
                .pago(pago)
                .conceptoOrigen(conceptoOrigen)
                .conceptoDestino(conceptoDestino)
                .monto(request.getMonto())
                .fecha(request.getFecha())
                .build();

        return transferenciaPagoMapper.toResponse(transferenciaPagoRepository.save(entity));
    }

    private TransferenciaPago buscarOFallar(Long id) {
        return transferenciaPagoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro la transferencia de pago con id " + id));
    }
}
