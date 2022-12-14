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
@Table(name = "branded_taste")
public class BrandedTaste extends StockData {
    @Id
    @Column(name = "branded_taste_id_pk", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "is_stocked")
    @ColumnDefault("true")
    private Boolean isStocked;

    @ManyToOne
    @JoinColumn(name = "brands_id_fk", unique = true)
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "tastees_id_fk", unique = true)
    private Taste taste;
}
