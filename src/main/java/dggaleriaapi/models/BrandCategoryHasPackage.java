package dggaleriaapi.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "brand_category_has_package")
public class BrandCategoryHasPackage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    @OneToOne
    @JoinColumn(name = "package_id")
    private Package aPackage;

    @OneToOne
    @JoinColumn(name = "brand_category_id")
    private BrandCategory brandCategory;
}
