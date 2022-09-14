package dggaleriaapi.responses;

import dggaleriaapi.models.BrandedTaste;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BrandedTasteResponse {

    private List<BrandedTaste> tasteesAsociadosTrabajados;
    private BrandedTaste tasteTrabajado;
    private String mensaje;


}
