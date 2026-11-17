package pe.edu.upeu.lamb.matricula.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.lamb.matricula.dto.AnulacionMatriculaRequest;
import pe.edu.upeu.lamb.matricula.dto.AnulacionMatriculaResponse;
import pe.edu.upeu.lamb.matricula.dto.ConstanciaMatriculaRequest;
import pe.edu.upeu.lamb.matricula.dto.ConstanciaMatriculaResponse;
import pe.edu.upeu.lamb.matricula.dto.HistorialEstadoMatriculaRequest;
import pe.edu.upeu.lamb.matricula.dto.HistorialEstadoMatriculaResponse;
import pe.edu.upeu.lamb.matricula.dto.MatriculaRequest;
import pe.edu.upeu.lamb.matricula.dto.MatriculaResponse;
import pe.edu.upeu.lamb.matricula.entity.EstadoMatricula;
import pe.edu.upeu.lamb.matricula.service.AnulacionMatriculaService;
import pe.edu.upeu.lamb.matricula.service.ConstanciaMatriculaService;
import pe.edu.upeu.lamb.matricula.service.HistorialEstadoMatriculaService;
import pe.edu.upeu.lamb.matricula.service.MatriculaService;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Dominio "Matricula" (CRUD unificado). Base /api/v1/matriculas: ruta de saga
 * ya probada (confirmar/anular/condiciones), no se modifica. Subrecursos:
 * estados (catalogo), historial de estados, anulaciones, constancias.
 */
@RestController
@RequestMapping("/api/v1/matriculas")
@RequiredArgsConstructor
@Tag(name = "matricula-controller")
public class MatriculaController {

    private final MatriculaService matriculaService;
    private final HistorialEstadoMatriculaService historialEstadoMatriculaService;
    private final AnulacionMatriculaService anulacionMatriculaService;
    private final ConstanciaMatriculaService constanciaMatriculaService;

    // --- Matricula (item 23) — rutas de saga, no modificar ---

    @GetMapping
    @Operation(summary = "Listar matriculas (ESTUDIANTE solo ve las suyas)")
    public List<MatriculaResponse> listar(@AuthenticationPrincipal Jwt jwt) {
        return matriculaService.listar(idPersonaDe(jwt), esPrivilegiado(jwt));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una matricula (ESTUDIANTE solo si es suya)")
    public MatriculaResponse obtener(@PathVariable Long id, @AuthenticationPrincipal Jwt jwt) {
        return matriculaService.obtener(id, idPersonaDe(jwt), esPrivilegiado(jwt));
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

    // idPersona viaja en el token via protocol mapper (lamb-realm.json); ADMIN/COORDINADOR
    // ven todo, ESTUDIANTE solo lo suyo (aislamiento por fila, el Gateway solo filtra por rol).
    private static Long idPersonaDe(Jwt jwt) {
        return jwt.getClaim("idPersona");
    }

    private static boolean esPrivilegiado(Jwt jwt) {
        Map<String, Object> realmAccess = jwt.getClaimAsMap("realm_access");
        Object roles = realmAccess == null ? null : realmAccess.get("roles");
        if (!(roles instanceof Collection<?> lista)) {
            return false;
        }
        return lista.contains("ADMIN") || lista.contains("COORDINADOR");
    }
}
