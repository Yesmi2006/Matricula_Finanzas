package pe.edu.upeu.lamb.finanzas.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.upeu.lamb.finanzas.dto.DocumentoPagoRequest;
import pe.edu.upeu.lamb.finanzas.dto.DocumentoPagoResponse;
import pe.edu.upeu.lamb.finanzas.entity.DocumentoPago;
import pe.edu.upeu.lamb.finanzas.entity.Pago;
import pe.edu.upeu.lamb.finanzas.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.finanzas.mapper.DocumentoPagoMapper;
import pe.edu.upeu.lamb.finanzas.repository.DocumentoPagoRepository;
import pe.edu.upeu.lamb.finanzas.repository.PagoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class DocumentoPagoService {

    private final DocumentoPagoRepository documentoPagoRepository;
    private final PagoRepository pagoRepository;
    private final DocumentoPagoMapper documentoPagoMapper;

    public List<DocumentoPagoResponse> listar() {
        return documentoPagoRepository.findAll().stream()
                .map(documentoPagoMapper::toResponse)
                .collect(Collectors.toList());
    }

    public DocumentoPagoResponse obtener(Long id) {
        return documentoPagoMapper.toResponse(buscarOFallar(id));
    }

    public DocumentoPagoResponse crear(DocumentoPagoRequest request) {
        Pago pago = pagoRepository.findById(request.getIdPago())
                .orElseThrow(() -> new ResourceNotFoundException("Pago no encontrado con id: " + request.getIdPago()));

        DocumentoPago entity = DocumentoPago.builder()
                .pago(pago)
                .tipo(request.getTipo())
                .serie(request.getSerie())
                .correlativo(request.getCorrelativo())
                .monto(request.getMonto())
                .fechaEmision(request.getFechaEmision())
                .build();

        DocumentoPago guardado = documentoPagoRepository.save(entity);
        log.info("Documento de pago creado con id: {}", guardado.getId());
        return documentoPagoMapper.toResponse(guardado);
    }

    private DocumentoPago buscarOFallar(Long id) {
        return documentoPagoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Documento de pago no encontrado con id: " + id));
    }
}
