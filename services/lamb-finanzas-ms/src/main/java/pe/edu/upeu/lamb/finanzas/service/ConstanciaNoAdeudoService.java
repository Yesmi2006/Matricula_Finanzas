package pe.edu.upeu.lamb.finanzas.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.upeu.lamb.finanzas.dto.ConstanciaNoAdeudoRequest;
import pe.edu.upeu.lamb.finanzas.dto.ConstanciaNoAdeudoResponse;
import pe.edu.upeu.lamb.finanzas.entity.ConstanciaNoAdeudo;
import pe.edu.upeu.lamb.finanzas.entity.EstadoCobro;
import pe.edu.upeu.lamb.finanzas.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.finanzas.mapper.ConstanciaNoAdeudoMapper;
import pe.edu.upeu.lamb.finanzas.repository.ConstanciaNoAdeudoRepository;
import pe.edu.upeu.lamb.finanzas.repository.EstadoCobroRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ConstanciaNoAdeudoService {

    private final ConstanciaNoAdeudoRepository constanciaNoAdeudoRepository;
    private final EstadoCobroRepository estadoCobroRepository;
    private final ConstanciaNoAdeudoMapper constanciaNoAdeudoMapper;

    public List<ConstanciaNoAdeudoResponse> listar() {
        return constanciaNoAdeudoRepository.findAll().stream()
                .map(constanciaNoAdeudoMapper::toResponse)
                .toList();
    }

    public ConstanciaNoAdeudoResponse obtener(Long id) {
        return constanciaNoAdeudoMapper.toResponse(buscarOFallar(id));
    }

    public ConstanciaNoAdeudoResponse crear(ConstanciaNoAdeudoRequest request) {
        EstadoCobro estadoCobro = estadoCobroRepository.findById(request.getIdEstadoCobro())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "No se encontro el estado de cobro con id " + request.getIdEstadoCobro()));

        ConstanciaNoAdeudo entity = ConstanciaNoAdeudo.builder()
                .estadoCobro(estadoCobro)
                .codigoConstancia(request.getCodigoConstancia())
                .fechaEmision(request.getFechaEmision())
                .build();

        return constanciaNoAdeudoMapper.toResponse(constanciaNoAdeudoRepository.save(entity));
    }

    private ConstanciaNoAdeudo buscarOFallar(Long id) {
        return constanciaNoAdeudoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro la constancia de no adeudo con id " + id));
    }
}
