package pe.edu.upeu.lamb.finanzas.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.lamb.finanzas.dto.CategoriaConceptoRequest;
import pe.edu.upeu.lamb.finanzas.dto.CategoriaConceptoResponse;
import pe.edu.upeu.lamb.finanzas.dto.ConceptoPagoRequest;
import pe.edu.upeu.lamb.finanzas.dto.ConceptoPagoResponse;
import pe.edu.upeu.lamb.finanzas.dto.TarifarioEscuelaCicloRequest;
import pe.edu.upeu.lamb.finanzas.dto.TarifarioEscuelaCicloResponse;
import pe.edu.upeu.lamb.finanzas.service.CategoriaConceptoService;
import pe.edu.upeu.lamb.finanzas.service.ConceptoPagoService;
import pe.edu.upeu.lamb.finanzas.service.TarifarioEscuelaCicloService;

import java.util.List;

/**
 * Dominio "Catalogos y tarifas" (CRUD unificado). Subrecursos: categoria de
 * concepto, concepto de pago, tarifario por escuela y ciclo.
 */
@RestController
@RequestMapping("/api/v1/catalogos-tarifas")
@RequiredArgsConstructor
@Tag(name = "catalogos-y-tarifas-controller")
public class CatalogosTarifasController {

    private final CategoriaConceptoService categoriaConceptoService;
    private final ConceptoPagoService conceptoPagoService;
    private final TarifarioEscuelaCicloService tarifarioEscuelaCicloService;

    // --- Categoria de concepto ---

    @GetMapping("/categorias-concepto")
    @Operation(summary = "Listar categorias de concepto")
    public List<CategoriaConceptoResponse> listarCategoriasConcepto() {
        return categoriaConceptoService.listar();
    }

    @GetMapping("/categorias-concepto/{id}")
    @Operation(summary = "Obtener una categoria de concepto")
    public CategoriaConceptoResponse obtenerCategoriaConcepto(@PathVariable Long id) {
        return categoriaConceptoService.obtener(id);
    }

    @PostMapping("/categorias-concepto")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear una categoria de concepto")
    public CategoriaConceptoResponse crearCategoriaConcepto(@Valid @RequestBody CategoriaConceptoRequest request) {
        return categoriaConceptoService.crear(request);
    }

    // --- Concepto de pago ---

    @GetMapping("/conceptos-pago")
    @Operation(summary = "Listar conceptos de pago")
    public List<ConceptoPagoResponse> listarConceptosPago() {
        return conceptoPagoService.listar();
    }

    @GetMapping("/conceptos-pago/{id}")
    @Operation(summary = "Obtener un concepto de pago")
    public ConceptoPagoResponse obtenerConceptoPago(@PathVariable Long id) {
        return conceptoPagoService.obtener(id);
    }

    @PostMapping("/conceptos-pago")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear un concepto de pago")
    public ConceptoPagoResponse crearConceptoPago(@Valid @RequestBody ConceptoPagoRequest request) {
        return conceptoPagoService.crear(request);
    }

    // --- Tarifario por escuela y ciclo ---

    @GetMapping("/tarifarios-escuela-ciclo")
    @Operation(summary = "Listar tarifarios por escuela y ciclo")
    public List<TarifarioEscuelaCicloResponse> listarTarifarios() {
        return tarifarioEscuelaCicloService.listar();
    }

    @GetMapping("/tarifarios-escuela-ciclo/{id}")
    @Operation(summary = "Obtener un tarifario por escuela y ciclo")
    public TarifarioEscuelaCicloResponse obtenerTarifario(@PathVariable Long id) {
        return tarifarioEscuelaCicloService.obtener(id);
    }

    @PostMapping("/tarifarios-escuela-ciclo")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear un tarifario por escuela y ciclo")
    public TarifarioEscuelaCicloResponse crearTarifario(@Valid @RequestBody TarifarioEscuelaCicloRequest request) {
        return tarifarioEscuelaCicloService.crear(request);
    }
}
