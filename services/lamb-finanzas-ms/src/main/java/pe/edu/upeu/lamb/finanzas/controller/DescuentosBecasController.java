package pe.edu.upeu.lamb.finanzas.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.lamb.finanzas.dto.DescuentoAplicadoRequest;
import pe.edu.upeu.lamb.finanzas.dto.DescuentoAplicadoResponse;
import pe.edu.upeu.lamb.finanzas.dto.TipoDescuentoRequest;
import pe.edu.upeu.lamb.finanzas.dto.TipoDescuentoResponse;
import pe.edu.upeu.lamb.finanzas.service.DescuentoAplicadoService;
import pe.edu.upeu.lamb.finanzas.service.TipoDescuentoService;

import java.util.List;

/**
 * Dominio "Descuentos y becas" (CRUD unificado). Subrecursos: tipo de
 * descuento, descuento aplicado.
 */
@RestController
@RequestMapping("/api/v1/descuentos-becas")
@RequiredArgsConstructor
@Tag(name = "descuentos-y-becas-controller")
public class DescuentosBecasController {

    private final TipoDescuentoService tipoDescuentoService;
    private final DescuentoAplicadoService descuentoAplicadoService;

    // --- Tipo de descuento ---

    @GetMapping("/tipos-descuento")
    @Operation(summary = "Listar tipos de descuento")
    public List<TipoDescuentoResponse> listarTiposDescuento() {
        return tipoDescuentoService.listar();
    }

    @GetMapping("/tipos-descuento/{id}")
    @Operation(summary = "Obtener un tipo de descuento")
    public TipoDescuentoResponse obtenerTipoDescuento(@PathVariable Long id) {
        return tipoDescuentoService.obtener(id);
    }

    @PostMapping("/tipos-descuento")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear un tipo de descuento")
    public TipoDescuentoResponse crearTipoDescuento(@Valid @RequestBody TipoDescuentoRequest request) {
        return tipoDescuentoService.crear(request);
    }

    // --- Descuento aplicado ---

    @GetMapping("/descuentos-aplicados")
    @Operation(summary = "Listar descuentos aplicados")
    public List<DescuentoAplicadoResponse> listarDescuentosAplicados() {
        return descuentoAplicadoService.listar();
    }

    @GetMapping("/descuentos-aplicados/{id}")
    @Operation(summary = "Obtener un descuento aplicado")
    public DescuentoAplicadoResponse obtenerDescuentoAplicado(@PathVariable Long id) {
        return descuentoAplicadoService.obtener(id);
    }

    @PostMapping("/descuentos-aplicados")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear un descuento aplicado")
    public DescuentoAplicadoResponse crearDescuentoAplicado(@Valid @RequestBody DescuentoAplicadoRequest request) {
        return descuentoAplicadoService.crear(request);
    }
}
