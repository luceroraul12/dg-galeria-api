package dggaleriaapi.models;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "brands")
public class Brand {
    @Id
    @Column(name = "brands_id_pk", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "brands_name", nullable = false)
    private String nombre;
    @Column(name = "brands_url", columnDefinition = "TEXT",nullable = false)
    private String enlace;
    @Column(name = "brands_is_stocked")
    @ColumnDefault("true")
    private Boolean estadoStock = true;

    public Brand(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}