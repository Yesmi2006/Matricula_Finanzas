package pe.edu.upeu.lamb.matricula.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CambioSituacionAcademicaResponse {
    private Long id;
    private Long idSituacionAcademica;
    private String situacionAnterior;
    private String situacionNueva;
    private String resolucion;
    private Instant fechaCambio;
}
