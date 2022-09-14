package dggaleriaapi.responses;

import dggaleriaapi.models.TasteFormateado;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TasteFormateadoResponse {
    TasteFormateado tasteFormateadoTrabajado;
    List<TasteFormateado> tasteesFormateadosTrabajados;
    private String mensaje;

}
