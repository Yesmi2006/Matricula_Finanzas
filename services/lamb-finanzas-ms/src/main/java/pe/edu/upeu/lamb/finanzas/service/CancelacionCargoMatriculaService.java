package pe.edu.upeu.lamb.finanzas.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.upeu.lamb.finanzas.dto.CancelacionCargoMatriculaRequest;
import pe.edu.upeu.lamb.finanzas.dto.CancelacionCargoMatriculaResponse;
import pe.edu.upeu.lamb.finanzas.entity.CancelacionCargoMatricula;
import pe.edu.upeu.lamb.finanzas.entity.Pago;
import pe.edu.upeu.lamb.finanzas.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.finanzas.mapper.CancelacionCargoMatriculaMapper;
import pe.edu.upeu.lamb.finanzas.repository.CancelacionCargoMatriculaRepository;
import pe.edu.upeu.lamb.finanzas.repository.PagoRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CancelacionCargoMatriculaService {

    private final CancelacionCargoMatriculaRepository cancelacionCargoMatriculaRepository;
    private final PagoRepository pagoRepository;
    private final CancelacionCargoMatriculaMapper cancelacionCargoMatriculaMapper;

    public List<CancelacionCargoMatriculaResponse> listar() {
        return cancelacionCargoMatriculaRepository.findAll().stream()
                .map(cancelacionCargoMatriculaMapper::toResponse)
                .toList();
    }

    public CancelacionCargoMatriculaResponse obtener(Long id) {
        return cancelacionCargoMatriculaMapper.toResponse(buscarOFallar(id));
    }

    public CancelacionCargoMatriculaResponse crear(CancelacionCargoMatriculaRequest request) {
        Pago pago = pagoRepository.findById(request.getIdPago())
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro el pago con id " + request.getIdPago()));

        // idMatricula no se resuelve localmente: la matricula pertenece a lamb-matricula-ms (JALA ID).
        CancelacionCargoMatricula entity = CancelacionCargoMatricula.builder()
                .pago(pago)
                .idMatricula(request.getIdMatricula())
                .motivo(request.getMotivo())
                .fecha(request.getFecha())
                .build();

        return cancelacionCargoMatriculaMapper.toResponse(cancelacionCargoMatriculaRepository.save(entity));
    }

    private CancelacionCargoMatricula buscarOFallar(Long id) {
        return cancelacionCargoMatriculaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro la cancelacion de cargo con id " + id));
    }
}
