package dggaleriaapi.responses;

import dggaleriaapi.models.DrinkContainer;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FormatoResponse {
    private DrinkContainer drinkContainerTrabajado;
    private List<DrinkContainer> formatosTrabajados;
    private String mensaje;
}
