package dggaleriaapi.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "sabores_formateados")
public class SaborFormateado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sabores_formateados_id_pk", nullable = false)
    private Long id;
    @Column(name = "estado_stock")
    private Boolean estadoStock;
    @ManyToOne
    @JoinColumn(name = "formatos_id_fk")
    private Formato formato;
    @ManyToOne
    @JoinColumn(name = "sabores_asociados_id_fk")
    private SaborAsociado saborAsociado;
}
