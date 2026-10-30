package pe.edu.upeu.lamb.matricula.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.matricula.dto.CargaAcademicaPeriodoRequest;
import pe.edu.upeu.lamb.matricula.dto.CargaAcademicaPeriodoResponse;
import pe.edu.upeu.lamb.matricula.entity.CargaAcademicaPeriodo;

@Component
public class CargaAcademicaPeriodoMapper {

    public CargaAcademicaPeriodo toEntity(CargaAcademicaPeriodoRequest request) {
        return CargaAcademicaPeriodo.builder()
                .idPersona(request.getIdPersona())
                .periodo(request.getPeriodo())
                .totalCreditos(request.getTotalCreditos())
                .totalCursos(request.getTotalCursos())
                .build();
    }

    public CargaAcademicaPeriodoResponse toResponse(CargaAcademicaPeriodo entity) {
        return CargaAcademicaPeriodoResponse.builder()
                .id(entity.getId())
                .idPersona(entity.getIdPersona())
                .periodo(entity.getPeriodo())
                .totalCreditos(entity.getTotalCreditos())
                .totalCursos(entity.getTotalCursos())
                .fechaCalculo(entity.getFechaCalculo())
                .build();
    }
}
