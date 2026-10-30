package pe.edu.upeu.lamb.matricula.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.matricula.dto.EleccionCursoElectivoRequest;
import pe.edu.upeu.lamb.matricula.dto.EleccionCursoElectivoResponse;
import pe.edu.upeu.lamb.matricula.entity.EleccionCursoElectivo;

@Component
public class EleccionCursoElectivoMapper {

    public EleccionCursoElectivo toEntity(EleccionCursoElectivoRequest request) {
        return EleccionCursoElectivo.builder()
                .idPersona(request.getIdPersona())
                .idCurso(request.getIdCurso())
                .periodo(request.getPeriodo())
                .build();
    }

    public EleccionCursoElectivoResponse toResponse(EleccionCursoElectivo entity) {
        return EleccionCursoElectivoResponse.builder()
                .id(entity.getId())
                .idPersona(entity.getIdPersona())
                .idCurso(entity.getIdCurso())
                .periodo(entity.getPeriodo())
                .fechaEleccion(entity.getFechaEleccion())
                .build();
    }
}
