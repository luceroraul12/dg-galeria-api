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

    public Sabor(Long id, String nombre, Marca marca) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
    }

    public Sabor(Long id, String nombre, Marca marca, Boolean estadoStock) {
        this.id = id;
        this.nombre = nombre;
        this.estadoStock = estadoStock;
        this.marca = marca;
    }
}
