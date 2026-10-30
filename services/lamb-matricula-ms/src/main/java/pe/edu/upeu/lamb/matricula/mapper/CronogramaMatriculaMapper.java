package pe.edu.upeu.lamb.matricula.mapper;

import pe.edu.upeu.lamb.matricula.dto.CronogramaMatriculaRequest;
import pe.edu.upeu.lamb.matricula.dto.CronogramaMatriculaResponse;
import pe.edu.upeu.lamb.matricula.entity.CronogramaMatricula;
import org.springframework.stereotype.Component;

@Component
public class CronogramaMatriculaMapper {

    public CronogramaMatricula toEntity(CronogramaMatriculaRequest request) {
        return CronogramaMatricula.builder()
                .periodo(request.getPeriodo())
                .fechaInicio(request.getFechaInicio())
                .fechaFin(request.getFechaFin())
                .descripcion(request.getDescripcion())
                .build();
    }

    public CronogramaMatriculaResponse toResponse(CronogramaMatricula entity) {
        return CronogramaMatriculaResponse.builder()
                .id(entity.getId())
                .periodo(entity.getPeriodo())
                .fechaInicio(entity.getFechaInicio())
                .fechaFin(entity.getFechaFin())
                .descripcion(entity.getDescripcion())
                .build();
    }
}
