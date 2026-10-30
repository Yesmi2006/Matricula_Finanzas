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
public class AnulacionMasivaImpagoResponse {
    private Long id;
    private String periodo;
    private Integer totalMatriculasAnuladas;
    private String motivo;
    private Instant fechaEjecucion;
}
