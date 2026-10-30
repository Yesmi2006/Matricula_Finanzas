package pe.edu.upeu.lamb.finanzas.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.lamb.finanzas.dto.ConstanciaNoAdeudoRequest;
import pe.edu.upeu.lamb.finanzas.dto.ConstanciaNoAdeudoResponse;
import pe.edu.upeu.lamb.finanzas.dto.EstadoCuentaEstudianteRequest;
import pe.edu.upeu.lamb.finanzas.dto.EstadoCuentaEstudianteResponse;
import pe.edu.upeu.lamb.finanzas.dto.ReclamoPagoRequest;
import pe.edu.upeu.lamb.finanzas.dto.ReclamoPagoResponse;
import pe.edu.upeu.lamb.finanzas.service.ConstanciaNoAdeudoService;
import pe.edu.upeu.lamb.finanzas.service.EstadoCuentaEstudianteService;
import pe.edu.upeu.lamb.finanzas.service.ReclamoPagoService;

import java.util.List;

/**
 * Dominio "Control y cierre" (CRUD unificado). Subrecursos: reclamo de pago,
 * estado de cuenta del estudiante, constancia de no adeudo.
 */
@RestController
@RequestMapping("/api/v1/control-cierre")
@RequiredArgsConstructor
@Tag(name = "control-y-cierre-controller")
public class ControlCierreController {

    private final ReclamoPagoService reclamoPagoService;
    private final EstadoCuentaEstudianteService estadoCuentaEstudianteService;
    private final ConstanciaNoAdeudoService constanciaNoAdeudoService;

    // --- Reclamo de pago ---

    @GetMapping("/reclamos-pago")
    @Operation(summary = "Listar reclamos de pago")
    public List<ReclamoPagoResponse> listarReclamosPago() {
        return reclamoPagoService.listar();
    }

    @GetMapping("/reclamos-pago/{id}")
    @Operation(summary = "Obtener un reclamo de pago")
    public ReclamoPagoResponse obtenerReclamoPago(@PathVariable Long id) {
        return reclamoPagoService.obtener(id);
    }

    @PostMapping("/reclamos-pago")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear un reclamo de pago")
    public ReclamoPagoResponse crearReclamoPago(@Valid @RequestBody ReclamoPagoRequest request) {
        return reclamoPagoService.crear(request);
    }

    // --- Estado de cuenta del estudiante ---

    @GetMapping("/estados-cuenta-estudiante")
    @Operation(summary = "Listar estados de cuenta del estudiante")
    public List<EstadoCuentaEstudianteResponse> listarEstadosCuentaEstudiante() {
        return estadoCuentaEstudianteService.listar();
    }

    @GetMapping("/estados-cuenta-estudiante/{id}")
    @Operation(summary = "Obtener un estado de cuenta del estudiante")
    public EstadoCuentaEstudianteResponse obtenerEstadoCuentaEstudiante(@PathVariable Long id) {
        return estadoCuentaEstudianteService.obtener(id);
    }

    @PostMapping("/estados-cuenta-estudiante")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear un estado de cuenta del estudiante")
    public EstadoCuentaEstudianteResponse crearEstadoCuentaEstudiante(@Valid @RequestBody EstadoCuentaEstudianteRequest request) {
        return estadoCuentaEstudianteService.crear(request);
    }

    // --- Constancia de no adeudo ---

    @GetMapping("/constancias-no-adeudo")
    @Operation(summary = "Listar constancias de no adeudo")
    public List<ConstanciaNoAdeudoResponse> listarConstanciasNoAdeudo() {
        return constanciaNoAdeudoService.listar();
    }

    @GetMapping("/constancias-no-adeudo/{id}")
    @Operation(summary = "Obtener una constancia de no adeudo")
    public ConstanciaNoAdeudoResponse obtenerConstanciaNoAdeudo(@PathVariable Long id) {
        return constanciaNoAdeudoService.obtener(id);
    }

    @PostMapping("/constancias-no-adeudo")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear una constancia de no adeudo")
    public ConstanciaNoAdeudoResponse crearConstanciaNoAdeudo(@Valid @RequestBody ConstanciaNoAdeudoRequest request) {
        return constanciaNoAdeudoService.crear(request);
    }
}
