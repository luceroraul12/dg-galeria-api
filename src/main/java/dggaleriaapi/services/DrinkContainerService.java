package dggaleriaapi.services;

import dggaleriaapi.models.DrinkContainer;
import dggaleriaapi.responses.DrinkContainerResponse;
import dggaleriaapi.responses.StockDataResponse;
import org.springframework.stereotype.Service;

@Service
public interface DrinkContainerService {

    StockDataResponse<DrinkContainer> getAllDrinkContainers();
    StockDataResponse<DrinkContainer> saveDrinkContainer(DrinkContainer drinkContainer) throws Exception;

    StockDataResponse<DrinkContainer> updateDrinkContainer(DrinkContainer drinkContainer) throws Exception;

    StockDataResponse<DrinkContainer> deleteDrinkContainer(DrinkContainer drinkContainer) throws Exception;
}
