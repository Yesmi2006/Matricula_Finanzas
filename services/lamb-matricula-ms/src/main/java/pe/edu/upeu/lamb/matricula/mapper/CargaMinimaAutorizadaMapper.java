package pe.edu.upeu.lamb.matricula.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.matricula.dto.CargaMinimaAutorizadaRequest;
import pe.edu.upeu.lamb.matricula.dto.CargaMinimaAutorizadaResponse;
import pe.edu.upeu.lamb.matricula.entity.CargaMinimaAutorizada;

@Component
public class CargaMinimaAutorizadaMapper {

    public CargaMinimaAutorizada toEntity(CargaMinimaAutorizadaRequest request) {
        return CargaMinimaAutorizada.builder()
                .idMatricula(request.getIdMatricula())
                .creditosMinimos(request.getCreditosMinimos())
                .motivo(request.getMotivo())
                .build();
    }

    public CargaMinimaAutorizadaResponse toResponse(CargaMinimaAutorizada entity) {
        return CargaMinimaAutorizadaResponse.builder()
                .id(entity.getId())
                .idMatricula(entity.getIdMatricula())
                .creditosMinimos(entity.getCreditosMinimos())
                .motivo(entity.getMotivo())
                .fechaAutorizacion(entity.getFechaAutorizacion())
                .build();
    }
}
