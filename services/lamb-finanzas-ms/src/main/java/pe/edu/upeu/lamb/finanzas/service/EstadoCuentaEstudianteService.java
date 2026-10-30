package pe.edu.upeu.lamb.finanzas.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.upeu.lamb.finanzas.dto.EstadoCuentaEstudianteRequest;
import pe.edu.upeu.lamb.finanzas.dto.EstadoCuentaEstudianteResponse;
import pe.edu.upeu.lamb.finanzas.entity.CuentaEstudiante;
import pe.edu.upeu.lamb.finanzas.entity.EstadoCuentaEstudiante;
import pe.edu.upeu.lamb.finanzas.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.finanzas.mapper.EstadoCuentaEstudianteMapper;
import pe.edu.upeu.lamb.finanzas.repository.CuentaEstudianteRepository;
import pe.edu.upeu.lamb.finanzas.repository.EstadoCuentaEstudianteRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class EstadoCuentaEstudianteService {

    private final EstadoCuentaEstudianteRepository estadoCuentaEstudianteRepository;
    private final CuentaEstudianteRepository cuentaEstudianteRepository;
    private final EstadoCuentaEstudianteMapper estadoCuentaEstudianteMapper;

    public List<EstadoCuentaEstudianteResponse> listar() {
        return estadoCuentaEstudianteRepository.findAll().stream()
                .map(estadoCuentaEstudianteMapper::toResponse)
                .toList();
    }

    public EstadoCuentaEstudianteResponse obtener(Long id) {
        return estadoCuentaEstudianteMapper.toResponse(buscarOFallar(id));
    }

    public EstadoCuentaEstudianteResponse crear(EstadoCuentaEstudianteRequest request) {
        CuentaEstudiante cuentaEstudiante = cuentaEstudianteRepository.findById(request.getIdCuentaEstudiante())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "No se encontro la cuenta de estudiante con id " + request.getIdCuentaEstudiante()));

        EstadoCuentaEstudiante entity = EstadoCuentaEstudiante.builder()
                .cuentaEstudiante(cuentaEstudiante)
                .montoTotalDeuda(request.getMontoTotalDeuda())
                .montoPagado(request.getMontoPagado())
                .saldoPendiente(request.getSaldoPendiente())
                .fecha(request.getFecha())
                .build();

        return estadoCuentaEstudianteMapper.toResponse(estadoCuentaEstudianteRepository.save(entity));
    }

    private EstadoCuentaEstudiante buscarOFallar(Long id) {
        return estadoCuentaEstudianteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro el estado de cuenta con id " + id));
    }
}
