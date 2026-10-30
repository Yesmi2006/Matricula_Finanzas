package pe.edu.upeu.lamb.finanzas.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.upeu.lamb.finanzas.dto.SerieCorrelativoComprobanteRequest;
import pe.edu.upeu.lamb.finanzas.dto.SerieCorrelativoComprobanteResponse;
import pe.edu.upeu.lamb.finanzas.entity.SerieCorrelativoComprobante;
import pe.edu.upeu.lamb.finanzas.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.finanzas.mapper.SerieCorrelativoComprobanteMapper;
import pe.edu.upeu.lamb.finanzas.repository.SerieCorrelativoComprobanteRepository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class SerieCorrelativoComprobanteService {

    private final SerieCorrelativoComprobanteRepository serieCorrelativoComprobanteRepository;
    private final SerieCorrelativoComprobanteMapper serieCorrelativoComprobanteMapper;

    public List<SerieCorrelativoComprobanteResponse> listar() {
        return serieCorrelativoComprobanteRepository.findAll().stream()
                .map(serieCorrelativoComprobanteMapper::toResponse)
                .collect(Collectors.toList());
    }

    public SerieCorrelativoComprobanteResponse obtener(Long id) {
        return serieCorrelativoComprobanteMapper.toResponse(buscarOFallar(id));
    }

    public SerieCorrelativoComprobanteResponse crear(SerieCorrelativoComprobanteRequest request) {
        SerieCorrelativoComprobante entity = serieCorrelativoComprobanteMapper.toEntity(request);
        SerieCorrelativoComprobante guardado = serieCorrelativoComprobanteRepository.save(entity);
        log.info("Serie y correlativo de comprobante creado con id: {}", guardado.getId());
        return serieCorrelativoComprobanteMapper.toResponse(guardado);
    }

    private SerieCorrelativoComprobante buscarOFallar(Long id) {
        return serieCorrelativoComprobanteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Serie y correlativo de comprobante no encontrado con id: " + id));
    }
}
