package pe.edu.upeu.lamb.finanzas.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.lamb.finanzas.dto.AnulacionComprobanteRequest;
import pe.edu.upeu.lamb.finanzas.dto.AnulacionComprobanteResponse;
import pe.edu.upeu.lamb.finanzas.dto.DatoFacturacionClienteRequest;
import pe.edu.upeu.lamb.finanzas.dto.DatoFacturacionClienteResponse;
import pe.edu.upeu.lamb.finanzas.dto.DocumentoPagoRequest;
import pe.edu.upeu.lamb.finanzas.dto.DocumentoPagoResponse;
import pe.edu.upeu.lamb.finanzas.dto.NotaCreditoRequest;
import pe.edu.upeu.lamb.finanzas.dto.NotaCreditoResponse;
import pe.edu.upeu.lamb.finanzas.dto.NotaDebitoRequest;
import pe.edu.upeu.lamb.finanzas.dto.NotaDebitoResponse;
import pe.edu.upeu.lamb.finanzas.dto.SerieCorrelativoComprobanteRequest;
import pe.edu.upeu.lamb.finanzas.dto.SerieCorrelativoComprobanteResponse;
import pe.edu.upeu.lamb.finanzas.service.AnulacionComprobanteService;
import pe.edu.upeu.lamb.finanzas.service.DatoFacturacionClienteService;
import pe.edu.upeu.lamb.finanzas.service.DocumentoPagoService;
import pe.edu.upeu.lamb.finanzas.service.NotaCreditoService;
import pe.edu.upeu.lamb.finanzas.service.NotaDebitoService;
import pe.edu.upeu.lamb.finanzas.service.SerieCorrelativoComprobanteService;

import java.util.List;

/**
 * Dominio "Comprobantes" (CRUD unificado). Subrecursos: documento de pago,
 * serie/correlativo de comprobante, dato de facturacion del cliente,
 * anulacion de comprobante, nota de credito (opcional), nota de debito
 * (opcional).
 */
@RestController
@RequestMapping("/api/v1/comprobantes")
@RequiredArgsConstructor
@Tag(name = "comprobantes-controller")
public class ComprobantesController {

    private final DocumentoPagoService documentoPagoService;
    private final SerieCorrelativoComprobanteService serieCorrelativoComprobanteService;
    private final DatoFacturacionClienteService datoFacturacionClienteService;
    private final AnulacionComprobanteService anulacionComprobanteService;
    private final NotaCreditoService notaCreditoService;
    private final NotaDebitoService notaDebitoService;

    // --- Documento de pago ---

    @GetMapping("/documentos-pago")
    @Operation(summary = "Listar documentos de pago")
    public List<DocumentoPagoResponse> listarDocumentosPago() {
        return documentoPagoService.listar();
    }

    @GetMapping("/documentos-pago/{id}")
    @Operation(summary = "Obtener un documento de pago")
    public DocumentoPagoResponse obtenerDocumentoPago(@PathVariable Long id) {
        return documentoPagoService.obtener(id);
    }

    @PostMapping("/documentos-pago")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear un documento de pago")
    public DocumentoPagoResponse crearDocumentoPago(@Valid @RequestBody DocumentoPagoRequest request) {
        return documentoPagoService.crear(request);
    }

    // --- Serie/correlativo de comprobante ---

    @GetMapping("/series-correlativos-comprobante")
    @Operation(summary = "Listar series y correlativos de comprobante")
    public List<SerieCorrelativoComprobanteResponse> listarSeriesCorrelativos() {
        return serieCorrelativoComprobanteService.listar();
    }

    @GetMapping("/series-correlativos-comprobante/{id}")
    @Operation(summary = "Obtener una serie/correlativo de comprobante")
    public SerieCorrelativoComprobanteResponse obtenerSerieCorrelativo(@PathVariable Long id) {
        return serieCorrelativoComprobanteService.obtener(id);
    }

    @PostMapping("/series-correlativos-comprobante")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear una serie/correlativo de comprobante")
    public SerieCorrelativoComprobanteResponse crearSerieCorrelativo(@Valid @RequestBody SerieCorrelativoComprobanteRequest request) {
        return serieCorrelativoComprobanteService.crear(request);
    }

    // --- Dato de facturacion del cliente ---

    @GetMapping("/datos-facturacion-cliente")
    @Operation(summary = "Listar datos de facturacion del cliente")
    public List<DatoFacturacionClienteResponse> listarDatosFacturacion() {
        return datoFacturacionClienteService.listar();
    }

    @GetMapping("/datos-facturacion-cliente/{id}")
    @Operation(summary = "Obtener un dato de facturacion del cliente")
    public DatoFacturacionClienteResponse obtenerDatoFacturacion(@PathVariable Long id) {
        return datoFacturacionClienteService.obtener(id);
    }

    @PostMapping("/datos-facturacion-cliente")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear un dato de facturacion del cliente")
    public DatoFacturacionClienteResponse crearDatoFacturacion(@Valid @RequestBody DatoFacturacionClienteRequest request) {
        return datoFacturacionClienteService.crear(request);
    }

    // --- Anulacion de comprobante ---

    @GetMapping("/anulaciones-comprobante")
    @Operation(summary = "Listar anulaciones de comprobante")
    public List<AnulacionComprobanteResponse> listarAnulacionesComprobante() {
        return anulacionComprobanteService.listar();
    }

    @GetMapping("/anulaciones-comprobante/{id}")
    @Operation(summary = "Obtener una anulacion de comprobante")
    public AnulacionComprobanteResponse obtenerAnulacionComprobante(@PathVariable Long id) {
        return anulacionComprobanteService.obtener(id);
    }

    @PostMapping("/anulaciones-comprobante")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear una anulacion de comprobante")
    public AnulacionComprobanteResponse crearAnulacionComprobante(@Valid @RequestBody AnulacionComprobanteRequest request) {
        return anulacionComprobanteService.crear(request);
    }

    // --- Nota de credito (opcional) ---

    @GetMapping("/notas-credito")
    @Operation(summary = "Listar notas de credito")
    public List<NotaCreditoResponse> listarNotasCredito() {
        return notaCreditoService.listar();
    }

    @GetMapping("/notas-credito/{id}")
    @Operation(summary = "Obtener una nota de credito")
    public NotaCreditoResponse obtenerNotaCredito(@PathVariable Long id) {
        return notaCreditoService.obtener(id);
    }

    @PostMapping("/notas-credito")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear una nota de credito")
    public NotaCreditoResponse crearNotaCredito(@Valid @RequestBody NotaCreditoRequest request) {
        return notaCreditoService.crear(request);
    }

    // --- Nota de debito (opcional) ---

    @GetMapping("/notas-debito")
    @Operation(summary = "Listar notas de debito")
    public List<NotaDebitoResponse> listarNotasDebito() {
        return notaDebitoService.listar();
    }

    @GetMapping("/notas-debito/{id}")
    @Operation(summary = "Obtener una nota de debito")
    public NotaDebitoResponse obtenerNotaDebito(@PathVariable Long id) {
        return notaDebitoService.obtener(id);
    }

    @PostMapping("/notas-debito")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear una nota de debito")
    public NotaDebitoResponse crearNotaDebito(@Valid @RequestBody NotaDebitoRequest request) {
        return notaDebitoService.crear(request);
    }
}
