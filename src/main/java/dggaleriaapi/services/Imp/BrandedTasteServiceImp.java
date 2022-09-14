package dggaleriaapi.services.Imp;

import dggaleriaapi.models.BrandedTaste;
import dggaleriaapi.repositories.BrandRepository;
import dggaleriaapi.repositories.BrandedTasteRepository;
import dggaleriaapi.responses.BrandedTasteResponse;
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
    public BrandedTasteResponse getAll() {
        BrandedTasteResponse respuesta = new BrandedTasteResponse();
        respuesta.setTasteesAsociadosTrabajados(
                brandedTasteRepository.findAll()
        );
        return respuesta;
    }

    @Override
    public BrandedTasteResponse getAllByIdBrand(Long idBrand) throws Exception {
        if (!brandedTasteRepository.existByIdBrand(idBrand)){
            throw new Exception();
        }
        BrandedTasteResponse respuesta = new BrandedTasteResponse();
        respuesta.setTasteesAsociadosTrabajados(
            brandedTasteRepository.findByBrand_Id(idBrand)
        );
        return respuesta;
    }

    @Override
    public BrandedTasteResponse save(BrandedTaste brandedTaste) throws Exception {
        boolean esBrandRegistrada = brandRepository.existsById(brandedTaste.getBrand().getId());
        boolean esTasteYaAsociado = brandedTasteRepository.existsByBrand_IdAndTaste_Id(brandedTaste.getBrand().getId(),brandedTaste.getTaste().getId());
        if (!esBrandRegistrada | esTasteYaAsociado){
            throw new Exception();
        }
        BrandedTasteResponse respuesta = new BrandedTasteResponse();
        respuesta.setTasteTrabajado(
                brandedTasteRepository.save(brandedTaste)
        );
        return respuesta;
    }

    @Override
    public BrandedTasteResponse savePorMonton(List<BrandedTaste> tasteesAsociados) throws Exception {
        if (tasteesAsociados == null){
            throw new Exception();
        }
        BrandedTasteResponse respuesta = new BrandedTasteResponse();
        respuesta.setTasteesAsociadosTrabajados(
                brandedTasteRepository.saveAll(tasteesAsociados)
        );
        return respuesta;
    }

    @Override
    public BrandedTasteResponse update(BrandedTaste brandedTaste) throws Exception {
        boolean esBrandedTasteExistente = brandedTasteRepository.existsByBrand_IdAndTaste_Id(
                brandedTaste.getBrand().getId(),
                brandedTaste.getTaste().getId()
        );
        if (esBrandedTasteExistente){
            throw new Exception();
        }
        BrandedTasteResponse respuesta = new BrandedTasteResponse();
        respuesta.setTasteTrabajado(
                brandedTasteRepository.save(brandedTaste)
        );
        return respuesta;
    }

    @Override
    public BrandedTasteResponse delete(BrandedTaste brandedTaste) throws Exception {
        if (!/**/brandedTasteRepository.existsById(brandedTaste.getId())){
            throw new Exception();
        }
        BrandedTasteResponse respuesta = new BrandedTasteResponse();
        brandedTasteRepository.delete(brandedTaste);

        respuesta.setTasteTrabajado(brandedTaste);
        return respuesta;
    }
}
