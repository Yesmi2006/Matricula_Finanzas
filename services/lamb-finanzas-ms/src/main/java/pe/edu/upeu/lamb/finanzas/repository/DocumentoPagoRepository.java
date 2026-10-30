package pe.edu.upeu.lamb.finanzas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.lamb.finanzas.entity.DocumentoPago;

public interface DocumentoPagoRepository extends JpaRepository<DocumentoPago, Long> {
}
