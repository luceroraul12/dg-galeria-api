package dggaleriaapi.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "drink_containers")
public class DrinkContainer extends StockData{
    @Id
    @Column(name = "drinkContainers_id_pk", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="container_name", nullable = false)
    private String containerName;

    @Column(name ="estado_stock")
    @ColumnDefault("true")
    private Boolean isStocked = true;

    public DrinkContainer(Long id, String containerName) {
        this.id = id;
        this.containerName = containerName;
    }
}
