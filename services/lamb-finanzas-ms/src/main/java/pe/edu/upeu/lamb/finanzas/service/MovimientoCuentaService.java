package pe.edu.upeu.lamb.finanzas.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upeu.lamb.finanzas.dto.MovimientoCuentaRequest;
import pe.edu.upeu.lamb.finanzas.dto.MovimientoCuentaResponse;
import pe.edu.upeu.lamb.finanzas.entity.CuentaEstudiante;
import pe.edu.upeu.lamb.finanzas.entity.MovimientoCuenta;
import pe.edu.upeu.lamb.finanzas.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.finanzas.mapper.MovimientoCuentaMapper;
import pe.edu.upeu.lamb.finanzas.repository.CuentaEstudianteRepository;
import pe.edu.upeu.lamb.finanzas.repository.MovimientoCuentaRepository;

import java.time.Instant;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MovimientoCuentaService {

    private final MovimientoCuentaRepository movimientoCuentaRepository;
    private final CuentaEstudianteRepository cuentaEstudianteRepository;
    private final MovimientoCuentaMapper movimientoCuentaMapper;

    public List<MovimientoCuentaResponse> listar() {
        return movimientoCuentaRepository.findAll().stream()
                .map(movimientoCuentaMapper::toResponse)
                .toList();
    }

    public MovimientoCuentaResponse obtener(Long id) {
        return movimientoCuentaMapper.toResponse(buscarOFallar(id));
    }

    @Transactional
    public MovimientoCuentaResponse crear(MovimientoCuentaRequest request) {
        CuentaEstudiante cuenta = cuentaEstudianteRepository.findById(request.getIdCuenta())
                .orElseThrow(() -> new ResourceNotFoundException("Cuenta de estudiante no encontrada: " + request.getIdCuenta()));
        MovimientoCuenta entity = MovimientoCuenta.builder()
                .cuenta(cuenta)
                .tipo(request.getTipo())
                .monto(request.getMonto())
                .concepto(request.getConcepto())
                .fecha(Instant.now())
                .build();
        return movimientoCuentaMapper.toResponse(movimientoCuentaRepository.save(entity));
    }

    private MovimientoCuenta buscarOFallar(Long id) {
        return movimientoCuentaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movimiento de cuenta no encontrado: " + id));
    }
}
