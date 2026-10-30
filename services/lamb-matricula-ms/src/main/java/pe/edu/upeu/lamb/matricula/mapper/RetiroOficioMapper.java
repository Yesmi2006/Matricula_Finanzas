package pe.edu.upeu.lamb.matricula.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.matricula.dto.RetiroOficioRequest;
import pe.edu.upeu.lamb.matricula.dto.RetiroOficioResponse;
import pe.edu.upeu.lamb.matricula.entity.RetiroOficio;

@Component
public class RetiroOficioMapper {

    public RetiroOficio toEntity(RetiroOficioRequest request) {
        return RetiroOficio.builder()
                .idMatricula(request.getIdMatricula())
                .motivo(request.getMotivo())
                .build();
    }

    public RetiroOficioResponse toResponse(RetiroOficio entity) {
        return RetiroOficioResponse.builder()
                .id(entity.getId())
                .idMatricula(entity.getIdMatricula())
                .motivo(entity.getMotivo())
                .fechaRetiro(entity.getFechaRetiro())
                .build();
    }
}
