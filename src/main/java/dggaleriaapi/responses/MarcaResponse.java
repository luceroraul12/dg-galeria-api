package dggaleriaapi.responses;

import dggaleriaapi.models.Marca;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MarcaResponse {
    private Marca marcaTrabajada;
    private List<Marca> marcasTrabajadas;
    private String mensaje;

}
