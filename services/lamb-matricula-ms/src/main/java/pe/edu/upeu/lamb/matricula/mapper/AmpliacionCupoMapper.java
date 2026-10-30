package pe.edu.upeu.lamb.matricula.mapper;

import pe.edu.upeu.lamb.matricula.dto.AmpliacionCupoRequest;
import pe.edu.upeu.lamb.matricula.dto.AmpliacionCupoResponse;
import pe.edu.upeu.lamb.matricula.entity.AmpliacionCupo;
import org.springframework.stereotype.Component;

@Component
public class AmpliacionCupoMapper {

    public AmpliacionCupo toEntity(AmpliacionCupoRequest request) {
        return AmpliacionCupo.builder()
                .idSeccion(request.getIdSeccion())
                .cupoAdicional(request.getCupoAdicional())
                .motivo(request.getMotivo())
                .autorizadoPor(request.getAutorizadoPor())
                .build();
    }

    public AmpliacionCupoResponse toResponse(AmpliacionCupo entity) {
        return AmpliacionCupoResponse.builder()
                .id(entity.getId())
                .idSeccion(entity.getIdSeccion())
                .cupoAdicional(entity.getCupoAdicional())
                .motivo(entity.getMotivo())
                .autorizadoPor(entity.getAutorizadoPor())
                .build();
    }
}
