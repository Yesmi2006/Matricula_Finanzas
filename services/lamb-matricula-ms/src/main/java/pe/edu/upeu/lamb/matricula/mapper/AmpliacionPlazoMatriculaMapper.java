package pe.edu.upeu.lamb.matricula.mapper;

import pe.edu.upeu.lamb.matricula.dto.AmpliacionPlazoMatriculaRequest;
import pe.edu.upeu.lamb.matricula.dto.AmpliacionPlazoMatriculaResponse;
import pe.edu.upeu.lamb.matricula.entity.AmpliacionPlazoMatricula;
import org.springframework.stereotype.Component;

@Component
public class AmpliacionPlazoMatriculaMapper {

    public AmpliacionPlazoMatricula toEntity(AmpliacionPlazoMatriculaRequest request) {
        return AmpliacionPlazoMatricula.builder()
                .idCronograma(request.getIdCronograma())
                .fechaAmpliada(request.getFechaAmpliada())
                .motivo(request.getMotivo())
                .autorizadoPor(request.getAutorizadoPor())
                .build();
    }

    public AmpliacionPlazoMatriculaResponse toResponse(AmpliacionPlazoMatricula entity) {
        return AmpliacionPlazoMatriculaResponse.builder()
                .id(entity.getId())
                .idCronograma(entity.getIdCronograma())
                .fechaAmpliada(entity.getFechaAmpliada())
                .motivo(entity.getMotivo())
                .autorizadoPor(entity.getAutorizadoPor())
                .build();
    }
}
