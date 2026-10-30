package pe.edu.upeu.lamb.finanzas.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.upeu.lamb.finanzas.dto.ReembolsoPagoRequest;
import pe.edu.upeu.lamb.finanzas.dto.ReembolsoPagoResponse;
import pe.edu.upeu.lamb.finanzas.entity.CuentaEstudiante;
import pe.edu.upeu.lamb.finanzas.entity.ReembolsoPago;
import pe.edu.upeu.lamb.finanzas.entity.SolicitudDevolucion;
import pe.edu.upeu.lamb.finanzas.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.finanzas.mapper.ReembolsoPagoMapper;
import pe.edu.upeu.lamb.finanzas.repository.CuentaEstudianteRepository;
import pe.edu.upeu.lamb.finanzas.repository.ReembolsoPagoRepository;
import pe.edu.upeu.lamb.finanzas.repository.SolicitudDevolucionRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReembolsoPagoService {

    private final ReembolsoPagoRepository reembolsoPagoRepository;
    private final SolicitudDevolucionRepository solicitudDevolucionRepository;
    private final CuentaEstudianteRepository cuentaEstudianteRepository;
    private final ReembolsoPagoMapper reembolsoPagoMapper;

    public List<ReembolsoPagoResponse> listar() {
        return reembolsoPagoRepository.findAll().stream()
                .map(reembolsoPagoMapper::toResponse)
                .toList();
    }

    public ReembolsoPagoResponse obtener(Long id) {
        return reembolsoPagoMapper.toResponse(buscarOFallar(id));
    }

    public ReembolsoPagoResponse crear(ReembolsoPagoRequest request) {
        SolicitudDevolucion solicitudDevolucion = solicitudDevolucionRepository.findById(request.getIdSolicitudDevolucion())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "No se encontro la solicitud de devolucion con id " + request.getIdSolicitudDevolucion()));
        CuentaEstudiante cuentaEstudiante = cuentaEstudianteRepository.findById(request.getIdCuentaEstudiante())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "No se encontro la cuenta de estudiante con id " + request.getIdCuentaEstudiante()));

        ReembolsoPago entity = ReembolsoPago.builder()
                .solicitudDevolucion(solicitudDevolucion)
                .cuentaEstudiante(cuentaEstudiante)
                .montoReembolsado(request.getMontoReembolsado())
                .fecha(request.getFecha())
                .build();

        return reembolsoPagoMapper.toResponse(reembolsoPagoRepository.save(entity));
    }

    private ReembolsoPago buscarOFallar(Long id) {
        return reembolsoPagoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro el reembolso de pago con id " + id));
    }
}
