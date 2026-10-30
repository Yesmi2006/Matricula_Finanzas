package pe.edu.upeu.lamb.matricula.service;

import pe.edu.upeu.lamb.matricula.dto.ReservaVacanteRequest;
import pe.edu.upeu.lamb.matricula.dto.ReservaVacanteResponse;
import pe.edu.upeu.lamb.matricula.entity.ReservaVacante;
import pe.edu.upeu.lamb.matricula.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.matricula.mapper.ReservaVacanteMapper;
import pe.edu.upeu.lamb.matricula.repository.ReservaVacanteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReservaVacanteService {

    private final ReservaVacanteRepository reservaVacanteRepository;
    private final ReservaVacanteMapper reservaVacanteMapper;

    public List<ReservaVacanteResponse> listar() {
        return reservaVacanteRepository.findAll().stream()
                .map(reservaVacanteMapper::toResponse)
                .toList();
    }

    public ReservaVacanteResponse obtener(Long id) {
        return reservaVacanteMapper.toResponse(buscarOFallar(id));
    }

    /**
     * idSeccion no se valida aun contra lamb-planificacion-ms (sin cliente Feign dedicado
     * para esta reserva); queda documentado para la futura fusion del equipo de Planificacion.
     */
    public ReservaVacanteResponse crear(ReservaVacanteRequest request) {
        ReservaVacante entity = reservaVacanteMapper.toEntity(request);
        if (entity.getEstado() == null) {
            entity.setEstado("RESERVADA");
        }
        return reservaVacanteMapper.toResponse(reservaVacanteRepository.save(entity));
    }

    private ReservaVacante buscarOFallar(Long id) {
        return reservaVacanteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reserva de vacante no encontrada: " + id));
    }
}
