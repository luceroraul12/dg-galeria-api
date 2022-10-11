package dggaleriaapi.models;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "brands")
public class Brand extends StockData {
    @Id
    @Column(name = "brands_id_pk", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "brands_name", nullable = false)
    private String brandName;
    @Column(name = "brands_url", columnDefinition = "TEXT",nullable = false)
    private String url;
    @Column(name = "brands_iconic_url", columnDefinition = "TEXT", nullable = false)
    private String urlIconic;
    @Column(name = "brands_is_stocked")
    @ColumnDefault("true")
    private Boolean isStocked = true;

    @ManyToOne
    @JoinColumn(name = "brand_category_id_fk")
    private BrandCategory brandCategory;

    public Brand(Long id, String brandName) {
        this.id = id;
        this.brandName = brandName;
    }
}
