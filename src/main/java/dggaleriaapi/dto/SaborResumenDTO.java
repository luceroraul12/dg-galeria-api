package dggaleriaapi.dto;

import dggaleriaapi.models.DrinkContainer;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
@Getter
@Builder
public class SaborResumenDTO {
    private String nombreSabor;
    private List<DrinkContainer> drinkContainersDisponibles;
}
