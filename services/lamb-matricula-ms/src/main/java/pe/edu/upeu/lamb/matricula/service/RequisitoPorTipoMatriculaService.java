package pe.edu.upeu.lamb.matricula.service;

import pe.edu.upeu.lamb.matricula.dto.RequisitoPorTipoMatriculaRequest;
import pe.edu.upeu.lamb.matricula.dto.RequisitoPorTipoMatriculaResponse;
import pe.edu.upeu.lamb.matricula.entity.RequisitoPorTipoMatricula;
import pe.edu.upeu.lamb.matricula.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.matricula.mapper.RequisitoPorTipoMatriculaMapper;
import pe.edu.upeu.lamb.matricula.repository.RequisitoPorTipoMatriculaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RequisitoPorTipoMatriculaService {

    private final RequisitoPorTipoMatriculaRepository requisitoPorTipoMatriculaRepository;
    private final RequisitoPorTipoMatriculaMapper requisitoPorTipoMatriculaMapper;

    public List<RequisitoPorTipoMatriculaResponse> listar() {
        return requisitoPorTipoMatriculaRepository.findAll().stream()
                .map(requisitoPorTipoMatriculaMapper::toResponse)
                .toList();
    }

    public RequisitoPorTipoMatriculaResponse obtener(Long id) {
        return requisitoPorTipoMatriculaMapper.toResponse(buscarOFallar(id));
    }

    /**
     * idRequisitoCurriculo llega sin validar contra lamb-curriculo-ms (no existe aun
     * cliente Feign hacia ese servicio en este modulo). Queda documentado en el DTO
     * para que el equipo de Curriculo lo fusione cuando expongan su CRUD de requisitos.
     */
    public RequisitoPorTipoMatriculaResponse crear(RequisitoPorTipoMatriculaRequest request) {
        RequisitoPorTipoMatricula entity = requisitoPorTipoMatriculaMapper.toEntity(request);
        return requisitoPorTipoMatriculaMapper.toResponse(requisitoPorTipoMatriculaRepository.save(entity));
    }

    private RequisitoPorTipoMatricula buscarOFallar(Long id) {
        return requisitoPorTipoMatriculaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Requisito por tipo de matricula no encontrado: " + id));
    }
}
