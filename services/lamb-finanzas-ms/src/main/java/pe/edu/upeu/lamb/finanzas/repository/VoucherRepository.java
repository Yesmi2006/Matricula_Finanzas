package pe.edu.upeu.lamb.finanzas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.lamb.finanzas.entity.Voucher;

public interface VoucherRepository extends JpaRepository<Voucher, Long> {
}
