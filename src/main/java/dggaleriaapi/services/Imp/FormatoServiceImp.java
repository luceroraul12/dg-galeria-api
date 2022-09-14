package dggaleriaapi.services.Imp;

import dggaleriaapi.models.DrinkContainer;
import dggaleriaapi.repositories.FormatoRepository;
import dggaleriaapi.responses.FormatoResponse;
import dggaleriaapi.responses.StockDataResponse;
import dggaleriaapi.services.FormatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormatoServiceImp implements FormatoService {

    @Autowired
    FormatoRepository formatoRepository;

    public FormatoServiceImp(FormatoRepository formatoRepository) {
        this.formatoRepository = formatoRepository;
    }

    @Override
    public StockDataResponse getAllFormatos() {
        StockDataResponse response = new StockDataResponse<>();
        response.setStockDataResult(
                formatoRepository.findAll()
        );
        return response;
    }

    @Override
    public FormatoResponse saveFormato(String tipo) throws Exception {
        if (tipo.isEmpty()){
            throw new Exception();
        }
        DrinkContainer drinkContainer = new DrinkContainer();
        FormatoResponse respuesta = new FormatoResponse();

        drinkContainer.setContainerName(tipo);
        respuesta.setDrinkContainerTrabajado(
                formatoRepository.save(drinkContainer)
        );
        return respuesta;
    }

    @Override
    public FormatoResponse updateFormato(DrinkContainer drinkContainer) throws Exception {
        if (!formatoRepository.existsById(drinkContainer.getId()) | drinkContainer.getContainerName().isEmpty()){
            throw new Exception();
        }
        FormatoResponse respuesta = new FormatoResponse();

        respuesta.setDrinkContainerTrabajado(
                formatoRepository.save(drinkContainer)
        );
        return respuesta;
    }

    @Override
    public FormatoResponse deleteFormato(Long idFormato) throws Exception {
        if (!formatoRepository.existsById(idFormato)){
            throw new Exception("drinkContainer no existente");
        }
        DrinkContainer drinkContainer = new DrinkContainer();
        FormatoResponse respuesta = new FormatoResponse();
        drinkContainer.setId(idFormato);
        formatoRepository.delete(drinkContainer);
        respuesta.setDrinkContainerTrabajado(drinkContainer);
        return respuesta;
    }
}
