package pe.edu.upeu.lamb.matricula.service;

import pe.edu.upeu.lamb.matricula.dto.ModalidadMatriculaRequest;
import pe.edu.upeu.lamb.matricula.dto.ModalidadMatriculaResponse;
import pe.edu.upeu.lamb.matricula.entity.ModalidadMatricula;
import pe.edu.upeu.lamb.matricula.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.matricula.mapper.ModalidadMatriculaMapper;
import pe.edu.upeu.lamb.matricula.repository.ModalidadMatriculaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ModalidadMatriculaService {

    private final ModalidadMatriculaRepository modalidadMatriculaRepository;
    private final ModalidadMatriculaMapper modalidadMatriculaMapper;

    public List<ModalidadMatriculaResponse> listar() {
        return modalidadMatriculaRepository.findAll().stream()
                .map(modalidadMatriculaMapper::toResponse)
                .toList();
    }

    public ModalidadMatriculaResponse obtener(Long id) {
        return modalidadMatriculaMapper.toResponse(buscarOFallar(id));
    }

    public ModalidadMatriculaResponse crear(ModalidadMatriculaRequest request) {
        ModalidadMatricula entity = modalidadMatriculaMapper.toEntity(request);
        return modalidadMatriculaMapper.toResponse(modalidadMatriculaRepository.save(entity));
    }

    private ModalidadMatricula buscarOFallar(Long id) {
        return modalidadMatriculaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Modalidad de matricula no encontrada: " + id));
    }
}
