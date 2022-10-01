package dggaleriaapi.services.Imp;

import dggaleriaapi.models.Brand;
import dggaleriaapi.repositories.BrandRepository;
import dggaleriaapi.responses.StockDataResponse;
import dggaleriaapi.services.BrandService;
import dggaleriaapi.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImp implements BrandService {

    @Autowired
    ImageService imageService;
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
        if (brand.getBrandName().isEmpty()
                | brand.getUrl().isEmpty()
                | imageService.isURLValid(brand.getUrl())
                | imageService.isURLValid(brand.getUrlIconic())
                | brandRepository.existsByBrandName(brand.getBrandName())){
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
        if (brand.getBrandName().isEmpty()
                | brand.getUrl().isEmpty()
                | imageService.isURLValid(brand.getUrl())
                | imageService.isURLValid(brand.getUrlIconic())
                | !brandRepository.existsByBrandName(brand.getBrandName())){
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

    @Override
    public void downloadAllImages() {
        brandRepository.findAll().forEach(b -> {
            imageService.createImage(
                    b.getId().toString(),
                    b.getUrl(),
                    "brand"
            );
        });
    }

    @Override
    public void downloadImagesByBrand(Brand brand) {
        imageService.createImage(
                brand.getId().toString(),
                brand.getUrl(),
                "brand"
        );
        imageService.createImage(
                brand.getId().toString(),
                brand.getUrlIconic(),
                "brand.iconic"
        );
    }

    @Override
    public void deleteImagesByBrand(Brand brand) {
        imageService.deleteImage(
                brand.getId().toString(),
                "brand"
        );
        imageService.deleteImage(
                brand.getId().toString(),
                "brand.iconic"
        );
    }
}
