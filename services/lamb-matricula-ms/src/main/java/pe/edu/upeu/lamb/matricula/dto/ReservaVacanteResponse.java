package pe.edu.upeu.lamb.matricula.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class ReservaVacanteResponse {
    private Long id;
    private Long idSeccion;
    private Long idPersona;
    private LocalDate fechaReserva;
    private LocalDate vigenciaHasta;
    private String estado;
}
