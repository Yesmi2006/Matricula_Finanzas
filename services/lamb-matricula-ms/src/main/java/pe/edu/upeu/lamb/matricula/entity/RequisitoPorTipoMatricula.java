package pe.edu.upeu.lamb.matricula.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "requisitos_por_tipo_matricula")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequisitoPorTipoMatricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_tipo_matricula", nullable = false)
    private Long idTipoMatricula;

    // JALA ID DE CURRICULO: el requisito en si (ej. Prerrequisito) lo define y mantiene
    // lamb-curriculo-ms. Aqui solo se referencia su id externo, sin FK local. Si el equipo
    // de Curriculo aun no expone ese CRUD, este id queda pendiente de validar via Feign.
    @Column(name = "id_requisito_curriculo", nullable = false)
    private Long idRequisitoCurriculo;

    @Column(name = "descripcion", length = 255)
    private String descripcion;

    @Column(name = "obligatorio", nullable = false)
    private Boolean obligatorio;
}
