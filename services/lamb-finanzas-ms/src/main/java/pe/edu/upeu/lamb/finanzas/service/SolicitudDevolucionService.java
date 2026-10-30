package pe.edu.upeu.lamb.finanzas.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.upeu.lamb.finanzas.dto.SolicitudDevolucionRequest;
import pe.edu.upeu.lamb.finanzas.dto.SolicitudDevolucionResponse;
import pe.edu.upeu.lamb.finanzas.entity.Pago;
import pe.edu.upeu.lamb.finanzas.entity.SolicitudDevolucion;
import pe.edu.upeu.lamb.finanzas.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.finanzas.mapper.SolicitudDevolucionMapper;
import pe.edu.upeu.lamb.finanzas.repository.PagoRepository;
import pe.edu.upeu.lamb.finanzas.repository.SolicitudDevolucionRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SolicitudDevolucionService {

    private final SolicitudDevolucionRepository solicitudDevolucionRepository;
    private final PagoRepository pagoRepository;
    private final SolicitudDevolucionMapper solicitudDevolucionMapper;

    public List<SolicitudDevolucionResponse> listar() {
        return solicitudDevolucionRepository.findAll().stream()
                .map(solicitudDevolucionMapper::toResponse)
                .toList();
    }

    public SolicitudDevolucionResponse obtener(Long id) {
        return solicitudDevolucionMapper.toResponse(buscarOFallar(id));
    }

    public SolicitudDevolucionResponse crear(SolicitudDevolucionRequest request) {
        Pago pago = pagoRepository.findById(request.getIdPago())
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro el pago con id " + request.getIdPago()));

        SolicitudDevolucion entity = SolicitudDevolucion.builder()
                .pago(pago)
                .motivo(request.getMotivo())
                .montoSolicitado(request.getMontoSolicitado())
                .estado(request.getEstado())
                .fecha(request.getFecha())
                .build();

        return solicitudDevolucionMapper.toResponse(solicitudDevolucionRepository.save(entity));
    }

    private SolicitudDevolucion buscarOFallar(Long id) {
        return solicitudDevolucionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro la solicitud de devolucion con id " + id));
    }
}
