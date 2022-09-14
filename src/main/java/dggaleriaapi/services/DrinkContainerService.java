package dggaleriaapi.services;

import dggaleriaapi.models.DrinkContainer;
import dggaleriaapi.responses.DrinkContainerResponse;
import dggaleriaapi.responses.StockDataResponse;
import org.springframework.stereotype.Service;

@Service
public interface DrinkContainerService {

    StockDataResponse getAllDrinkContainers();
    DrinkContainerResponse saveDrinkContainer(String containerName) throws Exception;

    DrinkContainerResponse updateDrinkContainer(DrinkContainer drinkContainer) throws Exception;

    DrinkContainerResponse deleteDrinkContainer(Long idDrinkContainer) throws Exception;
}
