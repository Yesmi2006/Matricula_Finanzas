package pe.edu.upeu.lamb.matricula.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.lamb.matricula.dto.CargaAcademicaPeriodoRequest;
import pe.edu.upeu.lamb.matricula.dto.CargaAcademicaPeriodoResponse;
import pe.edu.upeu.lamb.matricula.dto.CargaMinimaAutorizadaRequest;
import pe.edu.upeu.lamb.matricula.dto.CargaMinimaAutorizadaResponse;
import pe.edu.upeu.lamb.matricula.dto.CruceHorarioAutorizadoRequest;
import pe.edu.upeu.lamb.matricula.dto.CruceHorarioAutorizadoResponse;
import pe.edu.upeu.lamb.matricula.dto.EleccionCursoElectivoRequest;
import pe.edu.upeu.lamb.matricula.dto.EleccionCursoElectivoResponse;
import pe.edu.upeu.lamb.matricula.dto.IntentoCursoRequest;
import pe.edu.upeu.lamb.matricula.dto.IntentoCursoResponse;
import pe.edu.upeu.lamb.matricula.dto.LiberacionExcepcionalPrerrequisitoRequest;
import pe.edu.upeu.lamb.matricula.dto.LiberacionExcepcionalPrerrequisitoResponse;
import pe.edu.upeu.lamb.matricula.dto.SobrecargaCreditosAutorizadaRequest;
import pe.edu.upeu.lamb.matricula.dto.SobrecargaCreditosAutorizadaResponse;
import pe.edu.upeu.lamb.matricula.service.CargaAcademicaPeriodoService;
import pe.edu.upeu.lamb.matricula.service.CargaMinimaAutorizadaService;
import pe.edu.upeu.lamb.matricula.service.CruceHorarioAutorizadoService;
import pe.edu.upeu.lamb.matricula.service.EleccionCursoElectivoService;
import pe.edu.upeu.lamb.matricula.service.IntentoCursoService;
import pe.edu.upeu.lamb.matricula.service.LiberacionExcepcionalPrerrequisitoService;
import pe.edu.upeu.lamb.matricula.service.SobrecargaCreditosAutorizadaService;

import java.util.List;

/**
 * Dominio "Cursos y carga academica" (CRUD unificado). Subrecursos: intento
 * de curso, carga academica por periodo, eleccion de curso electivo, cruce de
 * horario autorizado, liberacion excepcional de prerrequisito, sobrecarga de
 * creditos autorizada, carga minima autorizada.
 */
@RestController
@RequestMapping("/api/v1/cursos-carga-academica")
@RequiredArgsConstructor
@Tag(name = "cursos-y-carga-academica-controller")
public class CursosCargaAcademicaController {

    private final IntentoCursoService intentoCursoService;
    private final CargaAcademicaPeriodoService cargaAcademicaPeriodoService;
    private final EleccionCursoElectivoService eleccionCursoElectivoService;
    private final CruceHorarioAutorizadoService cruceHorarioAutorizadoService;
    private final LiberacionExcepcionalPrerrequisitoService liberacionExcepcionalPrerrequisitoService;
    private final SobrecargaCreditosAutorizadaService sobrecargaCreditosAutorizadaService;
    private final CargaMinimaAutorizadaService cargaMinimaAutorizadaService;

    // --- Intento de curso (item 59) ---

    @GetMapping("/intentos-curso")
    @Operation(summary = "Listar intentos de curso")
    public List<IntentoCursoResponse> listarIntentosCurso() {
        return intentoCursoService.listar();
    }

    @GetMapping("/intentos-curso/{id}")
    @Operation(summary = "Obtener un intento de curso")
    public IntentoCursoResponse obtenerIntentoCurso(@PathVariable Long id) {
        return intentoCursoService.obtener(id);
    }

    @PostMapping("/intentos-curso")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear un intento de curso")
    public IntentoCursoResponse crearIntentoCurso(@RequestBody IntentoCursoRequest request) {
        return intentoCursoService.crear(request);
    }

    // --- Carga academica por periodo (item 60) ---

    @GetMapping("/cargas-periodo")
    @Operation(summary = "Listar cargas academicas por periodo")
    public List<CargaAcademicaPeriodoResponse> listarCargasPeriodo() {
        return cargaAcademicaPeriodoService.listar();
    }

    @GetMapping("/cargas-periodo/{id}")
    @Operation(summary = "Obtener una carga academica por periodo")
    public CargaAcademicaPeriodoResponse obtenerCargaPeriodo(@PathVariable Long id) {
        return cargaAcademicaPeriodoService.obtener(id);
    }

    @PostMapping("/cargas-periodo")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear una carga academica por periodo")
    public CargaAcademicaPeriodoResponse crearCargaPeriodo(@RequestBody CargaAcademicaPeriodoRequest request) {
        return cargaAcademicaPeriodoService.crear(request);
    }

    // --- Eleccion de curso electivo (item 61) ---

    @GetMapping("/elecciones-electivos")
    @Operation(summary = "Listar elecciones de curso electivo")
    public List<EleccionCursoElectivoResponse> listarEleccionesElectivos() {
        return eleccionCursoElectivoService.listar();
    }

    @GetMapping("/elecciones-electivos/{id}")
    @Operation(summary = "Obtener una eleccion de curso electivo")
    public EleccionCursoElectivoResponse obtenerEleccionElectivo(@PathVariable Long id) {
        return eleccionCursoElectivoService.obtener(id);
    }

    @PostMapping("/elecciones-electivos")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear una eleccion de curso electivo")
    public EleccionCursoElectivoResponse crearEleccionElectivo(@RequestBody EleccionCursoElectivoRequest request) {
        return eleccionCursoElectivoService.crear(request);
    }

    // --- Cruce de horario autorizado (item 62) ---

    @GetMapping("/cruces-horario")
    @Operation(summary = "Listar cruces de horario autorizados")
    public List<CruceHorarioAutorizadoResponse> listarCrucesHorario() {
        return cruceHorarioAutorizadoService.listar();
    }

    @GetMapping("/cruces-horario/{id}")
    @Operation(summary = "Obtener un cruce de horario autorizado")
    public CruceHorarioAutorizadoResponse obtenerCruceHorario(@PathVariable Long id) {
        return cruceHorarioAutorizadoService.obtener(id);
    }

    @PostMapping("/cruces-horario")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear un cruce de horario autorizado")
    public CruceHorarioAutorizadoResponse crearCruceHorario(@RequestBody CruceHorarioAutorizadoRequest request) {
        return cruceHorarioAutorizadoService.crear(request);
    }

    // --- Liberacion excepcional de prerrequisito (item 63) ---

    @GetMapping("/liberaciones-prerrequisito")
    @Operation(summary = "Listar liberaciones excepcionales de prerrequisito")
    public List<LiberacionExcepcionalPrerrequisitoResponse> listarLiberacionesPrerrequisito() {
        return liberacionExcepcionalPrerrequisitoService.listar();
    }

    @GetMapping("/liberaciones-prerrequisito/{id}")
    @Operation(summary = "Obtener una liberacion excepcional de prerrequisito")
    public LiberacionExcepcionalPrerrequisitoResponse obtenerLiberacionPrerrequisito(@PathVariable Long id) {
        return liberacionExcepcionalPrerrequisitoService.obtener(id);
    }

    @PostMapping("/liberaciones-prerrequisito")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear una liberacion excepcional de prerrequisito")
    public LiberacionExcepcionalPrerrequisitoResponse crearLiberacionPrerrequisito(@RequestBody LiberacionExcepcionalPrerrequisitoRequest request) {
        return liberacionExcepcionalPrerrequisitoService.crear(request);
    }

    // --- Sobrecarga de creditos autorizada (item 64) ---

    @GetMapping("/sobrecargas-creditos")
    @Operation(summary = "Listar sobrecargas de creditos autorizadas")
    public List<SobrecargaCreditosAutorizadaResponse> listarSobrecargasCreditos() {
        return sobrecargaCreditosAutorizadaService.listar();
    }

    @GetMapping("/sobrecargas-creditos/{id}")
    @Operation(summary = "Obtener una sobrecarga de creditos autorizada")
    public SobrecargaCreditosAutorizadaResponse obtenerSobrecargaCreditos(@PathVariable Long id) {
        return sobrecargaCreditosAutorizadaService.obtener(id);
    }

    @PostMapping("/sobrecargas-creditos")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear una sobrecarga de creditos autorizada")
    public SobrecargaCreditosAutorizadaResponse crearSobrecargaCreditos(@RequestBody SobrecargaCreditosAutorizadaRequest request) {
        return sobrecargaCreditosAutorizadaService.crear(request);
    }

    // --- Carga minima autorizada (item 65) ---

    @GetMapping("/cargas-minimas")
    @Operation(summary = "Listar cargas minimas autorizadas")
    public List<CargaMinimaAutorizadaResponse> listarCargasMinimas() {
        return cargaMinimaAutorizadaService.listar();
    }

    @GetMapping("/cargas-minimas/{id}")
    @Operation(summary = "Obtener una carga minima autorizada")
    public CargaMinimaAutorizadaResponse obtenerCargaMinima(@PathVariable Long id) {
        return cargaMinimaAutorizadaService.obtener(id);
    }

    @PostMapping("/cargas-minimas")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear una carga minima autorizada")
    public CargaMinimaAutorizadaResponse crearCargaMinima(@RequestBody CargaMinimaAutorizadaRequest request) {
        return cargaMinimaAutorizadaService.crear(request);
    }
}
