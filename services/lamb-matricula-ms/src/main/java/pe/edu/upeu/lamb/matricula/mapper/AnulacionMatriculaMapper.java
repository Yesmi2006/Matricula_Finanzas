package pe.edu.upeu.lamb.matricula.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.matricula.dto.AnulacionMatriculaRequest;
import pe.edu.upeu.lamb.matricula.dto.AnulacionMatriculaResponse;
import pe.edu.upeu.lamb.matricula.entity.AnulacionMatricula;

@Component
public class AnulacionMatriculaMapper {

    public AnulacionMatricula toEntity(AnulacionMatriculaRequest request) {
        return AnulacionMatricula.builder()
                .idMatricula(request.getIdMatricula())
                .motivo(request.getMotivo())
                .autorizadoPor(request.getAutorizadoPor())
                .build();
    }

    public AnulacionMatriculaResponse toResponse(AnulacionMatricula entity) {
        return AnulacionMatriculaResponse.builder()
                .id(entity.getId())
                .idMatricula(entity.getIdMatricula())
                .motivo(entity.getMotivo())
                .fechaAnulacion(entity.getFechaAnulacion())
                .autorizadoPor(entity.getAutorizadoPor())
                .build();
    }
}
