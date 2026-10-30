package pe.edu.upeu.lamb.finanzas.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upeu.lamb.finanzas.dto.CuentaEstudianteRequest;
import pe.edu.upeu.lamb.finanzas.dto.CuentaEstudianteResponse;
import pe.edu.upeu.lamb.finanzas.entity.CuentaEstudiante;
import pe.edu.upeu.lamb.finanzas.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.finanzas.mapper.CuentaEstudianteMapper;
import pe.edu.upeu.lamb.finanzas.repository.CuentaEstudianteRepository;

import java.time.Instant;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CuentaEstudianteService {

    private final CuentaEstudianteRepository cuentaEstudianteRepository;
    private final CuentaEstudianteMapper cuentaEstudianteMapper;

    public List<CuentaEstudianteResponse> listar() {
        return cuentaEstudianteRepository.findAll().stream()
                .map(cuentaEstudianteMapper::toResponse)
                .toList();
    }

    public CuentaEstudianteResponse obtener(Long id) {
        return cuentaEstudianteMapper.toResponse(buscarOFallar(id));
    }

    @Transactional
    public CuentaEstudianteResponse crear(CuentaEstudianteRequest request) {
        CuentaEstudiante entity = cuentaEstudianteMapper.toEntity(request);
        entity.setFechaApertura(Instant.now());
        return cuentaEstudianteMapper.toResponse(cuentaEstudianteRepository.save(entity));
    }

    private CuentaEstudiante buscarOFallar(Long id) {
        return cuentaEstudianteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cuenta de estudiante no encontrada: " + id));
    }
}
