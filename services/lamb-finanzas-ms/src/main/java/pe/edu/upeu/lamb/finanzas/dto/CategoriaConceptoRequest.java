package pe.edu.upeu.lamb.finanzas.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 * CRUD marcado con (*) en el documento: "Categoria de concepto (OTRO CRUD)".
 */
@Getter
@Setter
public class CategoriaConceptoRequest {

    @NotNull
    @Size(max = 100)
    private String nombre;

    @Size(max = 255)
    private String descripcion;
}
