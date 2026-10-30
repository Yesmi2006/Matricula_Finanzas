package pe.edu.upeu.lamb.matricula.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.matricula.dto.MovilidadEstudiantilRequest;
import pe.edu.upeu.lamb.matricula.dto.MovilidadEstudiantilResponse;
import pe.edu.upeu.lamb.matricula.entity.MovilidadEstudiantil;

@Component
public class MovilidadEstudiantilMapper {

    public MovilidadEstudiantil toEntity(MovilidadEstudiantilRequest request) {
        return MovilidadEstudiantil.builder()
                .idPersona(request.getIdPersona())
                .institucionDestino(request.getInstitucionDestino())
                .tipoMovilidad(request.getTipoMovilidad())
                .periodo(request.getPeriodo())
                .fechaInicio(request.getFechaInicio())
                .fechaFin(request.getFechaFin())
                .build();
    }

    public MovilidadEstudiantilResponse toResponse(MovilidadEstudiantil entity) {
        return MovilidadEstudiantilResponse.builder()
                .id(entity.getId())
                .idPersona(entity.getIdPersona())
                .institucionDestino(entity.getInstitucionDestino())
                .tipoMovilidad(entity.getTipoMovilidad())
                .periodo(entity.getPeriodo())
                .fechaInicio(entity.getFechaInicio())
                .fechaFin(entity.getFechaFin())
                .estado(entity.getEstado())
                .build();
    }
}
