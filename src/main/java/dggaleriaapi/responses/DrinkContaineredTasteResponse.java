package dggaleriaapi.responses;

import dggaleriaapi.models.DrinkContaineredTaste;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DrinkContaineredTasteResponse {
    DrinkContaineredTaste drinkContaineredTasteTrabajado;
    List<DrinkContaineredTaste> tasteesFormateadosTrabajados;
    private String mensaje;

}
