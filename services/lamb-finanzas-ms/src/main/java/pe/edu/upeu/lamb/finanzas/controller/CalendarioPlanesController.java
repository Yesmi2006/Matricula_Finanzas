package pe.edu.upeu.lamb.finanzas.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.lamb.finanzas.dto.CronogramaVencimientoRequest;
import pe.edu.upeu.lamb.finanzas.dto.CronogramaVencimientoResponse;
import pe.edu.upeu.lamb.finanzas.dto.PlantillaPlanPagoRequest;
import pe.edu.upeu.lamb.finanzas.dto.PlantillaPlanPagoResponse;
import pe.edu.upeu.lamb.finanzas.service.CronogramaVencimientoService;
import pe.edu.upeu.lamb.finanzas.service.PlantillaPlanPagoService;

import java.util.List;

/**
 * Dominio "Calendario y planes" (CRUD unificado). Subrecursos: cronograma de
 * vencimiento, plantilla de plan de pago.
 */
@RestController
@RequestMapping("/api/v1/calendario-planes")
@RequiredArgsConstructor
@Tag(name = "calendario-y-planes-controller")
public class CalendarioPlanesController {

    private final CronogramaVencimientoService cronogramaVencimientoService;
    private final PlantillaPlanPagoService plantillaPlanPagoService;

    // --- Cronograma de vencimiento ---

    @GetMapping("/cronogramas-vencimiento")
    @Operation(summary = "Listar cronogramas de vencimiento")
    public List<CronogramaVencimientoResponse> listarCronogramas() {
        return cronogramaVencimientoService.listar();
    }

    @GetMapping("/cronogramas-vencimiento/{id}")
    @Operation(summary = "Obtener un cronograma de vencimiento")
    public CronogramaVencimientoResponse obtenerCronograma(@PathVariable Long id) {
        return cronogramaVencimientoService.obtener(id);
    }

    @PostMapping("/cronogramas-vencimiento")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear un cronograma de vencimiento")
    public CronogramaVencimientoResponse crearCronograma(@Valid @RequestBody CronogramaVencimientoRequest request) {
        return cronogramaVencimientoService.crear(request);
    }

    // --- Plantilla de plan de pago ---

    @GetMapping("/plantillas-plan-pago")
    @Operation(summary = "Listar plantillas de plan de pago")
    public List<PlantillaPlanPagoResponse> listarPlantillas() {
        return plantillaPlanPagoService.listar();
    }

    @GetMapping("/plantillas-plan-pago/{id}")
    @Operation(summary = "Obtener una plantilla de plan de pago")
    public PlantillaPlanPagoResponse obtenerPlantilla(@PathVariable Long id) {
        return plantillaPlanPagoService.obtener(id);
    }

    @PostMapping("/plantillas-plan-pago")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear una plantilla de plan de pago")
    public PlantillaPlanPagoResponse crearPlantilla(@Valid @RequestBody PlantillaPlanPagoRequest request) {
        return plantillaPlanPagoService.crear(request);
    }
}
