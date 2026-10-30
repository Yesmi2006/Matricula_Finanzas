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
public class CargaAcademicaPeriodoResponse {
    private Long id;
    private Long idPersona;
    private String periodo;
    private Integer totalCreditos;
    private Integer totalCursos;
    private Instant fechaCalculo;
}
