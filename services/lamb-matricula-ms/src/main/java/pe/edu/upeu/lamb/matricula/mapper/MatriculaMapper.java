package pe.edu.upeu.lamb.matricula.mapper;

import pe.edu.upeu.lamb.matricula.dto.MatriculaRequest;
import pe.edu.upeu.lamb.matricula.dto.MatriculaResponse;
import pe.edu.upeu.lamb.matricula.entity.EstadoMatricula;
import pe.edu.upeu.lamb.matricula.entity.Matricula;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@RequiredArgsConstructor
public class MatriculaMapper {

    private final DetalleMatriculaMapper detalleMatriculaMapper;
    private final CondicionMatriculaMapper condicionMatriculaMapper;

    public Matricula toEntity(MatriculaRequest request) {
        Matricula matricula = Matricula.builder()
                .idPersona(request.getIdPersona())
                .periodo(request.getPeriodo())
                .fecha(Instant.now())
                .estado(EstadoMatricula.REGISTRADA)
                .build();

        request.getDetalles().forEach(d -> {
            var detalle = detalleMatriculaMapper.toEntity(d);
            detalle.setMatricula(matricula);
            matricula.getDetalles().add(detalle);
        });

        return matricula;
    }

    public MatriculaResponse toResponse(Matricula matricula) {
        return MatriculaResponse.builder()
                .id(matricula.getId())
                .idPersona(matricula.getIdPersona())
                .periodo(matricula.getPeriodo())
                .fecha(matricula.getFecha())
                .estado(matricula.getEstado())
                .detalles(matricula.getDetalles().stream().map(detalleMatriculaMapper::toResponse).toList())
                .condiciones(matricula.getCondiciones().stream().map(condicionMatriculaMapper::toResponse).toList())
                .build();
    }
}
