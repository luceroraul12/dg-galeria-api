package dggaleriaapi.services;

import dggaleriaapi.models.Brand;
import dggaleriaapi.responses.BrandResponse;
import org.springframework.stereotype.Service;

@Service
public interface BrandService {

    BrandResponse getAll();

    BrandResponse getBrandById(Long idBrand) throws Exception;

    BrandResponse saveBrand(Brand brand) throws Exception;
    BrandResponse updateBrand(Brand brand) throws Exception;
    BrandResponse deleteBrand(Long idBrand) throws Exception;


}
