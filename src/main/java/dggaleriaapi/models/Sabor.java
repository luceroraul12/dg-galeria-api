package dggaleriaapi.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "sabores")
public class Sabor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sabores_id_pk", nullable = false)
    private Long id;
    @Column(name = "nombre", nullable = false)
    private String nombre;

}
