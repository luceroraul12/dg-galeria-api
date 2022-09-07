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
@Table(name = "formatos")
public class Formato {
    @Id
    @Column(name = "formnatos_id_pk", nullable = false)
    private Long id;

    @Column(name ="tipo", nullable = false)
    private String tipo;

    public Formato(Long id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }
}
