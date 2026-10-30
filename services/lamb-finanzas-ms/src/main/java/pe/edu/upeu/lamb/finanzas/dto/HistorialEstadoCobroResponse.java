package pe.edu.upeu.lamb.finanzas.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.edu.upeu.lamb.finanzas.entity.EstadoCobroTipo;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HistorialEstadoCobroResponse {

    private Long id;
    private Long idEstadoCobro;
    private EstadoCobroTipo estado;
    private LocalDate fecha;
}
