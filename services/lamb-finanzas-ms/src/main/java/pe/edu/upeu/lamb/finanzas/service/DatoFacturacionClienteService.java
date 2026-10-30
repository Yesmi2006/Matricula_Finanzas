package pe.edu.upeu.lamb.finanzas.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.upeu.lamb.finanzas.dto.DatoFacturacionClienteRequest;
import pe.edu.upeu.lamb.finanzas.dto.DatoFacturacionClienteResponse;
import pe.edu.upeu.lamb.finanzas.entity.DatoFacturacionCliente;
import pe.edu.upeu.lamb.finanzas.entity.DocumentoPago;
import pe.edu.upeu.lamb.finanzas.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.finanzas.mapper.DatoFacturacionClienteMapper;
import pe.edu.upeu.lamb.finanzas.repository.DatoFacturacionClienteRepository;
import pe.edu.upeu.lamb.finanzas.repository.DocumentoPagoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class DatoFacturacionClienteService {

    private final DatoFacturacionClienteRepository datoFacturacionClienteRepository;
    private final DocumentoPagoRepository documentoPagoRepository;
    private final DatoFacturacionClienteMapper datoFacturacionClienteMapper;

    public List<DatoFacturacionClienteResponse> listar() {
        return datoFacturacionClienteRepository.findAll().stream()
                .map(datoFacturacionClienteMapper::toResponse)
                .collect(Collectors.toList());
    }

    public DatoFacturacionClienteResponse obtener(Long id) {
        return datoFacturacionClienteMapper.toResponse(buscarOFallar(id));
    }

    public DatoFacturacionClienteResponse crear(DatoFacturacionClienteRequest request) {
        DocumentoPago documentoPago = documentoPagoRepository.findById(request.getIdDocumentoPago())
                .orElseThrow(() -> new ResourceNotFoundException("Documento de pago no encontrado con id: " + request.getIdDocumentoPago()));

        DatoFacturacionCliente entity = DatoFacturacionCliente.builder()
                .documentoPago(documentoPago)
                .dni(request.getDni())
                .ruc(request.getRuc())
                .razonSocial(request.getRazonSocial())
                .build();

        DatoFacturacionCliente guardado = datoFacturacionClienteRepository.save(entity);
        log.info("Dato de facturacion del cliente creado con id: {}", guardado.getId());
        return datoFacturacionClienteMapper.toResponse(guardado);
    }

    private DatoFacturacionCliente buscarOFallar(Long id) {
        return datoFacturacionClienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dato de facturacion del cliente no encontrado con id: " + id));
    }
}
