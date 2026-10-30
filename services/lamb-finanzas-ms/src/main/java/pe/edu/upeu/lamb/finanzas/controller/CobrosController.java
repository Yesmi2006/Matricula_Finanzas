package pe.edu.upeu.lamb.finanzas.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.lamb.finanzas.dto.DetalleCobroRequest;
import pe.edu.upeu.lamb.finanzas.dto.DetalleCobroResponse;
import pe.edu.upeu.lamb.finanzas.dto.EstadoCobroRequest;
import pe.edu.upeu.lamb.finanzas.dto.EstadoCobroResponse;
import pe.edu.upeu.lamb.finanzas.dto.HistorialEstadoCobroRequest;
import pe.edu.upeu.lamb.finanzas.dto.HistorialEstadoCobroResponse;
import pe.edu.upeu.lamb.finanzas.dto.MontoPagoRequest;
import pe.edu.upeu.lamb.finanzas.dto.MontoPagoResponse;
import pe.edu.upeu.lamb.finanzas.service.DetalleCobroService;
import pe.edu.upeu.lamb.finanzas.service.EstadoCobroService;
import pe.edu.upeu.lamb.finanzas.service.HistorialEstadoCobroService;
import pe.edu.upeu.lamb.finanzas.service.MontoPagoService;

import java.util.List;

/**
 * Dominio "Cobros" (CRUD unificado). Subrecursos: estado de cobro, detalle de
 * cobro (opcional segun universidad), historial de estado de cobro, monto de
 * pago.
 */
@RestController
@RequestMapping("/api/v1/cobros")
@RequiredArgsConstructor
@Tag(name = "cobros-controller")
public class CobrosController {

    private final EstadoCobroService estadoCobroService;
    private final DetalleCobroService detalleCobroService;
    private final HistorialEstadoCobroService historialEstadoCobroService;
    private final MontoPagoService montoPagoService;

    // --- Estado de cobro ---

    @GetMapping("/estados-cobro")
    @Operation(summary = "Listar estados de cobro")
    public List<EstadoCobroResponse> listarEstadosCobro() {
        return estadoCobroService.listar();
    }

    @GetMapping("/estados-cobro/{id}")
    @Operation(summary = "Obtener un estado de cobro")
    public EstadoCobroResponse obtenerEstadoCobro(@PathVariable Long id) {
        return estadoCobroService.obtener(id);
    }

    @PostMapping("/estados-cobro")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear un estado de cobro")
    public EstadoCobroResponse crearEstadoCobro(@Valid @RequestBody EstadoCobroRequest request) {
        return estadoCobroService.crear(request);
    }

    // --- Detalle de cobro (opcional segun universidad) ---

    @GetMapping("/detalles-cobro")
    @Operation(summary = "Listar detalles de cobro")
    public List<DetalleCobroResponse> listarDetallesCobro() {
        return detalleCobroService.listar();
    }

    @GetMapping("/detalles-cobro/{id}")
    @Operation(summary = "Obtener un detalle de cobro")
    public DetalleCobroResponse obtenerDetalleCobro(@PathVariable Long id) {
        return detalleCobroService.obtener(id);
    }

    @PostMapping("/detalles-cobro")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear un detalle de cobro")
    public DetalleCobroResponse crearDetalleCobro(@Valid @RequestBody DetalleCobroRequest request) {
        return detalleCobroService.crear(request);
    }

    // --- Historial de estado de cobro ---

    @GetMapping("/historiales-estado-cobro")
    @Operation(summary = "Listar historiales de estado de cobro")
    public List<HistorialEstadoCobroResponse> listarHistorialesEstadoCobro() {
        return historialEstadoCobroService.listar();
    }

    @GetMapping("/historiales-estado-cobro/{id}")
    @Operation(summary = "Obtener un historial de estado de cobro")
    public HistorialEstadoCobroResponse obtenerHistorialEstadoCobro(@PathVariable Long id) {
        return historialEstadoCobroService.obtener(id);
    }

    @PostMapping("/historiales-estado-cobro")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear un historial de estado de cobro")
    public HistorialEstadoCobroResponse crearHistorialEstadoCobro(@Valid @RequestBody HistorialEstadoCobroRequest request) {
        return historialEstadoCobroService.crear(request);
    }

    // --- Monto de pago ---

    @GetMapping("/montos-pago")
    @Operation(summary = "Listar montos de pago")
    public List<MontoPagoResponse> listarMontosPago() {
        return montoPagoService.listar();
    }

    @GetMapping("/montos-pago/{id}")
    @Operation(summary = "Obtener un monto de pago")
    public MontoPagoResponse obtenerMontoPago(@PathVariable Long id) {
        return montoPagoService.obtener(id);
    }

    @PostMapping("/montos-pago")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear un monto de pago")
    public MontoPagoResponse crearMontoPago(@Valid @RequestBody MontoPagoRequest request) {
        return montoPagoService.crear(request);
    }
}
