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
@Table(name = "sabores")
public class SaborAsociado {
    @Id
    @Column(name = "sabores_id_pk", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public SaborAsociado(Long id, String nombre, Marca marca) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
    }

    public SaborAsociado(Long id, String nombre, Marca marca, Boolean estadoStock) {
        this.id = id;
        this.nombre = nombre;
        this.estadoStock = estadoStock;
        this.marca = marca;
    }
}
