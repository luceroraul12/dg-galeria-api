package dggaleriaapi.models;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.tuple.GeneratedValueGeneration;
import org.springframework.web.bind.annotation.CrossOrigin;

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

    @Column(name ="estado_stock", nullable = false)
    @ColumnDefault("true")
    private Boolean estadoStock;

    public Formato(Long id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }
}
