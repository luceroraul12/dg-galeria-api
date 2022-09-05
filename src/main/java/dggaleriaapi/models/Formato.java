package dggaleriaapi.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "formatos")
public class Formato {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name ="tipo", nullable = false)
    private String tipo;
}
