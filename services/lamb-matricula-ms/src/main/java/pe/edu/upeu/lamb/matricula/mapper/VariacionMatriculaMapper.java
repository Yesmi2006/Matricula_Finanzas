package pe.edu.upeu.lamb.matricula.mapper;

import pe.edu.upeu.lamb.matricula.dto.VariacionMatriculaRequest;
import pe.edu.upeu.lamb.matricula.dto.VariacionMatriculaResponse;
import pe.edu.upeu.lamb.matricula.entity.VariacionMatricula;
import org.springframework.stereotype.Component;

@Component
public class VariacionMatriculaMapper {

    public VariacionMatricula toEntity(VariacionMatriculaRequest request) {
        return VariacionMatricula.builder()
                .idCronograma(request.getIdCronograma())
                .tipo(request.getTipo())
                .fechaInicio(request.getFechaInicio())
                .fechaFin(request.getFechaFin())
                .descripcion(request.getDescripcion())
                .build();
    }

    public VariacionMatriculaResponse toResponse(VariacionMatricula entity) {
        return VariacionMatriculaResponse.builder()
                .id(entity.getId())
                .idCronograma(entity.getIdCronograma())
                .tipo(entity.getTipo())
                .fechaInicio(entity.getFechaInicio())
                .fechaFin(entity.getFechaFin())
                .descripcion(entity.getDescripcion())
                .build();
    }
}
