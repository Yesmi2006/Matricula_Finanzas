package pe.edu.upeu.lamb.matricula.mapper;

import pe.edu.upeu.lamb.matricula.dto.ReservaVacanteRequest;
import pe.edu.upeu.lamb.matricula.dto.ReservaVacanteResponse;
import pe.edu.upeu.lamb.matricula.entity.ReservaVacante;
import org.springframework.stereotype.Component;

@Component
public class ReservaVacanteMapper {

    public ReservaVacante toEntity(ReservaVacanteRequest request) {
        return ReservaVacante.builder()
                .idSeccion(request.getIdSeccion())
                .idPersona(request.getIdPersona())
                .fechaReserva(request.getFechaReserva())
                .vigenciaHasta(request.getVigenciaHasta())
                .estado(request.getEstado())
                .build();
    }

    public ReservaVacanteResponse toResponse(ReservaVacante entity) {
        return ReservaVacanteResponse.builder()
                .id(entity.getId())
                .idSeccion(entity.getIdSeccion())
                .idPersona(entity.getIdPersona())
                .fechaReserva(entity.getFechaReserva())
                .vigenciaHasta(entity.getVigenciaHasta())
                .estado(entity.getEstado())
                .build();
    }
}
