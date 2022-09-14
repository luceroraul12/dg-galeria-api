package dggaleriaapi.services;

import dggaleriaapi.models.BrandedTaste;
import dggaleriaapi.models.Taste;
import dggaleriaapi.responses.BrandedTasteResponse;
import dggaleriaapi.responses.StockDataResponse;

import java.util.List;

public interface BrandedTasteService {

    StockDataResponse<BrandedTaste> getAll();
    StockDataResponse<BrandedTaste> getAllByIdBrand(BrandedTaste brandedTaste) throws Exception;
    StockDataResponse<BrandedTaste> save(BrandedTaste brandedTaste) throws Exception;
    StockDataResponse<BrandedTaste> savePorMonton(List<BrandedTaste> tasteesAsociados) throws Exception;

    StockDataResponse<BrandedTaste> update(BrandedTaste brandedTaste) throws Exception;

    StockDataResponse<BrandedTaste> delete(BrandedTaste brandedTaste) throws Exception;

}
