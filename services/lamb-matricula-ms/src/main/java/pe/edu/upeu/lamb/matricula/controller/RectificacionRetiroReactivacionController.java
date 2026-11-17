package pe.edu.upeu.lamb.matricula.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.lamb.matricula.dto.ReactivacionMatriculaAnuladaRequest;
import pe.edu.upeu.lamb.matricula.dto.ReactivacionMatriculaAnuladaResponse;
import pe.edu.upeu.lamb.matricula.dto.RetiroInasistenciaRequest;
import pe.edu.upeu.lamb.matricula.dto.RetiroInasistenciaResponse;
import pe.edu.upeu.lamb.matricula.dto.RetiroOficioRequest;
import pe.edu.upeu.lamb.matricula.dto.RetiroOficioResponse;
import pe.edu.upeu.lamb.matricula.service.ReactivacionMatriculaAnuladaService;
import pe.edu.upeu.lamb.matricula.service.RetiroInasistenciaService;
import pe.edu.upeu.lamb.matricula.service.RetiroOficioService;

import java.util.List;

/**
 * Dominio "Rectificacion, retiro y reactivacion" (CRUD unificado). Subrecursos:
 * retiro de oficio, retiro por inasistencia, reactivacion de matricula
 * anulada. El job de anulacion masiva por impago sigue interno, sin endpoint
 * expuesto.
 */
@RestController
@RequestMapping("/api/v1/rectificacion-retiro-reactivacion")
@RequiredArgsConstructor
@Tag(name = "rectificacion-retiro-y-reactivacion-controller")
public class RectificacionRetiroReactivacionController {

    private final RetiroOficioService retiroOficioService;
    private final RetiroInasistenciaService retiroInasistenciaService;
    private final ReactivacionMatriculaAnuladaService reactivacionMatriculaAnuladaService;

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
}
