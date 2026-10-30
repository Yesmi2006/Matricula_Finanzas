package pe.edu.upeu.lamb.finanzas.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upeu.lamb.finanzas.dto.TarifarioEscuelaCicloRequest;
import pe.edu.upeu.lamb.finanzas.dto.TarifarioEscuelaCicloResponse;
import pe.edu.upeu.lamb.finanzas.entity.ConceptoPago;
import pe.edu.upeu.lamb.finanzas.entity.TarifarioEscuelaCiclo;
import pe.edu.upeu.lamb.finanzas.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.finanzas.mapper.TarifarioEscuelaCicloMapper;
import pe.edu.upeu.lamb.finanzas.repository.ConceptoPagoRepository;
import pe.edu.upeu.lamb.finanzas.repository.TarifarioEscuelaCicloRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TarifarioEscuelaCicloService {

    private final TarifarioEscuelaCicloRepository tarifarioEscuelaCicloRepository;
    private final ConceptoPagoRepository conceptoPagoRepository;
    private final TarifarioEscuelaCicloMapper tarifarioEscuelaCicloMapper;

    public List<TarifarioEscuelaCicloResponse> listar() {
        return tarifarioEscuelaCicloRepository.findAll().stream()
                .map(tarifarioEscuelaCicloMapper::toResponse)
                .toList();
    }

    public TarifarioEscuelaCicloResponse obtener(Long id) {
        return tarifarioEscuelaCicloMapper.toResponse(buscarOFallar(id));
    }

    @Transactional
    public TarifarioEscuelaCicloResponse crear(TarifarioEscuelaCicloRequest request) {
        ConceptoPago conceptoPago = conceptoPagoRepository.findById(request.getIdConceptoPago())
                .orElseThrow(() -> new ResourceNotFoundException("Concepto de pago no encontrado: " + request.getIdConceptoPago()));
        TarifarioEscuelaCiclo entity = TarifarioEscuelaCiclo.builder()
                .conceptoPago(conceptoPago)
                .idEscuela(request.getIdEscuela())
                .ciclo(request.getCiclo())
                .monto(request.getMonto())
                .build();
        return tarifarioEscuelaCicloMapper.toResponse(tarifarioEscuelaCicloRepository.save(entity));
    }

    private TarifarioEscuelaCiclo buscarOFallar(Long id) {
        return tarifarioEscuelaCicloRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tarifario de escuela y ciclo no encontrado: " + id));
    }
}
