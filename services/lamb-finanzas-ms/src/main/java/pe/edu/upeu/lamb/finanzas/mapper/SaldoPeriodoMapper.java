package pe.edu.upeu.lamb.finanzas.mapper;

import org.springframework.stereotype.Component;
import pe.edu.upeu.lamb.finanzas.dto.SaldoPeriodoRequest;
import pe.edu.upeu.lamb.finanzas.dto.SaldoPeriodoResponse;
import pe.edu.upeu.lamb.finanzas.entity.SaldoPeriodo;

@Component
public class SaldoPeriodoMapper {

    public SaldoPeriodo toEntity(SaldoPeriodoRequest request) {
        return SaldoPeriodo.builder()
                .idCuenta(request.getIdCuenta())
                .periodo(request.getPeriodo())
                .build();
    }

    public SaldoPeriodoResponse toResponse(SaldoPeriodo entity) {
        return SaldoPeriodoResponse.builder()
                .id(entity.getId())
                .idCuenta(entity.getIdCuenta())
                .periodo(entity.getPeriodo())
                .saldoCalculado(entity.getSaldoCalculado())
                .fechaCalculo(entity.getFechaCalculo())
                .build();
    }
}
