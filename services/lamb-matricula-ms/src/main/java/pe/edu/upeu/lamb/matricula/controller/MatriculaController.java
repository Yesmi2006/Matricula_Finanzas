package pe.edu.upeu.lamb.matricula.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.lamb.matricula.dto.AnulacionMatriculaRequest;
import pe.edu.upeu.lamb.matricula.dto.AnulacionMatriculaResponse;
import pe.edu.upeu.lamb.matricula.dto.ConstanciaMatriculaRequest;
import pe.edu.upeu.lamb.matricula.dto.ConstanciaMatriculaResponse;
import pe.edu.upeu.lamb.matricula.dto.HistorialEstadoMatriculaRequest;
import pe.edu.upeu.lamb.matricula.dto.HistorialEstadoMatriculaResponse;
import pe.edu.upeu.lamb.matricula.dto.MatriculaCondicionalRequest;
import pe.edu.upeu.lamb.matricula.dto.MatriculaCondicionalResponse;
import pe.edu.upeu.lamb.matricula.dto.MatriculaRequest;
import pe.edu.upeu.lamb.matricula.dto.MatriculaResponse;
import pe.edu.upeu.lamb.matricula.dto.NotificacionMatriculaRequest;
import pe.edu.upeu.lamb.matricula.dto.NotificacionMatriculaResponse;
import pe.edu.upeu.lamb.matricula.dto.ObservacionMatriculaRequest;
import pe.edu.upeu.lamb.matricula.dto.ObservacionMatriculaResponse;
import pe.edu.upeu.lamb.matricula.entity.EstadoMatricula;
import pe.edu.upeu.lamb.matricula.service.AnulacionMatriculaService;
import pe.edu.upeu.lamb.matricula.service.ConstanciaMatriculaService;
import pe.edu.upeu.lamb.matricula.service.HistorialEstadoMatriculaService;
import pe.edu.upeu.lamb.matricula.service.MatriculaCondicionalService;
import pe.edu.upeu.lamb.matricula.service.MatriculaService;
import pe.edu.upeu.lamb.matricula.service.NotificacionMatriculaService;
import pe.edu.upeu.lamb.matricula.service.ObservacionMatriculaService;

import java.util.Arrays;
import java.util.List;

/**
 * Dominio "Matricula" (CRUD unificado). Base /api/v1/matriculas: ruta de saga
 * ya probada (confirmar/anular/condiciones), no se modifica. Subrecursos:
 * estados (catalogo), historial de estados, matriculas condicionales,
 * anulaciones, observaciones, notificaciones, constancias.
 */
@RestController
@RequestMapping("/api/v1/matriculas")
@RequiredArgsConstructor
@Tag(name = "matricula-controller")
public class MatriculaController {

    private final MatriculaService matriculaService;
    private final HistorialEstadoMatriculaService historialEstadoMatriculaService;
    private final MatriculaCondicionalService matriculaCondicionalService;
    private final AnulacionMatriculaService anulacionMatriculaService;
    private final ObservacionMatriculaService observacionMatriculaService;
    private final NotificacionMatriculaService notificacionMatriculaService;
    private final ConstanciaMatriculaService constanciaMatriculaService;

    // --- Matricula (item 23) — rutas de saga, no modificar ---

    @GetMapping
    @Operation(summary = "Listar matriculas")
    public List<MatriculaResponse> listar() {
        return matriculaService.listar();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una matricula")
    public MatriculaResponse obtener(@PathVariable Long id) {
        return matriculaService.obtener(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear una matricula")
    public MatriculaResponse crear(@Valid @RequestBody MatriculaRequest request) {
        return matriculaService.crear(request);
    }

    @PostMapping("/{id}/confirmar")
    @Operation(summary = "Confirmar una matricula (idempotente, dispara evento matricula.confirmada)")
    public MatriculaResponse confirmar(@PathVariable Long id) {
        return matriculaService.confirmar(id);
    }

    @PostMapping("/{id}/anular")
    @Operation(summary = "Anular una matricula (idempotente)")
    public MatriculaResponse anular(@PathVariable Long id) {
        return matriculaService.anular(id);
    }

    @PostMapping("/{id}/condiciones/{idCondicion}")
    @Operation(summary = "Agregar una condicion a una matricula")
    public MatriculaResponse agregarCondicion(@PathVariable Long id, @PathVariable Long idCondicion) {
        return matriculaService.agregarCondicion(id, idCondicion);
    }

    @DeleteMapping("/{id}/condiciones/{idCondicion}")
    @Operation(summary = "Quitar una condicion de una matricula")
    public MatriculaResponse quitarCondicion(@PathVariable Long id, @PathVariable Long idCondicion) {
        return matriculaService.quitarCondicion(id, idCondicion);
    }

    // --- Estado de matricula (item 25) — catalogo de enum, sin tabla propia ---

    @GetMapping("/estados")
    @Operation(summary = "Listar valores posibles de estado de matricula")
    public List<String> listarEstados() {
        return Arrays.stream(EstadoMatricula.values()).map(Enum::name).toList();
    }

    // --- Historial de estado de matricula (item 26) ---

    @GetMapping("/historial-estados")
    @Operation(summary = "Listar historial de estados de matricula")
    public List<HistorialEstadoMatriculaResponse> listarHistorialEstados() {
        return historialEstadoMatriculaService.listar();
    }

    @GetMapping("/historial-estados/{id}")
    @Operation(summary = "Obtener un registro de historial de estados de matricula")
    public HistorialEstadoMatriculaResponse obtenerHistorialEstado(@PathVariable Long id) {
        return historialEstadoMatriculaService.obtener(id);
    }

    @PostMapping("/historial-estados")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear un registro de historial de estados de matricula")
    public HistorialEstadoMatriculaResponse crearHistorialEstado(@Valid @RequestBody HistorialEstadoMatriculaRequest request) {
        return historialEstadoMatriculaService.crear(request);
    }

    // --- Matricula condicional (item 27) ---

    @GetMapping("/condicionales")
    @Operation(summary = "Listar matriculas condicionales")
    public List<MatriculaCondicionalResponse> listarCondicionales() {
        return matriculaCondicionalService.listar();
    }

    @GetMapping("/condicionales/{id}")
    @Operation(summary = "Obtener una matricula condicional")
    public MatriculaCondicionalResponse obtenerCondicional(@PathVariable Long id) {
        return matriculaCondicionalService.obtener(id);
    }

    @PostMapping("/condicionales")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear una matricula condicional")
    public MatriculaCondicionalResponse crearCondicional(@Valid @RequestBody MatriculaCondicionalRequest request) {
        return matriculaCondicionalService.crear(request);
    }

    @PostMapping("/condicionales/{id}/levantar")
    @Operation(summary = "Levantar una matricula condicional")
    public MatriculaCondicionalResponse levantarCondicional(@PathVariable Long id) {
        return matriculaCondicionalService.levantar(id);
    }

    // --- Anulacion de matricula (item 29) ---

    @GetMapping("/anulaciones")
    @Operation(summary = "Listar anulaciones de matricula")
    public List<AnulacionMatriculaResponse> listarAnulaciones() {
        return anulacionMatriculaService.listar();
    }

    @GetMapping("/anulaciones/{id}")
    @Operation(summary = "Obtener una anulacion de matricula")
    public AnulacionMatriculaResponse obtenerAnulacion(@PathVariable Long id) {
        return anulacionMatriculaService.obtener(id);
    }

    @PostMapping("/anulaciones")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear una anulacion de matricula")
    public AnulacionMatriculaResponse crearAnulacion(@Valid @RequestBody AnulacionMatriculaRequest request) {
        return anulacionMatriculaService.crear(request);
    }

    // --- Observacion de matricula (item 30) ---

    @GetMapping("/observaciones")
    @Operation(summary = "Listar observaciones de matricula")
    public List<ObservacionMatriculaResponse> listarObservaciones() {
        return observacionMatriculaService.listar();
    }

    @GetMapping("/observaciones/{id}")
    @Operation(summary = "Obtener una observacion de matricula")
    public ObservacionMatriculaResponse obtenerObservacion(@PathVariable Long id) {
        return observacionMatriculaService.obtener(id);
    }

    @PostMapping("/observaciones")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear una observacion de matricula")
    public ObservacionMatriculaResponse crearObservacion(@Valid @RequestBody ObservacionMatriculaRequest request) {
        return observacionMatriculaService.crear(request);
    }

    // --- Notificacion de matricula (item 34) ---

    @GetMapping("/notificaciones")
    @Operation(summary = "Listar notificaciones de matricula")
    public List<NotificacionMatriculaResponse> listarNotificaciones() {
        return notificacionMatriculaService.listar();
    }

    @GetMapping("/notificaciones/{id}")
    @Operation(summary = "Obtener una notificacion de matricula")
    public NotificacionMatriculaResponse obtenerNotificacion(@PathVariable Long id) {
        return notificacionMatriculaService.obtener(id);
    }

    @PostMapping("/notificaciones")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear una notificacion de matricula")
    public NotificacionMatriculaResponse crearNotificacion(@Valid @RequestBody NotificacionMatriculaRequest request) {
        return notificacionMatriculaService.crear(request);
    }

    // --- Constancia de matricula (item 35) ---

    @GetMapping("/constancias")
    @Operation(summary = "Listar constancias de matricula")
    public List<ConstanciaMatriculaResponse> listarConstancias() {
        return constanciaMatriculaService.listar();
    }

    @GetMapping("/constancias/{id}")
    @Operation(summary = "Obtener una constancia de matricula")
    public ConstanciaMatriculaResponse obtenerConstancia(@PathVariable Long id) {
        return constanciaMatriculaService.obtener(id);
    }

    @PostMapping("/constancias")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear una constancia de matricula")
    public ConstanciaMatriculaResponse crearConstancia(@Valid @RequestBody ConstanciaMatriculaRequest request) {
        return constanciaMatriculaService.crear(request);
    }
}
