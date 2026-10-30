package pe.edu.upeu.lamb.finanzas.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.lamb.finanzas.dto.CancelacionCargoMatriculaRequest;
import pe.edu.upeu.lamb.finanzas.dto.CancelacionCargoMatriculaResponse;
import pe.edu.upeu.lamb.finanzas.dto.ReembolsoPagoRequest;
import pe.edu.upeu.lamb.finanzas.dto.ReembolsoPagoResponse;
import pe.edu.upeu.lamb.finanzas.dto.SolicitudDevolucionRequest;
import pe.edu.upeu.lamb.finanzas.dto.SolicitudDevolucionResponse;
import pe.edu.upeu.lamb.finanzas.dto.TransferenciaPagoRequest;
import pe.edu.upeu.lamb.finanzas.dto.TransferenciaPagoResponse;
import pe.edu.upeu.lamb.finanzas.service.CancelacionCargoMatriculaService;
import pe.edu.upeu.lamb.finanzas.service.ReembolsoPagoService;
import pe.edu.upeu.lamb.finanzas.service.SolicitudDevolucionService;
import pe.edu.upeu.lamb.finanzas.service.TransferenciaPagoService;

import java.util.List;

/**
 * Dominio "Reembolsos y cancelaciones" (CRUD unificado). Subrecursos:
 * solicitud de devolucion, reembolso de pago, cancelacion de cargo por
 * anulacion de matricula, transferencia de pago.
 */
@RestController
@RequestMapping("/api/v1/reembolsos-cancelaciones")
@RequiredArgsConstructor
@Tag(name = "reembolsos-y-cancelaciones-controller")
public class ReembolsosCancelacionesController {

    private final SolicitudDevolucionService solicitudDevolucionService;
    private final ReembolsoPagoService reembolsoPagoService;
    private final CancelacionCargoMatriculaService cancelacionCargoMatriculaService;
    private final TransferenciaPagoService transferenciaPagoService;

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

    // --- Cancelacion de cargo por anulacion de matricula (idMatricula es JALA ID de lamb-matricula-ms) ---

    @GetMapping("/cancelaciones-cargo-matricula")
    @Operation(summary = "Listar cancelaciones de cargo por anulacion de matricula")
    public List<CancelacionCargoMatriculaResponse> listarCancelacionesCargoMatricula() {
        return cancelacionCargoMatriculaService.listar();
    }

    @GetMapping("/cancelaciones-cargo-matricula/{id}")
    @Operation(summary = "Obtener una cancelacion de cargo por anulacion de matricula")
    public CancelacionCargoMatriculaResponse obtenerCancelacionCargoMatricula(@PathVariable Long id) {
        return cancelacionCargoMatriculaService.obtener(id);
    }

    @PostMapping("/cancelaciones-cargo-matricula")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear una cancelacion de cargo por anulacion de matricula")
    public CancelacionCargoMatriculaResponse crearCancelacionCargoMatricula(@Valid @RequestBody CancelacionCargoMatriculaRequest request) {
        return cancelacionCargoMatriculaService.crear(request);
    }

    // --- Transferencia de pago ---

    @GetMapping("/transferencias-pago")
    @Operation(summary = "Listar transferencias de pago")
    public List<TransferenciaPagoResponse> listarTransferenciasPago() {
        return transferenciaPagoService.listar();
    }

    @GetMapping("/transferencias-pago/{id}")
    @Operation(summary = "Obtener una transferencia de pago")
    public TransferenciaPagoResponse obtenerTransferenciaPago(@PathVariable Long id) {
        return transferenciaPagoService.obtener(id);
    }

    @PostMapping("/transferencias-pago")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear una transferencia de pago")
    public TransferenciaPagoResponse crearTransferenciaPago(@Valid @RequestBody TransferenciaPagoRequest request) {
        return transferenciaPagoService.crear(request);
    }
}
