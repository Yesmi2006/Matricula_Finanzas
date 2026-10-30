package pe.edu.upeu.lamb.finanzas.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "plantillas_plan_pago")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlantillaPlanPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 150)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false, length = 20)
    private TipoPlanPago tipo;

    @Column(name = "numero_cuotas", nullable = false)
    private Integer numeroCuotas;
}
