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

    public Marca(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}
