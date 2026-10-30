package pe.edu.upeu.lamb.finanzas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.lamb.finanzas.entity.EstadoCobro;

public interface EstadoCobroRepository extends JpaRepository<EstadoCobro, Long> {
}
