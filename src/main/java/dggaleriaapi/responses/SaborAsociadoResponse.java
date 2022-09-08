package dggaleriaapi.responses;

import dggaleriaapi.models.SaborAsociado;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SaborAsociadoResponse {

    private List<SaborAsociado> saboresAsociadosTrabajados;
    private SaborAsociado saborTrabajado;

}
