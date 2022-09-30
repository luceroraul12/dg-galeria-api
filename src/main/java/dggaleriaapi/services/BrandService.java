package dggaleriaapi.services;

import dggaleriaapi.models.Brand;
import dggaleriaapi.responses.StockDataResponse;
import org.springframework.stereotype.Service;

@Service
public interface BrandService {

    StockDataResponse<Brand> getAll();

    StockDataResponse<Brand> getBrandById(Brand brand) throws Exception;

    StockDataResponse<Brand> saveBrand(Brand brand) throws Exception;
    StockDataResponse<Brand> updateBrand(Brand brand) throws Exception;
    StockDataResponse<Brand> deleteBrand(Brand brand) throws Exception;

    void downloadImages();


}
