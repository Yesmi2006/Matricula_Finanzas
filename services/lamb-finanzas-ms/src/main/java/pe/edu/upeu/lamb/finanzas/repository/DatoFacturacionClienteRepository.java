package pe.edu.upeu.lamb.finanzas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.lamb.finanzas.entity.DatoFacturacionCliente;

public interface DatoFacturacionClienteRepository extends JpaRepository<DatoFacturacionCliente, Long> {
}
