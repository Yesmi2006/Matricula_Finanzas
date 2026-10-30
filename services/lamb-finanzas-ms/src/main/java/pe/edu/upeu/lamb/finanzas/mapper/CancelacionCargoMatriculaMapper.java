package pe.edu.upeu.lamb.finanzas.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.finanzas.dto.CancelacionCargoMatriculaResponse;
import pe.edu.upeu.lamb.finanzas.entity.CancelacionCargoMatricula;

@Component
public class CancelacionCargoMatriculaMapper {

    public CancelacionCargoMatriculaResponse toResponse(CancelacionCargoMatricula entity) {
        return CancelacionCargoMatriculaResponse.builder()
                .id(entity.getId())
                .idPago(entity.getPago().getId())
                .idMatricula(entity.getIdMatricula())
                .motivo(entity.getMotivo())
                .fecha(entity.getFecha())
                .build();
    }
}
