package pe.edu.upeu.lamb.matricula.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.lamb.matricula.dto.BloqueoMatriculaRequest;
import pe.edu.upeu.lamb.matricula.dto.BloqueoMatriculaResponse;
import pe.edu.upeu.lamb.matricula.dto.CompromisoMatriculaRequest;
import pe.edu.upeu.lamb.matricula.dto.CompromisoMatriculaResponse;
import pe.edu.upeu.lamb.matricula.dto.RequisitoPorTipoMatriculaRequest;
import pe.edu.upeu.lamb.matricula.dto.RequisitoPorTipoMatriculaResponse;
import pe.edu.upeu.lamb.matricula.service.BloqueoMatriculaService;
import pe.edu.upeu.lamb.matricula.service.CompromisoMatriculaService;
import pe.edu.upeu.lamb.matricula.service.RequisitoPorTipoMatriculaService;

import java.util.List;

/**
 * Dominio "Reglas y requisitos" (CRUD unificado). Subrecursos: requisitos por
 * tipo de matricula, bloqueos de matricula, compromisos/contrato.
 */
@RestController
@RequestMapping("/api/v1/reglas-requisitos")
@RequiredArgsConstructor
@Tag(name = "reglas-y-requisitos-controller")
public class ReglasRequisitosController {

    private final RequisitoPorTipoMatriculaService requisitoPorTipoMatriculaService;
    private final BloqueoMatriculaService bloqueoMatriculaService;
    private final CompromisoMatriculaService compromisoMatriculaService;

    // --- Requisito por tipo de matricula (item 12) ---

    @GetMapping("/requisitos-por-tipo")
    @Operation(summary = "Listar requisitos por tipo de matricula")
    public List<RequisitoPorTipoMatriculaResponse> listarRequisitos() {
        return requisitoPorTipoMatriculaService.listar();
    }

    @GetMapping("/requisitos-por-tipo/{id}")
    @Operation(summary = "Obtener un requisito por tipo de matricula")
    public RequisitoPorTipoMatriculaResponse obtenerRequisito(@PathVariable Long id) {
        return requisitoPorTipoMatriculaService.obtener(id);
    }

    @PostMapping("/requisitos-por-tipo")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear un requisito por tipo de matricula")
    public RequisitoPorTipoMatriculaResponse crearRequisito(@Valid @RequestBody RequisitoPorTipoMatriculaRequest request) {
        return requisitoPorTipoMatriculaService.crear(request);
    }

    // --- Bloqueo de matricula (item 13) ---

    @GetMapping("/bloqueos")
    @Operation(summary = "Listar bloqueos de matricula")
    public List<BloqueoMatriculaResponse> listarBloqueos() {
        return bloqueoMatriculaService.listar();
    }

    @GetMapping("/bloqueos/{id}")
    @Operation(summary = "Obtener un bloqueo de matricula")
    public BloqueoMatriculaResponse obtenerBloqueo(@PathVariable Long id) {
        return bloqueoMatriculaService.obtener(id);
    }

    @PostMapping("/bloqueos")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear un bloqueo de matricula")
    public BloqueoMatriculaResponse crearBloqueo(@Valid @RequestBody BloqueoMatriculaRequest request) {
        return bloqueoMatriculaService.crear(request);
    }

    @PostMapping("/bloqueos/{id}/levantar")
    @Operation(summary = "Levantar un bloqueo de matricula")
    public BloqueoMatriculaResponse levantarBloqueo(@PathVariable Long id) {
        return bloqueoMatriculaService.levantar(id);
    }

    // --- Compromiso / contrato (item 16) ---

    @GetMapping("/compromisos")
    @Operation(summary = "Listar compromisos de matricula")
    public List<CompromisoMatriculaResponse> listarCompromisos() {
        return compromisoMatriculaService.listar();
    }

    @GetMapping("/compromisos/{id}")
    @Operation(summary = "Obtener un compromiso de matricula")
    public CompromisoMatriculaResponse obtenerCompromiso(@PathVariable Long id) {
        return compromisoMatriculaService.obtener(id);
    }

    @PostMapping("/compromisos")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear un compromiso de matricula")
    public CompromisoMatriculaResponse crearCompromiso(@Valid @RequestBody CompromisoMatriculaRequest request) {
        return compromisoMatriculaService.crear(request);
    }
}
