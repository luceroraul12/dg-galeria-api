package dggaleriaapi.services;

import dggaleriaapi.models.Brand;
import dggaleriaapi.models.BrandHasTaste;
import dggaleriaapi.models.DrinkContaineredTaste;
import dggaleriaapi.responses.StockDataResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DrinkContaineredTasteService {

    StockDataResponse<DrinkContaineredTaste> getAll();

    StockDataResponse<DrinkContaineredTaste> getByBrandedTasteId(BrandHasTaste brandHasTaste);

    StockDataResponse<DrinkContaineredTaste> getAllByIdBrand(Brand brand);

    StockDataResponse<DrinkContaineredTaste> save(DrinkContaineredTaste drinkContaineredTaste) throws Exception;

    StockDataResponse<DrinkContaineredTaste> saveInicial(DrinkContaineredTaste drinkContaineredTaste) throws Exception;

    StockDataResponse<DrinkContaineredTaste> savePorMonton(List<DrinkContaineredTaste> tasteesFormateados) throws Exception;

    StockDataResponse<DrinkContaineredTaste> savePorMontonInicial(List<DrinkContaineredTaste> tasteesFormateados) throws Exception;

    StockDataResponse<DrinkContaineredTaste> update(DrinkContaineredTaste drinkContaineredTaste) throws Exception;
    StockDataResponse<DrinkContaineredTaste> changeStockState(DrinkContaineredTaste drinkContaineredTaste) throws Exception;

    StockDataResponse<DrinkContaineredTaste> delete(DrinkContaineredTaste drinkContaineredTaste) throws Exception;
}
