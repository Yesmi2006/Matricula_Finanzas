package pe.edu.upeu.lamb.matricula.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.lamb.matricula.dto.CambioSituacionAcademicaRequest;
import pe.edu.upeu.lamb.matricula.dto.CambioSituacionAcademicaResponse;
import pe.edu.upeu.lamb.matricula.dto.CondicionMatriculaRequest;
import pe.edu.upeu.lamb.matricula.dto.CondicionMatriculaResponse;
import pe.edu.upeu.lamb.matricula.dto.EstudianteObservadoSuspendidoRequest;
import pe.edu.upeu.lamb.matricula.dto.EstudianteObservadoSuspendidoResponse;
import pe.edu.upeu.lamb.matricula.dto.MovilidadEstudiantilRequest;
import pe.edu.upeu.lamb.matricula.dto.MovilidadEstudiantilResponse;
import pe.edu.upeu.lamb.matricula.dto.SituacionAcademicaEstudianteRequest;
import pe.edu.upeu.lamb.matricula.dto.SituacionAcademicaEstudianteResponse;
import pe.edu.upeu.lamb.matricula.service.CambioSituacionAcademicaService;
import pe.edu.upeu.lamb.matricula.service.CondicionMatriculaService;
import pe.edu.upeu.lamb.matricula.service.EstudianteObservadoSuspendidoService;
import pe.edu.upeu.lamb.matricula.service.MovilidadEstudiantilService;
import pe.edu.upeu.lamb.matricula.service.SituacionAcademicaEstudianteService;

import java.util.List;

/**
 * Dominio "Situacion del estudiante" (CRUD unificado). Subrecursos: condicion
 * de matricula, situacion academica, cambios de situacion academica,
 * estudiantes observados/suspendidos, movilidad estudiantil.
 */
@RestController
@RequestMapping("/api/v1/situacion-estudiante")
@RequiredArgsConstructor
@Tag(name = "situacion-del-estudiante-controller")
public class SituacionEstudianteController {

    private final CondicionMatriculaService condicionMatriculaService;
    private final SituacionAcademicaEstudianteService situacionAcademicaEstudianteService;
    private final CambioSituacionAcademicaService cambioSituacionAcademicaService;
    private final EstudianteObservadoSuspendidoService estudianteObservadoSuspendidoService;
    private final MovilidadEstudiantilService movilidadEstudiantilService;

    // --- Condicion de matricula (item 54) ---

    @GetMapping("/condiciones")
    @Operation(summary = "Listar condiciones de matricula")
    public List<CondicionMatriculaResponse> listarCondiciones() {
        return condicionMatriculaService.listar();
    }

    @GetMapping("/condiciones/{id}")
    @Operation(summary = "Obtener una condicion de matricula")
    public CondicionMatriculaResponse obtenerCondicion(@PathVariable Long id) {
        return condicionMatriculaService.obtener(id);
    }

    @PostMapping("/condiciones")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear una condicion de matricula")
    public CondicionMatriculaResponse crearCondicion(@Valid @RequestBody CondicionMatriculaRequest request) {
        return condicionMatriculaService.crear(request);
    }

    // --- Situacion academica del estudiante (item 55) ---

    @GetMapping("/situaciones-academicas")
    @Operation(summary = "Listar situaciones academicas de estudiante")
    public List<SituacionAcademicaEstudianteResponse> listarSituacionesAcademicas() {
        return situacionAcademicaEstudianteService.listar();
    }

    @GetMapping("/situaciones-academicas/{id}")
    @Operation(summary = "Obtener una situacion academica de estudiante")
    public SituacionAcademicaEstudianteResponse obtenerSituacionAcademica(@PathVariable Long id) {
        return situacionAcademicaEstudianteService.obtener(id);
    }

    @PostMapping("/situaciones-academicas")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear una situacion academica de estudiante")
    public SituacionAcademicaEstudianteResponse crearSituacionAcademica(@Valid @RequestBody SituacionAcademicaEstudianteRequest request) {
        return situacionAcademicaEstudianteService.crear(request);
    }

    // --- Cambio de situacion academica (item 56) ---

    @GetMapping("/cambios-situacion")
    @Operation(summary = "Listar cambios de situacion academica")
    public List<CambioSituacionAcademicaResponse> listarCambiosSituacion() {
        return cambioSituacionAcademicaService.listar();
    }

    @GetMapping("/cambios-situacion/{id}")
    @Operation(summary = "Obtener un cambio de situacion academica")
    public CambioSituacionAcademicaResponse obtenerCambioSituacion(@PathVariable Long id) {
        return cambioSituacionAcademicaService.obtener(id);
    }

    @PostMapping("/cambios-situacion")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear un cambio de situacion academica")
    public CambioSituacionAcademicaResponse crearCambioSituacion(@Valid @RequestBody CambioSituacionAcademicaRequest request) {
        return cambioSituacionAcademicaService.crear(request);
    }

    // --- Estudiante observado/suspendido (item 57) ---

    @GetMapping("/observados-suspendidos")
    @Operation(summary = "Listar estudiantes observados/suspendidos")
    public List<EstudianteObservadoSuspendidoResponse> listarObservadosSuspendidos() {
        return estudianteObservadoSuspendidoService.listar();
    }

    @GetMapping("/observados-suspendidos/{id}")
    @Operation(summary = "Obtener un estudiante observado/suspendido")
    public EstudianteObservadoSuspendidoResponse obtenerObservadoSuspendido(@PathVariable Long id) {
        return estudianteObservadoSuspendidoService.obtener(id);
    }

    @PostMapping("/observados-suspendidos")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear un registro de estudiante observado/suspendido")
    public EstudianteObservadoSuspendidoResponse crearObservadoSuspendido(@Valid @RequestBody EstudianteObservadoSuspendidoRequest request) {
        return estudianteObservadoSuspendidoService.crear(request);
    }

    // --- Movilidad estudiantil (item 58) ---

    @GetMapping("/movilidades")
    @Operation(summary = "Listar movilidades estudiantiles")
    public List<MovilidadEstudiantilResponse> listarMovilidades() {
        return movilidadEstudiantilService.listar();
    }

    @GetMapping("/movilidades/{id}")
    @Operation(summary = "Obtener una movilidad estudiantil")
    public MovilidadEstudiantilResponse obtenerMovilidad(@PathVariable Long id) {
        return movilidadEstudiantilService.obtener(id);
    }

    @PostMapping("/movilidades")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear una movilidad estudiantil")
    public MovilidadEstudiantilResponse crearMovilidad(@Valid @RequestBody MovilidadEstudiantilRequest request) {
        return movilidadEstudiantilService.crear(request);
    }
}
