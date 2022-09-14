package dggaleriaapi.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "sabores_asociados")
public class SaborAsociado {
    @Id
    @Column(name = "sabores_asociados_id_pk", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "estado_stock")
    @ColumnDefault("true")
    private Boolean estadoStock;

    @ManyToOne
    @JoinColumn(name = "brands_id_fk")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "sabores_id_fk")
    private Sabor sabor;
}
