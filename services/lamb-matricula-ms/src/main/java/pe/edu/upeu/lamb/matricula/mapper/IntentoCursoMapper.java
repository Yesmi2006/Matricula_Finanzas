package pe.edu.upeu.lamb.matricula.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.matricula.dto.IntentoCursoRequest;
import pe.edu.upeu.lamb.matricula.dto.IntentoCursoResponse;
import pe.edu.upeu.lamb.matricula.entity.IntentoCurso;

@Component
public class IntentoCursoMapper {

    public IntentoCurso toEntity(IntentoCursoRequest request) {
        return IntentoCurso.builder()
                .idPersona(request.getIdPersona())
                .idCurso(request.getIdCurso())
                .numeroIntento(request.getNumeroIntento())
                .periodo(request.getPeriodo())
                .build();
    }

    public IntentoCursoResponse toResponse(IntentoCurso entity) {
        return IntentoCursoResponse.builder()
                .id(entity.getId())
                .idPersona(entity.getIdPersona())
                .idCurso(entity.getIdCurso())
                .numeroIntento(entity.getNumeroIntento())
                .periodo(entity.getPeriodo())
                .fechaRegistro(entity.getFechaRegistro())
                .build();
    }
}
