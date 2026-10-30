package pe.edu.upeu.lamb.matricula.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class CompromisoMatriculaRequest {

    @NotNull
    private Long idMatricula;

    @NotNull
    private BigDecimal montoComprometido;

    @NotNull
    private LocalDate fechaFirma;

    @Size(max = 255)
    private String documentoUrl;
}
