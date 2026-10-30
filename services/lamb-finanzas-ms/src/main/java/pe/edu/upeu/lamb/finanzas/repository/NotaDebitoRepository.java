package pe.edu.upeu.lamb.finanzas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.lamb.finanzas.entity.NotaDebito;

public interface NotaDebitoRepository extends JpaRepository<NotaDebito, Long> {
}
