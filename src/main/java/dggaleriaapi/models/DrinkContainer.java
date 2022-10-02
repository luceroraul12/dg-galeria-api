package dggaleriaapi.models;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Builder
@AllArgsConstructor
@Table(name = "drink_containers")
public class DrinkContainer extends StockData{
    @Id
    @Column(name = "drinkContainers_id_pk", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="container_name", nullable = false)
    private Integer containerName;

    @Column(name ="is_stocked")
    @ColumnDefault("true")
    private Boolean isStocked = true;
}
