package dggaleriaapi.services.Imp;

import dggaleriaapi.models.Brand;
import dggaleriaapi.models.BrandHasTaste;
import dggaleriaapi.models.DrinkContainer;
import dggaleriaapi.models.DrinkContaineredTaste;
import dggaleriaapi.repositories.DrinkContainerRepository;
import dggaleriaapi.repositories.DrinkContaineredTasteRepository;
import dggaleriaapi.responses.StockDataResponse;
import dggaleriaapi.services.DrinkContaineredTasteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DrinkContaineredTasteServiceImp implements DrinkContaineredTasteService {

    @Autowired
    DrinkContaineredTasteRepository drinkContaineredTasteRepository;

    @Autowired
    DrinkContainerRepository drinkContainerRepository;

    @Override
    public StockDataResponse<DrinkContaineredTaste> getAll() {
        StockDataResponse<DrinkContaineredTaste> respuesta = new StockDataResponse<DrinkContaineredTaste>();
        respuesta.setStockDataResult(
                drinkContaineredTasteRepository.findAll()
        );
        return respuesta;
    }

    @Override
    public StockDataResponse<DrinkContaineredTaste> getByBrandedTasteId(BrandHasTaste brandHasTaste) {
        StockDataResponse<DrinkContaineredTaste> respuesta = new StockDataResponse<DrinkContaineredTaste>();
        respuesta.setStockDataResult(
                drinkContaineredTasteRepository.findByBrandHasTaste_Id(brandHasTaste.getId())
        );
        return respuesta;
    }

    @Override
    public StockDataResponse<DrinkContaineredTaste> getAllByIdBrand(Brand brand) {
        StockDataResponse<DrinkContaineredTaste> respuesta = new StockDataResponse<DrinkContaineredTaste>();
        respuesta.setStockDataResult(
                drinkContaineredTasteRepository.getAllByIdBrand(brand.getId())
        );
        return respuesta;

    }

    @Override
    public StockDataResponse<DrinkContaineredTaste> save(DrinkContaineredTaste drinkContaineredTaste) throws Exception {
        boolean esTasteExistente = drinkContaineredTasteRepository.existsByDrinkContainer_IdAndBrandedTaste_Id(
                drinkContaineredTaste.getDrinkContainer().getId(),
                drinkContaineredTaste.getBrandHasTaste().getId()
        );
        if (esTasteExistente){
            throw new Exception();
        }
        StockDataResponse<DrinkContaineredTaste> respuesta = new StockDataResponse<DrinkContaineredTaste>();
        respuesta.setStockDataResult(
                List.of(drinkContaineredTasteRepository.save(drinkContaineredTaste))
        );
        return respuesta;
    }

    @Override
    public StockDataResponse<DrinkContaineredTaste> saveInicial(DrinkContaineredTaste drinkContaineredTaste) throws Exception {
        List<DrinkContaineredTaste> tasteesFormateadosGenerados = generarDrinkContainersParaBrandedTaste(drinkContaineredTaste);
        return savePorMonton(tasteesFormateadosGenerados);
    }

    @Override
    public StockDataResponse<DrinkContaineredTaste> savePorMonton(List<DrinkContaineredTaste> drinkContaineredTastes) throws Exception {
        if (drinkContaineredTastes == null){
            throw new Exception();
        }
        drinkContaineredTastes.removeIf(item -> {
            return drinkContaineredTasteRepository.isExistWithoutChanges(
                    item.getDrinkContainer().getId(),
                    item.getBrandHasTaste().getId()
            );
        });
        StockDataResponse<DrinkContaineredTaste> respuesta = new StockDataResponse<DrinkContaineredTaste>();
        respuesta.setStockDataResult(
                drinkContaineredTasteRepository.saveAll(drinkContaineredTastes)
        );
        return respuesta;
    }

    @Override
    public StockDataResponse<DrinkContaineredTaste> savePorMontonInicial(List<DrinkContaineredTaste> tasteesFormateados) throws Exception {
        if(tasteesFormateados == null){
            throw new Exception();
        }
        StockDataResponse<DrinkContaineredTaste> respuesta = new StockDataResponse<DrinkContaineredTaste>();
        List<DrinkContaineredTaste> conjuntoTasteesFormateados = new ArrayList<>();
        for (DrinkContaineredTaste drinkContaineredTaste : tasteesFormateados) {
            conjuntoTasteesFormateados.addAll(
                    saveInicial(drinkContaineredTaste).getStockDataResult()
            );
        }
        respuesta.setStockDataResult(conjuntoTasteesFormateados);
        return respuesta;
    }

    @Override
    public StockDataResponse<DrinkContaineredTaste> update(DrinkContaineredTaste drinkContaineredTaste) throws Exception {
        if (drinkContaineredTasteRepository.isExistWithoutChanges(
                drinkContaineredTaste.getDrinkContainer().getId(),
                drinkContaineredTaste.getBrandHasTaste().getId()
        )){
            throw new Exception();
        }
        StockDataResponse<DrinkContaineredTaste> respuesta = new StockDataResponse<DrinkContaineredTaste>();
        respuesta.setStockDataResult(
                List.of(drinkContaineredTasteRepository.save(drinkContaineredTaste))
        );
        return respuesta;
    }

    @Override
    public StockDataResponse<DrinkContaineredTaste> changeStockState(DrinkContaineredTaste drinkContaineredTaste) throws Exception {
        if (drinkContaineredTaste.getIsStocked() == null){
            throw new Exception();
        }
        drinkContaineredTasteRepository.updateIsStockedById(
                drinkContaineredTaste.getIsStocked(),
                drinkContaineredTaste.getId()
        );
        StockDataResponse<DrinkContaineredTaste> respuesta = new StockDataResponse<DrinkContaineredTaste>();
        respuesta.setStockDataResult(
                List.of(drinkContaineredTaste)
        );
        return respuesta;
    }

    @Override
    public StockDataResponse<DrinkContaineredTaste> delete(DrinkContaineredTaste drinkContaineredTaste) throws Exception {
        if (!drinkContaineredTasteRepository.existsById(drinkContaineredTaste.getId())){
            throw new Exception();
        }
        drinkContaineredTasteRepository.delete(drinkContaineredTaste);
        StockDataResponse<DrinkContaineredTaste> respuesta = new StockDataResponse<DrinkContaineredTaste>();
        respuesta.setStockDataResult(List.of(drinkContaineredTaste));
        return respuesta;
    }



    private List<DrinkContaineredTaste> generarDrinkContainersParaBrandedTaste(DrinkContaineredTaste drinkContaineredTaste) {
        List<DrinkContaineredTaste> resultado = new ArrayList<>();
        List<DrinkContainer> drinkContainersDisponibles = drinkContainerRepository.findAll();


        drinkContainersDisponibles.forEach(drinkContainer -> {
            resultado.add(
                    generarTasteInmutable(drinkContainer, drinkContaineredTaste)
            );
        });

        return resultado;
    }
    //TODO ver esta función
    private DrinkContaineredTaste generarTasteInmutable(DrinkContainer drinkContainer, DrinkContaineredTaste drinkContaineredTaste) {

        DrinkContaineredTaste taste = new DrinkContaineredTaste();
        BrandHasTaste brandHasTaste = new BrandHasTaste();
        DrinkContainer drinkContainer1 = new DrinkContainer();

        drinkContainer1.setId(drinkContainer.getId().longValue());
        brandHasTaste.setId(drinkContaineredTaste.getBrandHasTaste().getId());
        taste.setBrandHasTaste(brandHasTaste);
        taste.setDrinkContainer(drinkContainer1);

        return taste;
    }
}
