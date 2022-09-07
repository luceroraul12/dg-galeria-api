package dggaleriaapi.responses;

import dggaleriaapi.models.Formato;
import dggaleriaapi.models.Marca;
import dggaleriaapi.models.Sabor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;


@Getter
@Setter
public class GaleriaResponse {
    private List<Formato>   formatosDiponibles;
    private List<Marca>     marcasDisponibles;
    private List<Sabor>     saboresDisponibles;
    private List<Sabor>     saboresCreados;

    private Formato     formatoTrabajado;
    private Marca       marcasTrabajado;
    private Sabor       saboresTrabajado;
}
