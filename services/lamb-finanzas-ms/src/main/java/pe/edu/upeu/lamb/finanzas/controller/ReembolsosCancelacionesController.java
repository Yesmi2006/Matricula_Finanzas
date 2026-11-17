package pe.edu.upeu.lamb.finanzas.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.lamb.finanzas.dto.ReembolsoPagoRequest;
import pe.edu.upeu.lamb.finanzas.dto.ReembolsoPagoResponse;
import pe.edu.upeu.lamb.finanzas.dto.SolicitudDevolucionRequest;
import pe.edu.upeu.lamb.finanzas.dto.SolicitudDevolucionResponse;
import pe.edu.upeu.lamb.finanzas.service.ReembolsoPagoService;
import pe.edu.upeu.lamb.finanzas.service.SolicitudDevolucionService;

import java.util.List;

/**
 * Dominio "Reembolsos y cancelaciones" (CRUD unificado). Subrecursos:
 * solicitud de devolucion, reembolso de pago. La cancelacion de cargo por
 * anulacion de matricula sigue viviendo en el consumer/service interno.
 */
@RestController
@RequestMapping("/api/v1/reembolsos-cancelaciones")
@RequiredArgsConstructor
@Tag(name = "reembolsos-y-cancelaciones-controller")
public class ReembolsosCancelacionesController {

    private final SolicitudDevolucionService solicitudDevolucionService;
    private final ReembolsoPagoService reembolsoPagoService;

    // --- Solicitud de devolucion ---

    @GetMapping("/solicitudes-devolucion")
    @Operation(summary = "Listar solicitudes de devolucion")
    public List<SolicitudDevolucionResponse> listarSolicitudesDevolucion() {
        return solicitudDevolucionService.listar();
    }

    @GetMapping("/solicitudes-devolucion/{id}")
    @Operation(summary = "Obtener una solicitud de devolucion")
    public SolicitudDevolucionResponse obtenerSolicitudDevolucion(@PathVariable Long id) {
        return solicitudDevolucionService.obtener(id);
    }

    @PostMapping("/solicitudes-devolucion")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear una solicitud de devolucion")
    public SolicitudDevolucionResponse crearSolicitudDevolucion(@Valid @RequestBody SolicitudDevolucionRequest request) {
        return solicitudDevolucionService.crear(request);
    }

    // --- Reembolso de pago (impacta CuentaEstudiante, dominio Saldo del Estudiante) ---

    @GetMapping("/reembolsos-pago")
    @Operation(summary = "Listar reembolsos de pago")
    public List<ReembolsoPagoResponse> listarReembolsosPago() {
        return reembolsoPagoService.listar();
    }

    @GetMapping("/reembolsos-pago/{id}")
    @Operation(summary = "Obtener un reembolso de pago")
    public ReembolsoPagoResponse obtenerReembolsoPago(@PathVariable Long id) {
        return reembolsoPagoService.obtener(id);
    }

    @PostMapping("/reembolsos-pago")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear un reembolso de pago")
    public ReembolsoPagoResponse crearReembolsoPago(@Valid @RequestBody ReembolsoPagoRequest request) {
        return reembolsoPagoService.crear(request);
    }
}
