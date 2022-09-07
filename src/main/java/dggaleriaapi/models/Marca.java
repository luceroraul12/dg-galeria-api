package dggaleriaapi.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "marcas")
public class Marca {
    @Id
    @Column(name = "marcas_id_pk", nullable = false)
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
