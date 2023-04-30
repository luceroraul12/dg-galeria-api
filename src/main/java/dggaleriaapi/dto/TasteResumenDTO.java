package dggaleriaapi.dto;

import dggaleriaapi.models.DrinkContainer;
import dggaleriaapi.models.Package;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
@Getter
@Builder
public class TasteResumenDTO {
    private Long id;
    private String brandName;
    private String tasteName;
    private boolean stockState;
    private List<DrinkContainer> drinkContainersAvailable;
    private List<Package> packageAvailable;
}
