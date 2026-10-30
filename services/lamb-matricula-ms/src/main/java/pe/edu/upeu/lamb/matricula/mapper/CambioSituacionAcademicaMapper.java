package pe.edu.upeu.lamb.matricula.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.matricula.dto.CambioSituacionAcademicaRequest;
import pe.edu.upeu.lamb.matricula.dto.CambioSituacionAcademicaResponse;
import pe.edu.upeu.lamb.matricula.entity.CambioSituacionAcademica;

@Component
public class CambioSituacionAcademicaMapper {

    public CambioSituacionAcademica toEntity(CambioSituacionAcademicaRequest request) {
        return CambioSituacionAcademica.builder()
                .idSituacionAcademica(request.getIdSituacionAcademica())
                .situacionAnterior(request.getSituacionAnterior())
                .situacionNueva(request.getSituacionNueva())
                .resolucion(request.getResolucion())
                .build();
    }

    public CambioSituacionAcademicaResponse toResponse(CambioSituacionAcademica entity) {
        return CambioSituacionAcademicaResponse.builder()
                .id(entity.getId())
                .idSituacionAcademica(entity.getIdSituacionAcademica())
                .situacionAnterior(entity.getSituacionAnterior())
                .situacionNueva(entity.getSituacionNueva())
                .resolucion(entity.getResolucion())
                .fechaCambio(entity.getFechaCambio())
                .build();
    }
}
