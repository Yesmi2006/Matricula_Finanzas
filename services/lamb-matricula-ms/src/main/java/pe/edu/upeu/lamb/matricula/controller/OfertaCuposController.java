package pe.edu.upeu.lamb.matricula.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.lamb.matricula.dto.AmpliacionCupoRequest;
import pe.edu.upeu.lamb.matricula.dto.AmpliacionCupoResponse;
import pe.edu.upeu.lamb.matricula.dto.ListaEsperaSeccionRequest;
import pe.edu.upeu.lamb.matricula.dto.ListaEsperaSeccionResponse;
import pe.edu.upeu.lamb.matricula.dto.ReservaVacanteRequest;
import pe.edu.upeu.lamb.matricula.dto.ReservaVacanteResponse;
import pe.edu.upeu.lamb.matricula.service.AmpliacionCupoService;
import pe.edu.upeu.lamb.matricula.service.ListaEsperaSeccionService;
import pe.edu.upeu.lamb.matricula.service.ReservaVacanteService;

import java.util.List;

/**
 * Dominio "Oferta y cupos" (CRUD unificado). Subrecursos: reserva de vacante,
 * lista de espera de seccion, ampliacion autorizada de cupo.
 */
@RestController
@RequestMapping("/api/v1/oferta-cupos")
@RequiredArgsConstructor
@Tag(name = "oferta-y-cupos-controller")
public class OfertaCuposController {

    private final ReservaVacanteService reservaVacanteService;
    private final ListaEsperaSeccionService listaEsperaSeccionService;
    private final AmpliacionCupoService ampliacionCupoService;

    // --- Reserva de vacante (item 20) ---

    @GetMapping("/reservas-vacante")
    @Operation(summary = "Listar reservas de vacante")
    public List<ReservaVacanteResponse> listarReservasVacante() {
        return reservaVacanteService.listar();
    }

    @GetMapping("/reservas-vacante/{id}")
    @Operation(summary = "Obtener una reserva de vacante")
    public ReservaVacanteResponse obtenerReservaVacante(@PathVariable Long id) {
        return reservaVacanteService.obtener(id);
    }

    @PostMapping("/reservas-vacante")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear una reserva de vacante")
    public ReservaVacanteResponse crearReservaVacante(@Valid @RequestBody ReservaVacanteRequest request) {
        return reservaVacanteService.crear(request);
    }

    // --- Lista de espera de seccion (item 21) ---

    @GetMapping("/listas-espera")
    @Operation(summary = "Listar listas de espera de seccion")
    public List<ListaEsperaSeccionResponse> listarListasEspera() {
        return listaEsperaSeccionService.listar();
    }

    @GetMapping("/listas-espera/{id}")
    @Operation(summary = "Obtener una lista de espera de seccion")
    public ListaEsperaSeccionResponse obtenerListaEspera(@PathVariable Long id) {
        return listaEsperaSeccionService.obtener(id);
    }

    @PostMapping("/listas-espera")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear una lista de espera de seccion")
    public ListaEsperaSeccionResponse crearListaEspera(@Valid @RequestBody ListaEsperaSeccionRequest request) {
        return listaEsperaSeccionService.crear(request);
    }

    // --- Ampliacion autorizada de cupo (item 22) ---

    @GetMapping("/ampliaciones-cupo")
    @Operation(summary = "Listar ampliaciones autorizadas de cupo")
    public List<AmpliacionCupoResponse> listarAmpliacionesCupo() {
        return ampliacionCupoService.listar();
    }

    @GetMapping("/ampliaciones-cupo/{id}")
    @Operation(summary = "Obtener una ampliacion autorizada de cupo")
    public AmpliacionCupoResponse obtenerAmpliacionCupo(@PathVariable Long id) {
        return ampliacionCupoService.obtener(id);
    }

    @PostMapping("/ampliaciones-cupo")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear una ampliacion autorizada de cupo")
    public AmpliacionCupoResponse crearAmpliacionCupo(@Valid @RequestBody AmpliacionCupoRequest request) {
        return ampliacionCupoService.crear(request);
    }
}
