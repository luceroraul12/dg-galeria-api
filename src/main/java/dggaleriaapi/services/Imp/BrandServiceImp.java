package dggaleriaapi.services.Imp;

import dggaleriaapi.models.Brand;
import dggaleriaapi.repositories.BrandRepository;
import dggaleriaapi.responses.BrandResponse;
import dggaleriaapi.responses.StockDataResponse;
import dggaleriaapi.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImp implements BrandService {

    @Autowired
    BrandRepository brandRepository;

    public BrandServiceImp(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public StockDataResponse<Brand> getAll() {
        StockDataResponse<Brand> respuesta = new StockDataResponse<Brand>();
        respuesta.setStockDataResult(
                brandRepository.findAll()
        );
        return respuesta;
    }

    @Override
    public StockDataResponse<Brand> getBrandById(Brand brand) throws Exception {
        if (!brandRepository.existsById(brand.getId())){
            throw new Exception();
        }
        StockDataResponse<Brand> respuesta = new StockDataResponse<Brand>();
        respuesta.setStockDataResult(
                List.of(brandRepository.findById(brand.getId()).get())
        );
        return respuesta;
    }

    @Override
    public StockDataResponse<Brand> saveBrand(Brand brand) throws Exception {
        if (brand.getBrandName().isEmpty() | brand.getUrl().isEmpty()){
            throw new Exception();
        }
        StockDataResponse<Brand> respuesta = new StockDataResponse<Brand>();
        respuesta.setStockDataResult(
                List.of(brandRepository.save(brand))
        );
        return respuesta;
    }

    @Override
    public StockDataResponse<Brand> updateBrand(Brand brand) throws Exception {
        if (brand.getBrandName().isEmpty() | brand.getUrl().isEmpty() | !brandRepository.existsById(brand.getId())){
            throw new Exception();
        }
        StockDataResponse<Brand> respuesta = new StockDataResponse<Brand>();
        respuesta.setStockDataResult(
                List.of(brandRepository.save(brand))
        );
        return respuesta;
    }

    @Override
    public StockDataResponse<Brand> deleteBrand(Brand brand) throws Exception {
        if (!brandRepository.existsById(brand.getId())){
            throw new Exception();
        }
        StockDataResponse<Brand> respuesta = new StockDataResponse<Brand>();
        brandRepository.deleteById(brand.getId());
        respuesta.setStockDataResult(
                List.of(brand)
        );
        return respuesta;
    }
}
