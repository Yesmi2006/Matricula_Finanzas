package pe.edu.upeu.lamb.matricula.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.upeu.lamb.matricula.dto.NotificacionMatriculaRequest;
import pe.edu.upeu.lamb.matricula.dto.NotificacionMatriculaResponse;
import pe.edu.upeu.lamb.matricula.entity.NotificacionMatricula;
import pe.edu.upeu.lamb.matricula.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.matricula.mapper.NotificacionMatriculaMapper;
import pe.edu.upeu.lamb.matricula.repository.NotificacionMatriculaRepository;

import java.time.Instant;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificacionMatriculaService {

    private final NotificacionMatriculaRepository notificacionMatriculaRepository;
    private final NotificacionMatriculaMapper notificacionMatriculaMapper;

    public List<NotificacionMatriculaResponse> listar() {
        return notificacionMatriculaRepository.findAll().stream()
                .map(notificacionMatriculaMapper::toResponse)
                .toList();
    }

    public NotificacionMatriculaResponse obtener(Long id) {
        return notificacionMatriculaMapper.toResponse(buscarOFallar(id));
    }

    public NotificacionMatriculaResponse crear(NotificacionMatriculaRequest request) {
        NotificacionMatricula entity = notificacionMatriculaMapper.toEntity(request);
        entity.setFechaEnvio(Instant.now());
        entity.setEstadoEnvio("PENDIENTE");
        return notificacionMatriculaMapper.toResponse(notificacionMatriculaRepository.save(entity));
    }

    private NotificacionMatricula buscarOFallar(Long id) {
        return notificacionMatriculaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Notificacion de matricula no encontrada: " + id));
    }
}
