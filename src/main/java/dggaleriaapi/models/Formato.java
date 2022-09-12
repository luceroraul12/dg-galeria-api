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
@Table(name = "formatos")
public class Formato {
    @Id
    @Column(name = "formatos_id_pk", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="tipo", nullable = false)
    private String tipo;

    @Column(name ="estado_stock")
    @ColumnDefault("true")
    private Boolean estadoStock = true;

    public Formato(Long id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }
}
