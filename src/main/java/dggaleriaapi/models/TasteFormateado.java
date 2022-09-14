package dggaleriaapi.models;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "tastees_formateados")
public class TasteFormateado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tastees_formateados_id_pk", nullable = false)
    private Long id;
    @Column(name = "is_stocked")
    @ColumnDefault("true")
    private Boolean estadoStock = true;
    @ManyToOne
    @JoinColumn(name = "drink_container_id_fk")
    private DrinkContainer drinkContainer;
    @ManyToOne
    @JoinColumn(name = "tastees_asociados_id_fk")
    private BrandedTaste brandedTaste;
}
