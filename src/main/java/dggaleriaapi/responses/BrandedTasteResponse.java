package dggaleriaapi.responses;

import dggaleriaapi.models.BrandHasTaste;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BrandedTasteResponse {

    private List<BrandHasTaste> tasteesAsociadosTrabajados;
    private BrandHasTaste tasteTrabajado;
    private String mensaje;


}
