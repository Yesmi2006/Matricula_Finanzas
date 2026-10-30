package pe.edu.upeu.lamb.matricula.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.lamb.matricula.dto.AmpliacionPlazoMatriculaRequest;
import pe.edu.upeu.lamb.matricula.dto.AmpliacionPlazoMatriculaResponse;
import pe.edu.upeu.lamb.matricula.dto.CronogramaMatriculaRequest;
import pe.edu.upeu.lamb.matricula.dto.CronogramaMatriculaResponse;
import pe.edu.upeu.lamb.matricula.dto.ModalidadMatriculaRequest;
import pe.edu.upeu.lamb.matricula.dto.ModalidadMatriculaResponse;
import pe.edu.upeu.lamb.matricula.dto.TipoMatriculaRequest;
import pe.edu.upeu.lamb.matricula.dto.TipoMatriculaResponse;
import pe.edu.upeu.lamb.matricula.dto.VariacionMatriculaRequest;
import pe.edu.upeu.lamb.matricula.dto.VariacionMatriculaResponse;
import pe.edu.upeu.lamb.matricula.service.AmpliacionPlazoMatriculaService;
import pe.edu.upeu.lamb.matricula.service.CronogramaMatriculaService;
import pe.edu.upeu.lamb.matricula.service.ModalidadMatriculaService;
import pe.edu.upeu.lamb.matricula.service.TipoMatriculaService;
import pe.edu.upeu.lamb.matricula.service.VariacionMatriculaService;

import java.util.List;

/**
 * Dominio "Calendario y periodos" (CRUD unificado). Subrecursos: cronogramas,
 * variaciones, tipos y modalidades de matricula, ampliaciones de plazo.
 */
@RestController
@RequestMapping("/api/v1/calendario-periodos")
@RequiredArgsConstructor
@Tag(name = "calendario-y-periodos-controller")
public class CalendarioPeriodosController {

    private final CronogramaMatriculaService cronogramaMatriculaService;
    private final VariacionMatriculaService variacionMatriculaService;
    private final TipoMatriculaService tipoMatriculaService;
    private final ModalidadMatriculaService modalidadMatriculaService;
    private final AmpliacionPlazoMatriculaService ampliacionPlazoMatriculaService;

    // --- Cronogramas de matricula (item 3) ---

    @GetMapping("/cronogramas")
    @Operation(summary = "Listar cronogramas de matricula")
    public List<CronogramaMatriculaResponse> listarCronogramas() {
        return cronogramaMatriculaService.listar();
    }

    @GetMapping("/cronogramas/{id}")
    @Operation(summary = "Obtener un cronograma de matricula")
    public CronogramaMatriculaResponse obtenerCronograma(@PathVariable Long id) {
        return cronogramaMatriculaService.obtener(id);
    }

    @PostMapping("/cronogramas")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear un cronograma de matricula")
    public CronogramaMatriculaResponse crearCronograma(@Valid @RequestBody CronogramaMatriculaRequest request) {
        return cronogramaMatriculaService.crear(request);
    }

    // --- Variacion de matricula (item 4) ---

    @GetMapping("/variaciones")
    @Operation(summary = "Listar variaciones de matricula")
    public List<VariacionMatriculaResponse> listarVariaciones() {
        return variacionMatriculaService.listar();
    }

    @GetMapping("/variaciones/{id}")
    @Operation(summary = "Obtener una variacion de matricula")
    public VariacionMatriculaResponse obtenerVariacion(@PathVariable Long id) {
        return variacionMatriculaService.obtener(id);
    }

    @PostMapping("/variaciones")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear una variacion de matricula")
    public VariacionMatriculaResponse crearVariacion(@Valid @RequestBody VariacionMatriculaRequest request) {
        return variacionMatriculaService.crear(request);
    }

    // --- Tipo de matricula (item 5) ---

    @GetMapping("/tipos")
    @Operation(summary = "Listar tipos de matricula")
    public List<TipoMatriculaResponse> listarTipos() {
        return tipoMatriculaService.listar();
    }

    @GetMapping("/tipos/{id}")
    @Operation(summary = "Obtener un tipo de matricula")
    public TipoMatriculaResponse obtenerTipo(@PathVariable Long id) {
        return tipoMatriculaService.obtener(id);
    }

    @PostMapping("/tipos")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear un tipo de matricula")
    public TipoMatriculaResponse crearTipo(@Valid @RequestBody TipoMatriculaRequest request) {
        return tipoMatriculaService.crear(request);
    }

    // --- Modalidad de matricula (item 6) ---

    @GetMapping("/modalidades")
    @Operation(summary = "Listar modalidades de matricula")
    public List<ModalidadMatriculaResponse> listarModalidades() {
        return modalidadMatriculaService.listar();
    }

    @GetMapping("/modalidades/{id}")
    @Operation(summary = "Obtener una modalidad de matricula")
    public ModalidadMatriculaResponse obtenerModalidad(@PathVariable Long id) {
        return modalidadMatriculaService.obtener(id);
    }

    @PostMapping("/modalidades")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear una modalidad de matricula")
    public ModalidadMatriculaResponse crearModalidad(@Valid @RequestBody ModalidadMatriculaRequest request) {
        return modalidadMatriculaService.crear(request);
    }

    // --- Ampliacion de plazo de matricula (item 8) ---

    @GetMapping("/ampliaciones-plazo")
    @Operation(summary = "Listar ampliaciones de plazo de matricula")
    public List<AmpliacionPlazoMatriculaResponse> listarAmpliacionesPlazo() {
        return ampliacionPlazoMatriculaService.listar();
    }

    @GetMapping("/ampliaciones-plazo/{id}")
    @Operation(summary = "Obtener una ampliacion de plazo de matricula")
    public AmpliacionPlazoMatriculaResponse obtenerAmpliacionPlazo(@PathVariable Long id) {
        return ampliacionPlazoMatriculaService.obtener(id);
    }

    @PostMapping("/ampliaciones-plazo")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear una ampliacion de plazo de matricula")
    public AmpliacionPlazoMatriculaResponse crearAmpliacionPlazo(@Valid @RequestBody AmpliacionPlazoMatriculaRequest request) {
        return ampliacionPlazoMatriculaService.crear(request);
    }
}
