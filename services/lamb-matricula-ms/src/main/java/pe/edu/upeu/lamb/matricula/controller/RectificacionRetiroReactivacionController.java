package pe.edu.upeu.lamb.matricula.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.lamb.matricula.dto.AnulacionMasivaImpagoRequest;
import pe.edu.upeu.lamb.matricula.dto.AnulacionMasivaImpagoResponse;
import pe.edu.upeu.lamb.matricula.dto.ReactivacionMatriculaAnuladaRequest;
import pe.edu.upeu.lamb.matricula.dto.ReactivacionMatriculaAnuladaResponse;
import pe.edu.upeu.lamb.matricula.dto.RehabilitacionMatriculaRequest;
import pe.edu.upeu.lamb.matricula.dto.RehabilitacionMatriculaResponse;
import pe.edu.upeu.lamb.matricula.dto.RetiroInasistenciaRequest;
import pe.edu.upeu.lamb.matricula.dto.RetiroInasistenciaResponse;
import pe.edu.upeu.lamb.matricula.dto.RetiroOficioRequest;
import pe.edu.upeu.lamb.matricula.dto.RetiroOficioResponse;
import pe.edu.upeu.lamb.matricula.dto.SolicitudRectificacionRequest;
import pe.edu.upeu.lamb.matricula.dto.SolicitudRectificacionResponse;
import pe.edu.upeu.lamb.matricula.service.AnulacionMasivaImpagoService;
import pe.edu.upeu.lamb.matricula.service.ReactivacionMatriculaAnuladaService;
import pe.edu.upeu.lamb.matricula.service.RehabilitacionMatriculaService;
import pe.edu.upeu.lamb.matricula.service.RetiroInasistenciaService;
import pe.edu.upeu.lamb.matricula.service.RetiroOficioService;
import pe.edu.upeu.lamb.matricula.service.SolicitudRectificacionService;

import java.util.List;

/**
 * Dominio "Rectificacion, retiro y reactivacion" (CRUD unificado). Subrecursos:
 * solicitud de rectificacion, retiro de oficio, retiro por inasistencia,
 * reactivacion de matricula anulada, anulacion masiva por impago,
 * rehabilitacion de matricula.
 */
@RestController
@RequestMapping("/api/v1/rectificacion-retiro-reactivacion")
@RequiredArgsConstructor
@Tag(name = "rectificacion-retiro-y-reactivacion-controller")
public class RectificacionRetiroReactivacionController {

    private final SolicitudRectificacionService solicitudRectificacionService;
    private final RetiroOficioService retiroOficioService;
    private final RetiroInasistenciaService retiroInasistenciaService;
    private final ReactivacionMatriculaAnuladaService reactivacionMatriculaAnuladaService;
    private final AnulacionMasivaImpagoService anulacionMasivaImpagoService;
    private final RehabilitacionMatriculaService rehabilitacionMatriculaService;

    // --- Solicitud de rectificacion (item 73) ---

    @GetMapping("/solicitudes-rectificacion")
    @Operation(summary = "Listar solicitudes de rectificacion")
    public List<SolicitudRectificacionResponse> listarSolicitudesRectificacion() {
        return solicitudRectificacionService.listar();
    }

    @GetMapping("/solicitudes-rectificacion/{id}")
    @Operation(summary = "Obtener una solicitud de rectificacion")
    public SolicitudRectificacionResponse obtenerSolicitudRectificacion(@PathVariable Long id) {
        return solicitudRectificacionService.obtener(id);
    }

    @PostMapping("/solicitudes-rectificacion")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear una solicitud de rectificacion")
    public SolicitudRectificacionResponse crearSolicitudRectificacion(@Valid @RequestBody SolicitudRectificacionRequest request) {
        return solicitudRectificacionService.crear(request);
    }

    // --- Retiro de oficio (item 74) ---

    @GetMapping("/retiros-oficio")
    @Operation(summary = "Listar retiros de oficio")
    public List<RetiroOficioResponse> listarRetirosOficio() {
        return retiroOficioService.listar();
    }

    @GetMapping("/retiros-oficio/{id}")
    @Operation(summary = "Obtener un retiro de oficio")
    public RetiroOficioResponse obtenerRetiroOficio(@PathVariable Long id) {
        return retiroOficioService.obtener(id);
    }

    @PostMapping("/retiros-oficio")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear un retiro de oficio")
    public RetiroOficioResponse crearRetiroOficio(@Valid @RequestBody RetiroOficioRequest request) {
        return retiroOficioService.crear(request);
    }

    // --- Retiro por inasistencia (item 75, opcional segun universidad) ---

    @GetMapping("/retiros-inasistencia")
    @Operation(summary = "Listar retiros por inasistencia")
    public List<RetiroInasistenciaResponse> listarRetirosInasistencia() {
        return retiroInasistenciaService.listar();
    }

    @GetMapping("/retiros-inasistencia/{id}")
    @Operation(summary = "Obtener un retiro por inasistencia")
    public RetiroInasistenciaResponse obtenerRetiroInasistencia(@PathVariable Long id) {
        return retiroInasistenciaService.obtener(id);
    }

    @PostMapping("/retiros-inasistencia")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear un retiro por inasistencia")
    public RetiroInasistenciaResponse crearRetiroInasistencia(@Valid @RequestBody RetiroInasistenciaRequest request) {
        return retiroInasistenciaService.crear(request);
    }

    // --- Reactivacion de matricula anulada (item 76) ---

    @GetMapping("/reactivaciones-matricula-anulada")
    @Operation(summary = "Listar reactivaciones de matricula anulada")
    public List<ReactivacionMatriculaAnuladaResponse> listarReactivaciones() {
        return reactivacionMatriculaAnuladaService.listar();
    }

    @GetMapping("/reactivaciones-matricula-anulada/{id}")
    @Operation(summary = "Obtener una reactivacion de matricula anulada")
    public ReactivacionMatriculaAnuladaResponse obtenerReactivacion(@PathVariable Long id) {
        return reactivacionMatriculaAnuladaService.obtener(id);
    }

    @PostMapping("/reactivaciones-matricula-anulada")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear una reactivacion de matricula anulada")
    public ReactivacionMatriculaAnuladaResponse crearReactivacion(@Valid @RequestBody ReactivacionMatriculaAnuladaRequest request) {
        return reactivacionMatriculaAnuladaService.crear(request);
    }

    // --- Anulacion masiva por impago (item 77) ---

    @GetMapping("/anulaciones-masivas-impago")
    @Operation(summary = "Listar anulaciones masivas por impago")
    public List<AnulacionMasivaImpagoResponse> listarAnulacionesMasivas() {
        return anulacionMasivaImpagoService.listar();
    }

    @GetMapping("/anulaciones-masivas-impago/{id}")
    @Operation(summary = "Obtener una anulacion masiva por impago")
    public AnulacionMasivaImpagoResponse obtenerAnulacionMasiva(@PathVariable Long id) {
        return anulacionMasivaImpagoService.obtener(id);
    }

    @PostMapping("/anulaciones-masivas-impago")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear una anulacion masiva por impago")
    public AnulacionMasivaImpagoResponse crearAnulacionMasiva(@Valid @RequestBody AnulacionMasivaImpagoRequest request) {
        return anulacionMasivaImpagoService.crear(request);
    }

    // --- Rehabilitacion de matricula (item 78, opcional segun universidad) ---

    @GetMapping("/rehabilitaciones-matricula")
    @Operation(summary = "Listar rehabilitaciones de matricula")
    public List<RehabilitacionMatriculaResponse> listarRehabilitaciones() {
        return rehabilitacionMatriculaService.listar();
    }

    @GetMapping("/rehabilitaciones-matricula/{id}")
    @Operation(summary = "Obtener una rehabilitacion de matricula")
    public RehabilitacionMatriculaResponse obtenerRehabilitacion(@PathVariable Long id) {
        return rehabilitacionMatriculaService.obtener(id);
    }

    @PostMapping("/rehabilitaciones-matricula")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear una rehabilitacion de matricula")
    public RehabilitacionMatriculaResponse crearRehabilitacion(@Valid @RequestBody RehabilitacionMatriculaRequest request) {
        return rehabilitacionMatriculaService.crear(request);
    }
}
