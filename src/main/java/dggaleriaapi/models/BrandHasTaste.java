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
@Table(name = "branded_has_taste")
public class BrandHasTaste extends StockData {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "is_stocked")
    @ColumnDefault("true")
    private Boolean isStocked;

    @ManyToOne
    @JoinColumn(name = "brands_id", unique = true)
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "tastees_id", unique = true)
    private Taste taste;
}
