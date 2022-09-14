package dggaleriaapi.responses;

import dggaleriaapi.models.DrinkContainer;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DrinkContainerResponse {
    private DrinkContainer drinkContainerTrabajado;
    private List<DrinkContainer> drinkContainersTrabajados;
    private String mensaje;
}
