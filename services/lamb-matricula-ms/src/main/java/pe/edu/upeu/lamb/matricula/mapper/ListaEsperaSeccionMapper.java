package pe.edu.upeu.lamb.matricula.mapper;

import pe.edu.upeu.lamb.matricula.dto.ListaEsperaSeccionRequest;
import pe.edu.upeu.lamb.matricula.dto.ListaEsperaSeccionResponse;
import pe.edu.upeu.lamb.matricula.entity.ListaEsperaSeccion;
import org.springframework.stereotype.Component;

@Component
public class ListaEsperaSeccionMapper {

    public ListaEsperaSeccion toEntity(ListaEsperaSeccionRequest request) {
        return ListaEsperaSeccion.builder()
                .idSeccion(request.getIdSeccion())
                .idPersona(request.getIdPersona())
                .posicion(request.getPosicion())
                .fechaInscripcion(request.getFechaInscripcion())
                .build();
    }

    public ListaEsperaSeccionResponse toResponse(ListaEsperaSeccion entity) {
        return ListaEsperaSeccionResponse.builder()
                .id(entity.getId())
                .idSeccion(entity.getIdSeccion())
                .idPersona(entity.getIdPersona())
                .posicion(entity.getPosicion())
                .fechaInscripcion(entity.getFechaInscripcion())
                .build();
    }
}
