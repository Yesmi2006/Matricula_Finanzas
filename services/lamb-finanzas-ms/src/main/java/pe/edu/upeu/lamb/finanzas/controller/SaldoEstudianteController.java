package pe.edu.upeu.lamb.finanzas.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.lamb.finanzas.dto.CuentaEstudianteRequest;
import pe.edu.upeu.lamb.finanzas.dto.CuentaEstudianteResponse;
import pe.edu.upeu.lamb.finanzas.dto.MovimientoCuentaRequest;
import pe.edu.upeu.lamb.finanzas.dto.MovimientoCuentaResponse;
import pe.edu.upeu.lamb.finanzas.dto.ReservaSaldoDevolucionRequest;
import pe.edu.upeu.lamb.finanzas.dto.ReservaSaldoDevolucionResponse;
import pe.edu.upeu.lamb.finanzas.service.CuentaEstudianteService;
import pe.edu.upeu.lamb.finanzas.service.MovimientoCuentaService;
import pe.edu.upeu.lamb.finanzas.service.ReservaSaldoDevolucionService;

import java.util.List;

/**
 * Dominio "Saldo del Estudiante" (CRUD unificado). Subrecursos: cuenta del
 * estudiante, movimientos de cuenta, reserva de saldo para devolucion.
 */
@RestController
@RequestMapping("/api/v1/saldo-estudiante")
@RequiredArgsConstructor
@Tag(name = "saldo-del-estudiante-controller")
public class SaldoEstudianteController {

    private final CuentaEstudianteService cuentaEstudianteService;
    private final MovimientoCuentaService movimientoCuentaService;
    private final ReservaSaldoDevolucionService reservaSaldoDevolucionService;

    // --- Cuenta del estudiante (item 64) ---

    @GetMapping("/cuentas")
    @Operation(summary = "Listar cuentas del estudiante")
    public List<CuentaEstudianteResponse> listarCuentas() {
        return cuentaEstudianteService.listar();
    }

    @GetMapping("/cuentas/{id}")
    @Operation(summary = "Obtener una cuenta del estudiante")
    public CuentaEstudianteResponse obtenerCuenta(@PathVariable Long id) {
        return cuentaEstudianteService.obtener(id);
    }

    @PostMapping("/cuentas")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear una cuenta del estudiante")
    public CuentaEstudianteResponse crearCuenta(@Valid @RequestBody CuentaEstudianteRequest request) {
        return cuentaEstudianteService.crear(request);
    }

    // --- Movimiento de cuenta (item 65) ---

    @GetMapping("/movimientos")
    @Operation(summary = "Listar movimientos de cuenta")
    public List<MovimientoCuentaResponse> listarMovimientos() {
        return movimientoCuentaService.listar();
    }

    @GetMapping("/movimientos/{id}")
    @Operation(summary = "Obtener un movimiento de cuenta")
    public MovimientoCuentaResponse obtenerMovimiento(@PathVariable Long id) {
        return movimientoCuentaService.obtener(id);
    }

    @PostMapping("/movimientos")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear un movimiento de cuenta")
    public MovimientoCuentaResponse crearMovimiento(@Valid @RequestBody MovimientoCuentaRequest request) {
        return movimientoCuentaService.crear(request);
    }

    // --- Reserva de saldo para devolucion (item 69, opcional) ---

    @GetMapping("/reservas-devolucion")
    @Operation(summary = "Listar reservas de saldo para devolucion")
    public List<ReservaSaldoDevolucionResponse> listarReservasDevolucion() {
        return reservaSaldoDevolucionService.listar();
    }

    @GetMapping("/reservas-devolucion/{id}")
    @Operation(summary = "Obtener una reserva de saldo para devolucion")
    public ReservaSaldoDevolucionResponse obtenerReservaDevolucion(@PathVariable Long id) {
        return reservaSaldoDevolucionService.obtener(id);
    }

    @PostMapping("/reservas-devolucion")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear una reserva de saldo para devolucion")
    public ReservaSaldoDevolucionResponse crearReservaDevolucion(@Valid @RequestBody ReservaSaldoDevolucionRequest request) {
        return reservaSaldoDevolucionService.crear(request);
    }
}
