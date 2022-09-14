package dggaleriaapi.responses;

import dggaleriaapi.models.TasteAsociado;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TasteAsociadoResponse {

    private List<TasteAsociado> tasteesAsociadosTrabajados;
    private TasteAsociado tasteTrabajado;
    private String mensaje;


}
