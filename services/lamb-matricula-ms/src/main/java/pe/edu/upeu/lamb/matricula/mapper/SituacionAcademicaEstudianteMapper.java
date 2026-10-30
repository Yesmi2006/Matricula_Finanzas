package pe.edu.upeu.lamb.matricula.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.matricula.dto.SituacionAcademicaEstudianteRequest;
import pe.edu.upeu.lamb.matricula.dto.SituacionAcademicaEstudianteResponse;
import pe.edu.upeu.lamb.matricula.entity.SituacionAcademicaEstudiante;

@Component
public class SituacionAcademicaEstudianteMapper {

    public SituacionAcademicaEstudiante toEntity(SituacionAcademicaEstudianteRequest request) {
        return SituacionAcademicaEstudiante.builder()
                .idPersona(request.getIdPersona())
                .periodo(request.getPeriodo())
                .situacion(request.getSituacion())
                .build();
    }

    public SituacionAcademicaEstudianteResponse toResponse(SituacionAcademicaEstudiante entity) {
        return SituacionAcademicaEstudianteResponse.builder()
                .id(entity.getId())
                .idPersona(entity.getIdPersona())
                .periodo(entity.getPeriodo())
                .situacion(entity.getSituacion())
                .fechaRegistro(entity.getFechaRegistro())
                .build();
    }
}
