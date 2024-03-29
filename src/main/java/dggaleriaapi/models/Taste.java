package dggaleriaapi.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "tastees")
public class Taste extends StockData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "taste_name", nullable = false)
    private String tasteName;
    @Column(name = "is_stocked")
    @ColumnDefault("true")
    private Boolean isStocked;

}
