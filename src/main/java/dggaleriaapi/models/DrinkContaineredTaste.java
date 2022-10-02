package dggaleriaapi.models;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@Table(name = "tastees_formateados")
@NoArgsConstructor
@AllArgsConstructor
public class DrinkContaineredTaste extends StockData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tastees_formateados_id_pk", nullable = false)
    private Long id;
    @Column(name = "is_stocked")
    @ColumnDefault("true")
    private Boolean isStocked = true;
    @ManyToOne
    @JoinColumn(name = "drink_container_id_fk",unique = true)
    private DrinkContainer drinkContainer;
    @ManyToOne
    @JoinColumn(name = "branded_taste_id_fk", unique = true)
    private BrandedTaste brandedTaste;
}
