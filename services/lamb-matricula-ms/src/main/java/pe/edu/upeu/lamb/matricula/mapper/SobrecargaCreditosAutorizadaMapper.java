package pe.edu.upeu.lamb.matricula.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.matricula.dto.SobrecargaCreditosAutorizadaRequest;
import pe.edu.upeu.lamb.matricula.dto.SobrecargaCreditosAutorizadaResponse;
import pe.edu.upeu.lamb.matricula.entity.SobrecargaCreditosAutorizada;

@Component
public class SobrecargaCreditosAutorizadaMapper {

    public SobrecargaCreditosAutorizada toEntity(SobrecargaCreditosAutorizadaRequest request) {
        return SobrecargaCreditosAutorizada.builder()
                .idMatricula(request.getIdMatricula())
                .creditosAutorizados(request.getCreditosAutorizados())
                .motivo(request.getMotivo())
                .build();
    }

    public SobrecargaCreditosAutorizadaResponse toResponse(SobrecargaCreditosAutorizada entity) {
        return SobrecargaCreditosAutorizadaResponse.builder()
                .id(entity.getId())
                .idMatricula(entity.getIdMatricula())
                .creditosAutorizados(entity.getCreditosAutorizados())
                .motivo(entity.getMotivo())
                .fechaAutorizacion(entity.getFechaAutorizacion())
                .build();
    }
}
