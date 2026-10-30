package pe.edu.upeu.lamb.matricula.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.upeu.lamb.matricula.dto.CargaAcademicaPeriodoRequest;
import pe.edu.upeu.lamb.matricula.dto.CargaAcademicaPeriodoResponse;
import pe.edu.upeu.lamb.matricula.entity.CargaAcademicaPeriodo;
import pe.edu.upeu.lamb.matricula.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.matricula.mapper.CargaAcademicaPeriodoMapper;
import pe.edu.upeu.lamb.matricula.repository.CargaAcademicaPeriodoRepository;

import java.time.Instant;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CargaAcademicaPeriodoService {

    private final CargaAcademicaPeriodoRepository cargaAcademicaPeriodoRepository;
    private final CargaAcademicaPeriodoMapper cargaAcademicaPeriodoMapper;

    public List<CargaAcademicaPeriodoResponse> listar() {
        return cargaAcademicaPeriodoRepository.findAll().stream()
                .map(cargaAcademicaPeriodoMapper::toResponse)
                .toList();
    }

    public CargaAcademicaPeriodoResponse obtener(Long id) {
        return cargaAcademicaPeriodoMapper.toResponse(buscarOFallar(id));
    }

    public CargaAcademicaPeriodoResponse crear(CargaAcademicaPeriodoRequest request) {
        CargaAcademicaPeriodo cargaAcademicaPeriodo = cargaAcademicaPeriodoMapper.toEntity(request);
        cargaAcademicaPeriodo.setFechaCalculo(Instant.now());
        return cargaAcademicaPeriodoMapper.toResponse(cargaAcademicaPeriodoRepository.save(cargaAcademicaPeriodo));
    }

    private CargaAcademicaPeriodo buscarOFallar(Long id) {
        return cargaAcademicaPeriodoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CargaAcademicaPeriodo no encontrada: " + id));
    }
}
