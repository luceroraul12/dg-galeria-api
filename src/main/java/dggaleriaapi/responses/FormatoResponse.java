package dggaleriaapi.responses;

import dggaleriaapi.models.Formato;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FormatoResponse {
    private Formato formatoTrabajado;
    private List<Formato> formatosTrabajados;
}
