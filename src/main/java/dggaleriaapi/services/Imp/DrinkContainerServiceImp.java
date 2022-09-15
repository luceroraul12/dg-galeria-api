package dggaleriaapi.services.Imp;

import dggaleriaapi.models.DrinkContainer;
import dggaleriaapi.repositories.DrinkContainerRepository;
import dggaleriaapi.responses.StockDataResponse;
import dggaleriaapi.services.DrinkContainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrinkContainerServiceImp implements DrinkContainerService {

    @Autowired
    DrinkContainerRepository drinkContainerRepository;

    public DrinkContainerServiceImp(DrinkContainerRepository drinkContainerRepository) {
        this.drinkContainerRepository = drinkContainerRepository;
    }

    @Override
    public StockDataResponse<DrinkContainer> getAllDrinkContainers() {
        StockDataResponse<DrinkContainer>  response = new StockDataResponse<DrinkContainer> ();
        response.setStockDataResult(
                drinkContainerRepository.findAll()
        );
        return response;
    }

    @Override
    public StockDataResponse<DrinkContainer> saveDrinkContainer(DrinkContainer drinkContainer) throws Exception {
        if (drinkContainer.getContainerName().isEmpty()){
            throw new Exception();
        }
        StockDataResponse<DrinkContainer>  response = new StockDataResponse<DrinkContainer> ();

        response.setStockDataResult(
                List.of(drinkContainerRepository.save(drinkContainer))
        );
        return response;
    }

    @Override
    public StockDataResponse<DrinkContainer> updateDrinkContainer(DrinkContainer drinkContainer) throws Exception {
        if (!drinkContainerRepository.existsById(drinkContainer.getId()) | drinkContainer.getContainerName().isEmpty()){
            throw new Exception();
        }
        StockDataResponse<DrinkContainer>  respuesta = new StockDataResponse<DrinkContainer> ();

        respuesta.setStockDataResult(
                List.of(drinkContainerRepository.save(drinkContainer))
        );
        return respuesta;
    }

    @Override
    public StockDataResponse<DrinkContainer>  deleteDrinkContainer(DrinkContainer drinkContainer) throws Exception {
        if (!drinkContainerRepository.existsById(drinkContainer.getId())){
            throw new Exception("drinkContainer no existente");
        }
        StockDataResponse<DrinkContainer>  respuesta = new StockDataResponse<DrinkContainer> ();
        drinkContainerRepository.delete(drinkContainer);
        respuesta.setStockDataResult(List.of(drinkContainer));
        return respuesta;
    }
}
