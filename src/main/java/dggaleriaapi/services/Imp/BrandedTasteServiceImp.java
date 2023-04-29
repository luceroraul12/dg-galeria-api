package dggaleriaapi.services.Imp;

import dggaleriaapi.models.BrandHasTaste;
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
    public StockDataResponse<BrandHasTaste> getAll() {
        StockDataResponse<BrandHasTaste> respuesta = new StockDataResponse<BrandHasTaste>();
        respuesta.setStockDataResult(
                brandedTasteRepository.findAll()
        );
        return respuesta;
    }

    @Override
    public StockDataResponse<BrandHasTaste> getAllByIdBrand(BrandHasTaste brandHasTaste) throws Exception {
        if (!brandedTasteRepository.existByIdBrand(brandHasTaste.getId())){
            throw new Exception();
        }
        StockDataResponse<BrandHasTaste> respuesta = new StockDataResponse<BrandHasTaste>();
        respuesta.setStockDataResult(
                brandedTasteRepository.findByBrandId(brandHasTaste.getId())
        );
        return respuesta;
    }

    @Override
    public StockDataResponse<BrandHasTaste> save(BrandHasTaste brandHasTaste) throws Exception {
        boolean esBrandRegistrada = brandRepository.existsById(brandHasTaste.getBrand().getId());
        boolean esTasteYaAsociado = brandedTasteRepository.existsByBrand_IdAndTaste_Id(brandHasTaste.getBrand().getId(), brandHasTaste.getTaste().getId());
        if (!esBrandRegistrada | esTasteYaAsociado){
            throw new Exception();
        }
        StockDataResponse<BrandHasTaste> respuesta = new StockDataResponse<BrandHasTaste>();
        respuesta.setStockDataResult(
                List.of(brandedTasteRepository.save(brandHasTaste))
        );
        return respuesta;
    }

    @Override
    public StockDataResponse<BrandHasTaste> savePorMonton(List<BrandHasTaste> brandedtastees) throws Exception {
        if (brandedtastees == null){
            throw new Exception();
        }
        brandedtastees.removeIf(item -> brandedTasteRepository.existsByBrand_IdAndTaste_Id(
                item.getBrand().getId(),
                item.getTaste().getId()
        ));
        StockDataResponse<BrandHasTaste> respuesta = new StockDataResponse<BrandHasTaste>();
        respuesta.setStockDataResult(
                brandedTasteRepository.saveAll(brandedtastees)
        );
        return respuesta;
    }

    @Override
    public StockDataResponse<BrandHasTaste> update(BrandHasTaste brandHasTaste) throws Exception {
        boolean esBrandedTasteExistente = brandedTasteRepository.isExistWithoutChanges(
                brandHasTaste.getId(),
                brandHasTaste.getBrand().getId(),
                brandHasTaste.getTaste().getId(),
                brandHasTaste.getIsStocked()
        );
        if (esBrandedTasteExistente){
            throw new Exception();
        }
        StockDataResponse<BrandHasTaste> respuesta = new StockDataResponse<BrandHasTaste>();
        respuesta.setStockDataResult(
                List.of(brandedTasteRepository.save(brandHasTaste))
        );
        return respuesta;
    }

    @Override
    public StockDataResponse<BrandHasTaste> changeStockState(BrandHasTaste brandHasTaste) throws Exception {
        StockDataResponse<BrandHasTaste> respuesta = new StockDataResponse<BrandHasTaste>();
        brandedTasteRepository.changeStockState(
                brandHasTaste.getIsStocked(),
                brandHasTaste.getId()
        );
        respuesta.setStockDataResult(
                List.of(brandedTasteRepository.save(brandHasTaste))
        );
        return respuesta;
    }

    @Override
    public StockDataResponse<BrandHasTaste> delete(BrandHasTaste brandHasTaste) throws Exception {
        if (!/**/brandedTasteRepository.existsById(brandHasTaste.getId())){
            throw new Exception();
        }
        StockDataResponse<BrandHasTaste> respuesta = new StockDataResponse<BrandHasTaste>();
        brandedTasteRepository.deleteById(brandHasTaste.getId());
        respuesta.setStockDataResult(
                List.of(brandHasTaste)
        );
        return respuesta;
    }
}
