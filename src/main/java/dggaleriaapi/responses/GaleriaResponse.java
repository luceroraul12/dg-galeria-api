package dggaleriaapi.responses;

import dggaleriaapi.models.Formato;
import dggaleriaapi.models.Marca;
import dggaleriaapi.models.SaborAsociado;
import dggaleriaapi.models.SaborCliente;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class GaleriaResponse {
    private List<Formato>           formatosCreados;
    private List<Marca>             marcasCreadas;
    private List<SaborAsociado>             saboresDisponibles;
    private List<SaborAsociado>             saboresCreados;
    private List<SaborCliente>      saboresResumidos;


    private Formato                 formatoTrabajado;
    private Marca                   marcaTrabajada;
    private SaborAsociado saborAsociadoTrabajado;
}
