package dggaleriaapi.services.Imp;

import dggaleriaapi.models.DrinkContainer;
import dggaleriaapi.repositories.DrinkContainerRepository;
import dggaleriaapi.responses.DrinkContainerResponse;
import dggaleriaapi.responses.StockDataResponse;
import dggaleriaapi.services.DrinkContainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrinkContainerServiceImp implements DrinkContainerService {

    @Autowired
    DrinkContainerRepository drinkContainerRepository;

    public DrinkContainerServiceImp(DrinkContainerRepository drinkContainerRepository) {
        this.drinkContainerRepository = drinkContainerRepository;
    }

    @Override
    public StockDataResponse getAllDrinkContainers() {
        StockDataResponse response = new StockDataResponse<>();
        response.setStockDataResult(
                drinkContainerRepository.findAll()
        );
        return response;
    }

    @Override
    public DrinkContainerResponse saveDrinkContainer(String tipo) throws Exception {
        if (tipo.isEmpty()){
            throw new Exception();
        }
        DrinkContainer drinkContainer = new DrinkContainer();
        DrinkContainerResponse respuesta = new DrinkContainerResponse();

        drinkContainer.setContainerName(tipo);
        respuesta.setDrinkContainerTrabajado(
                drinkContainerRepository.save(drinkContainer)
        );
        return respuesta;
    }

    @Override
    public DrinkContainerResponse updateDrinkContainer(DrinkContainer drinkContainer) throws Exception {
        if (!drinkContainerRepository.existsById(drinkContainer.getId()) | drinkContainer.getContainerName().isEmpty()){
            throw new Exception();
        }
        DrinkContainerResponse respuesta = new DrinkContainerResponse();

        respuesta.setDrinkContainerTrabajado(
                drinkContainerRepository.save(drinkContainer)
        );
        return respuesta;
    }

    @Override
    public DrinkContainerResponse deleteDrinkContainer(Long idDrinkContainer) throws Exception {
        if (!drinkContainerRepository.existsById(idDrinkContainer)){
            throw new Exception("drinkContainer no existente");
        }
        DrinkContainer drinkContainer = new DrinkContainer();
        DrinkContainerResponse respuesta = new DrinkContainerResponse();
        drinkContainer.setId(idDrinkContainer);
        drinkContainerRepository.delete(drinkContainer);
        respuesta.setDrinkContainerTrabajado(drinkContainer);
        return respuesta;
    }
}
