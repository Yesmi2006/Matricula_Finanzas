package pe.edu.upeu.lamb.matricula.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.matricula.dto.RetiroInasistenciaRequest;
import pe.edu.upeu.lamb.matricula.dto.RetiroInasistenciaResponse;
import pe.edu.upeu.lamb.matricula.entity.RetiroInasistencia;

@Component
public class RetiroInasistenciaMapper {

    public RetiroInasistencia toEntity(RetiroInasistenciaRequest request) {
        return RetiroInasistencia.builder()
                .idMatricula(request.getIdMatricula())
                .numeroInasistencias(request.getNumeroInasistencias())
                .build();
    }

    public RetiroInasistenciaResponse toResponse(RetiroInasistencia entity) {
        return RetiroInasistenciaResponse.builder()
                .id(entity.getId())
                .idMatricula(entity.getIdMatricula())
                .numeroInasistencias(entity.getNumeroInasistencias())
                .fechaRetiro(entity.getFechaRetiro())
                .build();
    }
}
