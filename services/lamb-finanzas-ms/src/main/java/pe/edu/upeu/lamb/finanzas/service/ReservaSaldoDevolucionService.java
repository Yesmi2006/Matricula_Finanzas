package pe.edu.upeu.lamb.finanzas.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upeu.lamb.finanzas.dto.ReservaSaldoDevolucionRequest;
import pe.edu.upeu.lamb.finanzas.dto.ReservaSaldoDevolucionResponse;
import pe.edu.upeu.lamb.finanzas.entity.ReservaSaldoDevolucion;
import pe.edu.upeu.lamb.finanzas.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.finanzas.mapper.ReservaSaldoDevolucionMapper;
import pe.edu.upeu.lamb.finanzas.repository.ReservaSaldoDevolucionRepository;

import java.time.Instant;
import java.util.List;

/**
 * CRUD opcional: depende de la universidad.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ReservaSaldoDevolucionService {

    private final ReservaSaldoDevolucionRepository reservaSaldoDevolucionRepository;
    private final ReservaSaldoDevolucionMapper reservaSaldoDevolucionMapper;

    public List<ReservaSaldoDevolucionResponse> listar() {
        return reservaSaldoDevolucionRepository.findAll().stream()
                .map(reservaSaldoDevolucionMapper::toResponse)
                .toList();
    }

    public ReservaSaldoDevolucionResponse obtener(Long id) {
        return reservaSaldoDevolucionMapper.toResponse(buscarOFallar(id));
    }

    @Transactional
    public ReservaSaldoDevolucionResponse crear(ReservaSaldoDevolucionRequest request) {
        ReservaSaldoDevolucion entity = reservaSaldoDevolucionMapper.toEntity(request);
        entity.setFecha(Instant.now());
        return reservaSaldoDevolucionMapper.toResponse(reservaSaldoDevolucionRepository.save(entity));
    }

    private ReservaSaldoDevolucion buscarOFallar(Long id) {
        return reservaSaldoDevolucionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reserva de saldo para devolucion no encontrada: " + id));
    }
}
