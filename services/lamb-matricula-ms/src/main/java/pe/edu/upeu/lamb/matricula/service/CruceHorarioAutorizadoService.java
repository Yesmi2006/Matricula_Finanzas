package pe.edu.upeu.lamb.matricula.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.upeu.lamb.matricula.dto.CruceHorarioAutorizadoRequest;
import pe.edu.upeu.lamb.matricula.dto.CruceHorarioAutorizadoResponse;
import pe.edu.upeu.lamb.matricula.entity.CruceHorarioAutorizado;
import pe.edu.upeu.lamb.matricula.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.matricula.mapper.CruceHorarioAutorizadoMapper;
import pe.edu.upeu.lamb.matricula.repository.CruceHorarioAutorizadoRepository;

import java.time.Instant;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CruceHorarioAutorizadoService {

    private final CruceHorarioAutorizadoRepository cruceHorarioAutorizadoRepository;
    private final CruceHorarioAutorizadoMapper cruceHorarioAutorizadoMapper;

    public List<CruceHorarioAutorizadoResponse> listar() {
        return cruceHorarioAutorizadoRepository.findAll().stream()
                .map(cruceHorarioAutorizadoMapper::toResponse)
                .toList();
    }

    public CruceHorarioAutorizadoResponse obtener(Long id) {
        return cruceHorarioAutorizadoMapper.toResponse(buscarOFallar(id));
    }

    public CruceHorarioAutorizadoResponse crear(CruceHorarioAutorizadoRequest request) {
        CruceHorarioAutorizado cruceHorarioAutorizado = cruceHorarioAutorizadoMapper.toEntity(request);
        cruceHorarioAutorizado.setFechaAutorizacion(Instant.now());
        return cruceHorarioAutorizadoMapper.toResponse(cruceHorarioAutorizadoRepository.save(cruceHorarioAutorizado));
    }

    private CruceHorarioAutorizado buscarOFallar(Long id) {
        return cruceHorarioAutorizadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CruceHorarioAutorizado no encontrado: " + id));
    }
}
