package pe.edu.upeu.lamb.matricula.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.matricula.dto.CruceHorarioAutorizadoRequest;
import pe.edu.upeu.lamb.matricula.dto.CruceHorarioAutorizadoResponse;
import pe.edu.upeu.lamb.matricula.entity.CruceHorarioAutorizado;

@Component
public class CruceHorarioAutorizadoMapper {

    public CruceHorarioAutorizado toEntity(CruceHorarioAutorizadoRequest request) {
        return CruceHorarioAutorizado.builder()
                .idMatricula(request.getIdMatricula())
                .idSeccion1(request.getIdSeccion1())
                .idSeccion2(request.getIdSeccion2())
                .motivo(request.getMotivo())
                .build();
    }

    public CruceHorarioAutorizadoResponse toResponse(CruceHorarioAutorizado entity) {
        return CruceHorarioAutorizadoResponse.builder()
                .id(entity.getId())
                .idMatricula(entity.getIdMatricula())
                .idSeccion1(entity.getIdSeccion1())
                .idSeccion2(entity.getIdSeccion2())
                .motivo(entity.getMotivo())
                .fechaAutorizacion(entity.getFechaAutorizacion())
                .build();
    }
}
