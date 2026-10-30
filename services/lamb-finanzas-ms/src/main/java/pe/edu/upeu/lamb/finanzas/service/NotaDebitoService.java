package pe.edu.upeu.lamb.finanzas.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.upeu.lamb.finanzas.dto.NotaDebitoRequest;
import pe.edu.upeu.lamb.finanzas.dto.NotaDebitoResponse;
import pe.edu.upeu.lamb.finanzas.entity.DocumentoPago;
import pe.edu.upeu.lamb.finanzas.entity.NotaDebito;
import pe.edu.upeu.lamb.finanzas.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.finanzas.mapper.NotaDebitoMapper;
import pe.edu.upeu.lamb.finanzas.repository.DocumentoPagoRepository;
import pe.edu.upeu.lamb.finanzas.repository.NotaDebitoRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * CRUD marcado con (*) en el documento: "Nota de debito". Opcional.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class NotaDebitoService {

    private final NotaDebitoRepository notaDebitoRepository;
    private final DocumentoPagoRepository documentoPagoRepository;
    private final NotaDebitoMapper notaDebitoMapper;

    public List<NotaDebitoResponse> listar() {
        return notaDebitoRepository.findAll().stream()
                .map(notaDebitoMapper::toResponse)
                .collect(Collectors.toList());
    }

    public NotaDebitoResponse obtener(Long id) {
        return notaDebitoMapper.toResponse(buscarOFallar(id));
    }

    public NotaDebitoResponse crear(NotaDebitoRequest request) {
        DocumentoPago documentoPago = documentoPagoRepository.findById(request.getIdDocumentoPago())
                .orElseThrow(() -> new ResourceNotFoundException("Documento de pago no encontrado con id: " + request.getIdDocumentoPago()));

        NotaDebito entity = NotaDebito.builder()
                .documentoPago(documentoPago)
                .motivo(request.getMotivo())
                .monto(request.getMonto())
                .fecha(request.getFecha())
                .build();

        NotaDebito guardado = notaDebitoRepository.save(entity);
        log.info("Nota de debito creada con id: {}", guardado.getId());
        return notaDebitoMapper.toResponse(guardado);
    }

    private NotaDebito buscarOFallar(Long id) {
        return notaDebitoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nota de debito no encontrada con id: " + id));
    }
}
