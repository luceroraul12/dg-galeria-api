package dggaleriaapi.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@Table(name = "brand_category")
public class BrandCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "brand_category_name", nullable = false)
    private String categoryName;

    public BrandCategory() {
    }

}
