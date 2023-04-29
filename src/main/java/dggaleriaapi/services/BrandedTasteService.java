package dggaleriaapi.services;

import dggaleriaapi.models.BrandHasTaste;
import dggaleriaapi.responses.StockDataResponse;

import java.util.List;

public interface BrandedTasteService {

    StockDataResponse<BrandHasTaste> getAll();
    StockDataResponse<BrandHasTaste> getAllByIdBrand(BrandHasTaste brandHasTaste) throws Exception;
    StockDataResponse<BrandHasTaste> save(BrandHasTaste brandHasTaste) throws Exception;
    StockDataResponse<BrandHasTaste> savePorMonton(List<BrandHasTaste> tasteesAsociados) throws Exception;

    StockDataResponse<BrandHasTaste> update(BrandHasTaste brandHasTaste) throws Exception;

    StockDataResponse<BrandHasTaste> changeStockState(BrandHasTaste brandHasTaste) throws Exception;


    StockDataResponse<BrandHasTaste> delete(BrandHasTaste brandHasTaste) throws Exception;

}
