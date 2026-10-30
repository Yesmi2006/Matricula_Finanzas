package pe.edu.upeu.lamb.finanzas.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.finanzas.dto.TarifarioEscuelaCicloResponse;
import pe.edu.upeu.lamb.finanzas.entity.TarifarioEscuelaCiclo;

@Component
public class TarifarioEscuelaCicloMapper {

    public TarifarioEscuelaCicloResponse toResponse(TarifarioEscuelaCiclo entity) {
        return TarifarioEscuelaCicloResponse.builder()
                .id(entity.getId())
                .idConceptoPago(entity.getConceptoPago().getId())
                .idEscuela(entity.getIdEscuela())
                .ciclo(entity.getCiclo())
                .monto(entity.getMonto())
                .build();
    }
}
