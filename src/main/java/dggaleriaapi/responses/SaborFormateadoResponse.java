package dggaleriaapi.responses;

import dggaleriaapi.models.SaborFormateado;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SaborFormateadoResponse {
    SaborFormateado saborFormateadoTrabajado;
    List<SaborFormateado> saboresFormateadosTrabajados;
    private String mensaje;

}
