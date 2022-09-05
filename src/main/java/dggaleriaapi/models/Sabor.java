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
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "estadoStock")
    private Boolean estadoStock;
    @ManyToOne
    @JoinColumn(name = "formato_id_fk")
    private Formato formato;
    @ManyToOne
    @JoinColumn(name = "marca_id_fk")
    private Marca marca;
}
