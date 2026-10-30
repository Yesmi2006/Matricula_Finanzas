package pe.edu.upeu.lamb.finanzas.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upeu.lamb.finanzas.dto.CategoriaConceptoRequest;
import pe.edu.upeu.lamb.finanzas.dto.CategoriaConceptoResponse;
import pe.edu.upeu.lamb.finanzas.entity.CategoriaConcepto;
import pe.edu.upeu.lamb.finanzas.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.finanzas.mapper.CategoriaConceptoMapper;
import pe.edu.upeu.lamb.finanzas.repository.CategoriaConceptoRepository;

import java.util.List;

/**
 * CRUD marcado con (*) en el documento: "Categoria de concepto (OTRO CRUD)".
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CategoriaConceptoService {

    private final CategoriaConceptoRepository categoriaConceptoRepository;
    private final CategoriaConceptoMapper categoriaConceptoMapper;

    public List<CategoriaConceptoResponse> listar() {
        return categoriaConceptoRepository.findAll().stream()
                .map(categoriaConceptoMapper::toResponse)
                .toList();
    }

    public CategoriaConceptoResponse obtener(Long id) {
        return categoriaConceptoMapper.toResponse(buscarOFallar(id));
    }

    @Transactional
    public CategoriaConceptoResponse crear(CategoriaConceptoRequest request) {
        CategoriaConcepto entity = categoriaConceptoMapper.toEntity(request);
        return categoriaConceptoMapper.toResponse(categoriaConceptoRepository.save(entity));
    }

    private CategoriaConcepto buscarOFallar(Long id) {
        return categoriaConceptoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria de concepto no encontrada: " + id));
    }
}
