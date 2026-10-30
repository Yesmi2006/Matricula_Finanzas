package pe.edu.upeu.lamb.matricula.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Builder
public class CompromisoMatriculaResponse {
    private Long id;
    private Long idMatricula;
    private BigDecimal montoComprometido;
    private LocalDate fechaFirma;
    private String documentoUrl;
}
