package dggaleriaapi.services.Imp;

import dggaleriaapi.models.BrandedTaste;
import dggaleriaapi.repositories.BrandRepository;
import dggaleriaapi.repositories.BrandedTasteRepository;
import dggaleriaapi.responses.StockDataResponse;
import dggaleriaapi.services.BrandedTasteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandedTasteServiceImp implements BrandedTasteService {

    @Autowired
    BrandedTasteRepository brandedTasteRepository;

    @Autowired
    BrandRepository brandRepository;

    public BrandedTasteServiceImp(BrandedTasteRepository brandedTasteRepository) {
        this.brandedTasteRepository = brandedTasteRepository;
    }

    @Override
    public StockDataResponse<BrandedTaste> getAll() {
        StockDataResponse<BrandedTaste> respuesta = new StockDataResponse<BrandedTaste>();
        respuesta.setStockDataResult(
                brandedTasteRepository.findAll()
        );
        return respuesta;
    }

    @Override
    public StockDataResponse<BrandedTaste> getAllByIdBrand(BrandedTaste brandedTaste) throws Exception {
        if (!brandedTasteRepository.existByIdBrand(brandedTaste.getId())){
            throw new Exception();
        }
        StockDataResponse<BrandedTaste> respuesta = new StockDataResponse<BrandedTaste>();
        respuesta.setStockDataResult(
                brandedTasteRepository.findByBrand_Id(brandedTaste.getId())
        );
        return respuesta;
    }

    @Override
    public StockDataResponse<BrandedTaste> save(BrandedTaste brandedTaste) throws Exception {
        boolean esBrandRegistrada = brandRepository.existsById(brandedTaste.getBrand().getId());
        boolean esTasteYaAsociado = brandedTasteRepository.existsByBrand_IdAndTaste_Id(brandedTaste.getBrand().getId(),brandedTaste.getTaste().getId());
        if (!esBrandRegistrada | esTasteYaAsociado){
            throw new Exception();
        }
        StockDataResponse<BrandedTaste> respuesta = new StockDataResponse<BrandedTaste>();
        respuesta.setStockDataResult(
                List.of(brandedTasteRepository.save(brandedTaste))
        );
        return respuesta;
    }

    @Override
    public StockDataResponse<BrandedTaste> savePorMonton(List<BrandedTaste> brandedtastees) throws Exception {
        if (brandedtastees == null){
            throw new Exception();
        }
        brandedtastees.removeIf(item -> brandedTasteRepository.existsByBrand_IdAndTaste_Id(
                item.getBrand().getId(),
                item.getTaste().getId()
        ));
        StockDataResponse<BrandedTaste> respuesta = new StockDataResponse<BrandedTaste>();
        respuesta.setStockDataResult(
                brandedTasteRepository.saveAll(brandedtastees)
        );
        return respuesta;
    }

    @Override
    public StockDataResponse<BrandedTaste> update(BrandedTaste brandedTaste) throws Exception {
        boolean esBrandedTasteExistente = brandedTasteRepository.isExistWithoutChanges(
                brandedTaste.getId(),
                brandedTaste.getBrand().getId(),
                brandedTaste.getTaste().getId(),
                brandedTaste.getIsStocked()
        );
        if (esBrandedTasteExistente){
            throw new Exception();
        }
        StockDataResponse<BrandedTaste> respuesta = new StockDataResponse<BrandedTaste>();
        respuesta.setStockDataResult(
                List.of(brandedTasteRepository.save(brandedTaste))
        );
        return respuesta;
    }

    @Override
    public StockDataResponse<BrandedTaste> changeStockState(BrandedTaste brandedTaste) throws Exception {
        StockDataResponse<BrandedTaste> respuesta = new StockDataResponse<BrandedTaste>();
        brandedTasteRepository.changeStockState(
                brandedTaste.getIsStocked(),
                brandedTaste.getId()
        );
        respuesta.setStockDataResult(
                List.of(brandedTasteRepository.save(brandedTaste))
        );
        return respuesta;
    }

    @Override
    public StockDataResponse<BrandedTaste> delete(BrandedTaste brandedTaste) throws Exception {
        if (!/**/brandedTasteRepository.existsById(brandedTaste.getId())){
            throw new Exception();
        }
        StockDataResponse<BrandedTaste> respuesta = new StockDataResponse<BrandedTaste>();
        brandedTasteRepository.deleteById(brandedTaste.getId());
        respuesta.setStockDataResult(
                List.of(brandedTaste)
        );
        return respuesta;
    }
}
