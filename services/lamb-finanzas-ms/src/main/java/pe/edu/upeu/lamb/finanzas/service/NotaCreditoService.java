package pe.edu.upeu.lamb.finanzas.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.upeu.lamb.finanzas.dto.NotaCreditoRequest;
import pe.edu.upeu.lamb.finanzas.dto.NotaCreditoResponse;
import pe.edu.upeu.lamb.finanzas.entity.DocumentoPago;
import pe.edu.upeu.lamb.finanzas.entity.NotaCredito;
import pe.edu.upeu.lamb.finanzas.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.finanzas.mapper.NotaCreditoMapper;
import pe.edu.upeu.lamb.finanzas.repository.DocumentoPagoRepository;
import pe.edu.upeu.lamb.finanzas.repository.NotaCreditoRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * CRUD marcado con (*) en el documento: "Nota de credito". Opcional.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class NotaCreditoService {

    private final NotaCreditoRepository notaCreditoRepository;
    private final DocumentoPagoRepository documentoPagoRepository;
    private final NotaCreditoMapper notaCreditoMapper;

    public List<NotaCreditoResponse> listar() {
        return notaCreditoRepository.findAll().stream()
                .map(notaCreditoMapper::toResponse)
                .collect(Collectors.toList());
    }

    public NotaCreditoResponse obtener(Long id) {
        return notaCreditoMapper.toResponse(buscarOFallar(id));
    }

    public NotaCreditoResponse crear(NotaCreditoRequest request) {
        DocumentoPago documentoPago = documentoPagoRepository.findById(request.getIdDocumentoPago())
                .orElseThrow(() -> new ResourceNotFoundException("Documento de pago no encontrado con id: " + request.getIdDocumentoPago()));

        NotaCredito entity = NotaCredito.builder()
                .documentoPago(documentoPago)
                .motivo(request.getMotivo())
                .monto(request.getMonto())
                .fecha(request.getFecha())
                .build();

        NotaCredito guardado = notaCreditoRepository.save(entity);
        log.info("Nota de credito creada con id: {}", guardado.getId());
        return notaCreditoMapper.toResponse(guardado);
    }

    private NotaCredito buscarOFallar(Long id) {
        return notaCreditoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nota de credito no encontrada con id: " + id));
    }
}
