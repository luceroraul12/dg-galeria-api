package dggaleriaapi.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "sabores")
public class Sabor {
    @Id
    @Column(name = "sabores_id_pk", nullable = false)
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "estado_stock")
    private Boolean estadoStock;
    @ManyToOne
    @JoinColumn(name = "formatos_id_fk")
    private Formato formato;
    @ManyToOne
    @JoinColumn(name = "marcas_id_fk")
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
