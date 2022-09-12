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
@Table(name = "marcas")
public class Marca {
    @Id
    @Column(name = "marcas_id_pk", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "enlace", columnDefinition = "TEXT",nullable = false)
    private String enlace;
    @Column(name = "estado_stock")
    @ColumnDefault("true")
    private Boolean estadoStock = true;

    public Marca(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}
