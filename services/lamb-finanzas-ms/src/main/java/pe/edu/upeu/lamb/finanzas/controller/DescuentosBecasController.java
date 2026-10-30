package pe.edu.upeu.lamb.finanzas.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.lamb.finanzas.dto.BecaAplicadaRequest;
import pe.edu.upeu.lamb.finanzas.dto.BecaAplicadaResponse;
import pe.edu.upeu.lamb.finanzas.dto.ConvenioInstitucionalDescuentoRequest;
import pe.edu.upeu.lamb.finanzas.dto.ConvenioInstitucionalDescuentoResponse;
import pe.edu.upeu.lamb.finanzas.dto.DescuentoAplicadoRequest;
import pe.edu.upeu.lamb.finanzas.dto.DescuentoAplicadoResponse;
import pe.edu.upeu.lamb.finanzas.dto.ExoneracionPagoRequest;
import pe.edu.upeu.lamb.finanzas.dto.ExoneracionPagoResponse;
import pe.edu.upeu.lamb.finanzas.dto.RenovacionSuspensionBecaRequest;
import pe.edu.upeu.lamb.finanzas.dto.RenovacionSuspensionBecaResponse;
import pe.edu.upeu.lamb.finanzas.dto.TipoBecaRequest;
import pe.edu.upeu.lamb.finanzas.dto.TipoBecaResponse;
import pe.edu.upeu.lamb.finanzas.dto.TipoDescuentoRequest;
import pe.edu.upeu.lamb.finanzas.dto.TipoDescuentoResponse;
import pe.edu.upeu.lamb.finanzas.service.BecaAplicadaService;
import pe.edu.upeu.lamb.finanzas.service.ConvenioInstitucionalDescuentoService;
import pe.edu.upeu.lamb.finanzas.service.DescuentoAplicadoService;
import pe.edu.upeu.lamb.finanzas.service.ExoneracionPagoService;
import pe.edu.upeu.lamb.finanzas.service.RenovacionSuspensionBecaService;
import pe.edu.upeu.lamb.finanzas.service.TipoBecaService;
import pe.edu.upeu.lamb.finanzas.service.TipoDescuentoService;

import java.util.List;

/**
 * Dominio "Descuentos y becas" (CRUD unificado). Subrecursos: tipo de
 * descuento, descuento aplicado, convenio institucional de descuento
 * (opcional segun universidad), exoneracion de pago, tipo de beca, beca
 * aplicada, renovacion/suspension de beca.
 */
@RestController
@RequestMapping("/api/v1/descuentos-becas")
@RequiredArgsConstructor
@Tag(name = "descuentos-y-becas-controller")
public class DescuentosBecasController {

    private final TipoDescuentoService tipoDescuentoService;
    private final DescuentoAplicadoService descuentoAplicadoService;
    private final ConvenioInstitucionalDescuentoService convenioInstitucionalDescuentoService;
    private final ExoneracionPagoService exoneracionPagoService;
    private final TipoBecaService tipoBecaService;
    private final BecaAplicadaService becaAplicadaService;
    private final RenovacionSuspensionBecaService renovacionSuspensionBecaService;

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

    // --- Convenio institucional de descuento (opcional segun universidad) ---

    @GetMapping("/convenios-institucionales-descuento")
    @Operation(summary = "Listar convenios institucionales de descuento")
    public List<ConvenioInstitucionalDescuentoResponse> listarConvenios() {
        return convenioInstitucionalDescuentoService.listar();
    }

    @GetMapping("/convenios-institucionales-descuento/{id}")
    @Operation(summary = "Obtener un convenio institucional de descuento")
    public ConvenioInstitucionalDescuentoResponse obtenerConvenio(@PathVariable Long id) {
        return convenioInstitucionalDescuentoService.obtener(id);
    }

    @PostMapping("/convenios-institucionales-descuento")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear un convenio institucional de descuento")
    public ConvenioInstitucionalDescuentoResponse crearConvenio(@Valid @RequestBody ConvenioInstitucionalDescuentoRequest request) {
        return convenioInstitucionalDescuentoService.crear(request);
    }

    // --- Exoneracion de pago ---

    @GetMapping("/exoneraciones-pago")
    @Operation(summary = "Listar exoneraciones de pago")
    public List<ExoneracionPagoResponse> listarExoneraciones() {
        return exoneracionPagoService.listar();
    }

    @GetMapping("/exoneraciones-pago/{id}")
    @Operation(summary = "Obtener una exoneracion de pago")
    public ExoneracionPagoResponse obtenerExoneracion(@PathVariable Long id) {
        return exoneracionPagoService.obtener(id);
    }

    @PostMapping("/exoneraciones-pago")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear una exoneracion de pago")
    public ExoneracionPagoResponse crearExoneracion(@Valid @RequestBody ExoneracionPagoRequest request) {
        return exoneracionPagoService.crear(request);
    }

    // --- Tipo de beca ---

    @GetMapping("/tipos-beca")
    @Operation(summary = "Listar tipos de beca")
    public List<TipoBecaResponse> listarTiposBeca() {
        return tipoBecaService.listar();
    }

    @GetMapping("/tipos-beca/{id}")
    @Operation(summary = "Obtener un tipo de beca")
    public TipoBecaResponse obtenerTipoBeca(@PathVariable Long id) {
        return tipoBecaService.obtener(id);
    }

    @PostMapping("/tipos-beca")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear un tipo de beca")
    public TipoBecaResponse crearTipoBeca(@Valid @RequestBody TipoBecaRequest request) {
        return tipoBecaService.crear(request);
    }

    // --- Beca aplicada ---

    @GetMapping("/becas-aplicadas")
    @Operation(summary = "Listar becas aplicadas")
    public List<BecaAplicadaResponse> listarBecasAplicadas() {
        return becaAplicadaService.listar();
    }

    @GetMapping("/becas-aplicadas/{id}")
    @Operation(summary = "Obtener una beca aplicada")
    public BecaAplicadaResponse obtenerBecaAplicada(@PathVariable Long id) {
        return becaAplicadaService.obtener(id);
    }

    @PostMapping("/becas-aplicadas")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear una beca aplicada")
    public BecaAplicadaResponse crearBecaAplicada(@Valid @RequestBody BecaAplicadaRequest request) {
        return becaAplicadaService.crear(request);
    }

    // --- Renovacion/suspension de beca ---

    @GetMapping("/renovaciones-suspensiones-beca")
    @Operation(summary = "Listar renovaciones/suspensiones de beca")
    public List<RenovacionSuspensionBecaResponse> listarRenovacionesSuspensiones() {
        return renovacionSuspensionBecaService.listar();
    }

    @GetMapping("/renovaciones-suspensiones-beca/{id}")
    @Operation(summary = "Obtener una renovacion/suspension de beca")
    public RenovacionSuspensionBecaResponse obtenerRenovacionSuspension(@PathVariable Long id) {
        return renovacionSuspensionBecaService.obtener(id);
    }

    @PostMapping("/renovaciones-suspensiones-beca")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear una renovacion/suspension de beca")
    public RenovacionSuspensionBecaResponse crearRenovacionSuspension(@Valid @RequestBody RenovacionSuspensionBecaRequest request) {
        return renovacionSuspensionBecaService.crear(request);
    }
}
