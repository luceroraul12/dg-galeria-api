package dggaleriaapi.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SaborCliente {
    private String nombreSabor;
    private List<Formato> formatos;
    private List<Boolean> estadosStock;
}
