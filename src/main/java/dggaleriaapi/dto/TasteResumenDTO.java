package dggaleriaapi.dto;

import dggaleriaapi.models.DrinkContainer;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
@Getter
@Builder
public class TasteResumenDTO {
    private String tasteName;
    private List<DrinkContainer> drinkContainersAvailable;
}
