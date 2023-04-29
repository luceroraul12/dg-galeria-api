package dggaleriaapi.models;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@Table(name = "branded_taste_has_container")
@NoArgsConstructor
@AllArgsConstructor
public class DrinkContaineredTaste extends StockData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "is_stocked")
    @ColumnDefault("true")
    private Boolean isStocked = true;
    @ManyToOne
    @JoinColumn(name = "drink_container_id",unique = true)
    private DrinkContainer drinkContainer;
    @ManyToOne
    @JoinColumn(name = "branded_taste_id", unique = true)
    private BrandHasTaste brandHasTaste;
}
