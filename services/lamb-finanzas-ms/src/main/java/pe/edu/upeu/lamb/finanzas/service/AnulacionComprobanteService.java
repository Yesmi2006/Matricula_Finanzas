package pe.edu.upeu.lamb.finanzas.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.upeu.lamb.finanzas.dto.AnulacionComprobanteRequest;
import pe.edu.upeu.lamb.finanzas.dto.AnulacionComprobanteResponse;
import pe.edu.upeu.lamb.finanzas.entity.AnulacionComprobante;
import pe.edu.upeu.lamb.finanzas.entity.DocumentoPago;
import pe.edu.upeu.lamb.finanzas.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.finanzas.mapper.AnulacionComprobanteMapper;
import pe.edu.upeu.lamb.finanzas.repository.AnulacionComprobanteRepository;
import pe.edu.upeu.lamb.finanzas.repository.DocumentoPagoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class AnulacionComprobanteService {

    private final AnulacionComprobanteRepository anulacionComprobanteRepository;
    private final DocumentoPagoRepository documentoPagoRepository;
    private final AnulacionComprobanteMapper anulacionComprobanteMapper;

    public List<AnulacionComprobanteResponse> listar() {
        return anulacionComprobanteRepository.findAll().stream()
                .map(anulacionComprobanteMapper::toResponse)
                .collect(Collectors.toList());
    }

    public AnulacionComprobanteResponse obtener(Long id) {
        return anulacionComprobanteMapper.toResponse(buscarOFallar(id));
    }

    public AnulacionComprobanteResponse crear(AnulacionComprobanteRequest request) {
        DocumentoPago documentoPago = documentoPagoRepository.findById(request.getIdDocumentoPago())
                .orElseThrow(() -> new ResourceNotFoundException("Documento de pago no encontrado con id: " + request.getIdDocumentoPago()));

        AnulacionComprobante entity = AnulacionComprobante.builder()
                .documentoPago(documentoPago)
                .motivo(request.getMotivo())
                .fecha(request.getFecha())
                .build();

        AnulacionComprobante guardado = anulacionComprobanteRepository.save(entity);
        log.info("Anulacion de comprobante creada con id: {}", guardado.getId());
        return anulacionComprobanteMapper.toResponse(guardado);
    }

    private AnulacionComprobante buscarOFallar(Long id) {
        return anulacionComprobanteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Anulacion de comprobante no encontrada con id: " + id));
    }
}
