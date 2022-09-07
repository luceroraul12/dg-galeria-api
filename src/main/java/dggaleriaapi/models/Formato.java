package dggaleriaapi.models;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.tuple.GeneratedValueGeneration;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "formatos")
public class Formato {
    @Id
    @Column(name = "formatos_id_pk", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="tipo", nullable = false)
    private String tipo;

    public Formato(Long id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }
}
