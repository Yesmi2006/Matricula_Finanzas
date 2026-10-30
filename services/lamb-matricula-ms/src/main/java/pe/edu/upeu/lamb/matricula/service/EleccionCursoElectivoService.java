package pe.edu.upeu.lamb.matricula.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.upeu.lamb.matricula.dto.EleccionCursoElectivoRequest;
import pe.edu.upeu.lamb.matricula.dto.EleccionCursoElectivoResponse;
import pe.edu.upeu.lamb.matricula.entity.EleccionCursoElectivo;
import pe.edu.upeu.lamb.matricula.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.matricula.mapper.EleccionCursoElectivoMapper;
import pe.edu.upeu.lamb.matricula.repository.EleccionCursoElectivoRepository;

import java.time.Instant;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class EleccionCursoElectivoService {

    private final EleccionCursoElectivoRepository eleccionCursoElectivoRepository;
    private final EleccionCursoElectivoMapper eleccionCursoElectivoMapper;

    public List<EleccionCursoElectivoResponse> listar() {
        return eleccionCursoElectivoRepository.findAll().stream()
                .map(eleccionCursoElectivoMapper::toResponse)
                .toList();
    }

    public EleccionCursoElectivoResponse obtener(Long id) {
        return eleccionCursoElectivoMapper.toResponse(buscarOFallar(id));
    }

    public EleccionCursoElectivoResponse crear(EleccionCursoElectivoRequest request) {
        EleccionCursoElectivo eleccionCursoElectivo = eleccionCursoElectivoMapper.toEntity(request);
        eleccionCursoElectivo.setFechaEleccion(Instant.now());
        return eleccionCursoElectivoMapper.toResponse(eleccionCursoElectivoRepository.save(eleccionCursoElectivo));
    }

    private EleccionCursoElectivo buscarOFallar(Long id) {
        return eleccionCursoElectivoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EleccionCursoElectivo no encontrada: " + id));
    }
}
