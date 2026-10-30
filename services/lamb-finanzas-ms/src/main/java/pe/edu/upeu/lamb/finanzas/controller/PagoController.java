package pe.edu.upeu.lamb.finanzas.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import pe.edu.upeu.lamb.finanzas.dto.PagoRequest;
import pe.edu.upeu.lamb.finanzas.dto.PagoResponse;
import pe.edu.upeu.lamb.finanzas.dto.RecaudacionVentanillaRequest;
import pe.edu.upeu.lamb.finanzas.dto.RecaudacionVentanillaResponse;
import pe.edu.upeu.lamb.finanzas.dto.VoucherRequest;
import pe.edu.upeu.lamb.finanzas.dto.VoucherResponse;
import pe.edu.upeu.lamb.finanzas.service.PagoService;
import pe.edu.upeu.lamb.finanzas.service.RecaudacionVentanillaService;
import pe.edu.upeu.lamb.finanzas.service.VoucherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Dominio "Pagos" (CRUD unificado). Base {@code /api/v1/pagos} preservada
 * sin cambios por ser parte de la saga de matricula-finanzas. Subrecursos:
 * voucher, recaudacion por ventanilla.
 */
@RestController
@RequestMapping("/api/v1/pagos")
@RequiredArgsConstructor
@Tag(name = "pagos-controller")
public class PagoController {

    private final PagoService pagoService;
    private final VoucherService voucherService;
    private final RecaudacionVentanillaService recaudacionVentanillaService;

    @GetMapping
    @Operation(summary = "Listar pagos")
    public List<PagoResponse> listar() {
        return pagoService.listar();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un pago")
    public PagoResponse obtener(@PathVariable Long id) {
        return pagoService.obtener(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Procesar un pago")
    public PagoResponse procesar(@Valid @RequestBody PagoRequest request) {
        return pagoService.procesar(request);
    }

    @PostMapping("/{id}/reembolsar")
    @Operation(summary = "Reembolsar un pago")
    public PagoResponse reembolsar(@PathVariable Long id) {
        return pagoService.reembolsar(id);
    }

    // --- Voucher ---

    @GetMapping("/vouchers")
    @Operation(summary = "Listar vouchers")
    public List<VoucherResponse> listarVouchers() {
        return voucherService.listar();
    }

    @GetMapping("/vouchers/{id}")
    @Operation(summary = "Obtener un voucher")
    public VoucherResponse obtenerVoucher(@PathVariable Long id) {
        return voucherService.obtener(id);
    }

    @PostMapping("/vouchers")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear un voucher")
    public VoucherResponse crearVoucher(@Valid @RequestBody VoucherRequest request) {
        return voucherService.crear(request);
    }

    // --- Recaudacion por ventanilla ---

    @GetMapping("/recaudaciones-ventanilla")
    @Operation(summary = "Listar recaudaciones por ventanilla")
    public List<RecaudacionVentanillaResponse> listarRecaudaciones() {
        return recaudacionVentanillaService.listar();
    }

    @GetMapping("/recaudaciones-ventanilla/{id}")
    @Operation(summary = "Obtener una recaudacion por ventanilla")
    public RecaudacionVentanillaResponse obtenerRecaudacion(@PathVariable Long id) {
        return recaudacionVentanillaService.obtener(id);
    }

    @PostMapping("/recaudaciones-ventanilla")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear una recaudacion por ventanilla")
    public RecaudacionVentanillaResponse crearRecaudacion(@Valid @RequestBody RecaudacionVentanillaRequest request) {
        return recaudacionVentanillaService.crear(request);
    }
}
