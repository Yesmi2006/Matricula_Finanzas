package pe.edu.upeu.lamb.finanzas.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upeu.lamb.finanzas.dto.ConceptoPagoRequest;
import pe.edu.upeu.lamb.finanzas.dto.ConceptoPagoResponse;
import pe.edu.upeu.lamb.finanzas.entity.CategoriaConcepto;
import pe.edu.upeu.lamb.finanzas.entity.ConceptoPago;
import pe.edu.upeu.lamb.finanzas.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.finanzas.mapper.ConceptoPagoMapper;
import pe.edu.upeu.lamb.finanzas.repository.CategoriaConceptoRepository;
import pe.edu.upeu.lamb.finanzas.repository.ConceptoPagoRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ConceptoPagoService {

    private final ConceptoPagoRepository conceptoPagoRepository;
    private final CategoriaConceptoRepository categoriaConceptoRepository;
    private final ConceptoPagoMapper conceptoPagoMapper;

    public List<ConceptoPagoResponse> listar() {
        return conceptoPagoRepository.findAll().stream()
                .map(conceptoPagoMapper::toResponse)
                .toList();
    }

    public ConceptoPagoResponse obtener(Long id) {
        return conceptoPagoMapper.toResponse(buscarOFallar(id));
    }

    @Transactional
    public ConceptoPagoResponse crear(ConceptoPagoRequest request) {
        CategoriaConcepto categoria = categoriaConceptoRepository.findById(request.getIdCategoria())
                .orElseThrow(() -> new ResourceNotFoundException("Categoria de concepto no encontrada: " + request.getIdCategoria()));
        ConceptoPago entity = ConceptoPago.builder()
                .categoria(categoria)
                .nombre(request.getNombre())
                .monto(request.getMonto())
                .vigenciaDesde(request.getVigenciaDesde())
                .vigenciaHasta(request.getVigenciaHasta())
                .build();
        return conceptoPagoMapper.toResponse(conceptoPagoRepository.save(entity));
    }

    private ConceptoPago buscarOFallar(Long id) {
        return conceptoPagoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Concepto de pago no encontrado: " + id));
    }
}
