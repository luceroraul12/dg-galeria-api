package dggaleriaapi.services.Imp;

import dggaleriaapi.models.Brand;
import dggaleriaapi.repositories.BrandRepository;
import dggaleriaapi.responses.DrinkContainerResponse;
import dggaleriaapi.responses.BrandResponse;
import dggaleriaapi.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImp implements BrandService {

    @Autowired
    BrandRepository brandRepository;

    public BrandServiceImp(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public BrandResponse getAll() {
        BrandResponse respuesta = new BrandResponse();
        respuesta.setBrandsTrabajadas(
                brandRepository.findAll()
        );
        return respuesta;
    }

    @Override
    public BrandResponse getBrandById(Long idBrand) throws Exception {
        if (!brandRepository.existsById(idBrand)){
            throw new Exception();
        }
        BrandResponse respuesta = new BrandResponse();
        respuesta.setBrandTrabajada(
                brandRepository.findById(idBrand).get()
        );
        return respuesta;
    }

    @Override
    public BrandResponse saveBrand(Brand brand) throws Exception {
        if (brand.getNombre().isEmpty() | brand.getEnlace().isEmpty()){
            throw new Exception();
        }
        BrandResponse respuesta = new BrandResponse();
        respuesta.setBrandTrabajada(
                brandRepository.save(brand)
        );
        return respuesta;
    }

    @Override
    public BrandResponse updateBrand(Brand brand) throws Exception {
        if (brand.getNombre().isEmpty() | brand.getEnlace().isEmpty() | !brandRepository.existsById(brand.getId())){
            throw new Exception();
        }
        BrandResponse respuesta = new BrandResponse();
        respuesta.setBrandTrabajada(
                brandRepository.save(brand)
        );
        return respuesta;
    }

    @Override
    public BrandResponse deleteBrand(Long idBrand) throws Exception {
        if (!brandRepository.existsById(idBrand)){
            throw new Exception();
        }
        BrandResponse respuesta = new BrandResponse();
        Brand brand = new Brand();
        brand.setId(idBrand);
        brandRepository.delete(brand);
        respuesta.setBrandTrabajada(brand);
        return respuesta;
    }
}
