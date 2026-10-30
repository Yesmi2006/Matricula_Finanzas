package pe.edu.upeu.lamb.matricula.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.matricula.dto.AnulacionMasivaImpagoRequest;
import pe.edu.upeu.lamb.matricula.dto.AnulacionMasivaImpagoResponse;
import pe.edu.upeu.lamb.matricula.entity.AnulacionMasivaImpago;

@Component
public class AnulacionMasivaImpagoMapper {

    public AnulacionMasivaImpago toEntity(AnulacionMasivaImpagoRequest request) {
        return AnulacionMasivaImpago.builder()
                .periodo(request.getPeriodo())
                .totalMatriculasAnuladas(request.getTotalMatriculasAnuladas())
                .motivo(request.getMotivo())
                .build();
    }

    public AnulacionMasivaImpagoResponse toResponse(AnulacionMasivaImpago entity) {
        return AnulacionMasivaImpagoResponse.builder()
                .id(entity.getId())
                .periodo(entity.getPeriodo())
                .totalMatriculasAnuladas(entity.getTotalMatriculasAnuladas())
                .motivo(entity.getMotivo())
                .fechaEjecucion(entity.getFechaEjecucion())
                .build();
    }
}
