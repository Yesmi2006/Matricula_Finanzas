package pe.edu.upeu.lamb.finanzas.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.upeu.lamb.finanzas.dto.ConvenioInstitucionalDescuentoRequest;
import pe.edu.upeu.lamb.finanzas.dto.ConvenioInstitucionalDescuentoResponse;
import pe.edu.upeu.lamb.finanzas.entity.ConvenioInstitucionalDescuento;
import pe.edu.upeu.lamb.finanzas.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.finanzas.mapper.ConvenioInstitucionalDescuentoMapper;
import pe.edu.upeu.lamb.finanzas.repository.ConvenioInstitucionalDescuentoRepository;

import java.util.List;

/**
 * CRUD opcional: depende de la universidad. Item 35 del documento.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ConvenioInstitucionalDescuentoService {

    private final ConvenioInstitucionalDescuentoRepository convenioInstitucionalDescuentoRepository;
    private final ConvenioInstitucionalDescuentoMapper convenioInstitucionalDescuentoMapper;

    public List<ConvenioInstitucionalDescuentoResponse> listar() {
        return convenioInstitucionalDescuentoRepository.findAll().stream()
                .map(convenioInstitucionalDescuentoMapper::toResponse)
                .toList();
    }

    public ConvenioInstitucionalDescuentoResponse obtener(Long id) {
        return convenioInstitucionalDescuentoMapper.toResponse(buscarOFallar(id));
    }

    public ConvenioInstitucionalDescuentoResponse crear(ConvenioInstitucionalDescuentoRequest request) {
        ConvenioInstitucionalDescuento entity = convenioInstitucionalDescuentoMapper.toEntity(request);
        ConvenioInstitucionalDescuento guardado = convenioInstitucionalDescuentoRepository.save(entity);
        return convenioInstitucionalDescuentoMapper.toResponse(guardado);
    }

    private ConvenioInstitucionalDescuento buscarOFallar(Long id) {
        return convenioInstitucionalDescuentoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Convenio institucional con descuento no encontrado: " + id));
    }
}
