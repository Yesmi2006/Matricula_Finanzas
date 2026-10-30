package pe.edu.upeu.lamb.matricula.mapper;

import pe.edu.upeu.lamb.matricula.dto.CompromisoMatriculaRequest;
import pe.edu.upeu.lamb.matricula.dto.CompromisoMatriculaResponse;
import pe.edu.upeu.lamb.matricula.entity.CompromisoMatricula;
import org.springframework.stereotype.Component;

@Component
public class CompromisoMatriculaMapper {

    public CompromisoMatricula toEntity(CompromisoMatriculaRequest request) {
        return CompromisoMatricula.builder()
                .idMatricula(request.getIdMatricula())
                .montoComprometido(request.getMontoComprometido())
                .fechaFirma(request.getFechaFirma())
                .documentoUrl(request.getDocumentoUrl())
                .build();
    }

    public CompromisoMatriculaResponse toResponse(CompromisoMatricula entity) {
        return CompromisoMatriculaResponse.builder()
                .id(entity.getId())
                .idMatricula(entity.getIdMatricula())
                .montoComprometido(entity.getMontoComprometido())
                .fechaFirma(entity.getFechaFirma())
                .documentoUrl(entity.getDocumentoUrl())
                .build();
    }
}
