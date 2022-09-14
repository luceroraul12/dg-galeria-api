package dggaleriaapi.services.Imp;

import dggaleriaapi.models.TasteAsociado;
import dggaleriaapi.repositories.BrandRepository;
import dggaleriaapi.repositories.TasteAsociadoRepository;
import dggaleriaapi.responses.TasteAsociadoResponse;
import dggaleriaapi.services.TasteAsociadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TasteAsociadoServiceImp implements TasteAsociadoService {

    @Autowired
    TasteAsociadoRepository tasteAsociadoRepository;

    @Autowired
    BrandRepository brandRepository;

    public TasteAsociadoServiceImp(TasteAsociadoRepository tasteAsociadoRepository) {
        this.tasteAsociadoRepository = tasteAsociadoRepository;
    }

    @Override
    public TasteAsociadoResponse getAll() {
        TasteAsociadoResponse respuesta = new TasteAsociadoResponse();
        respuesta.setTasteesAsociadosTrabajados(
                tasteAsociadoRepository.findAll()
        );
        return respuesta;
    }

    @Override
    public TasteAsociadoResponse getAllByIdBrand(Long idBrand) throws Exception {
        if (!tasteAsociadoRepository.existByIdBrand(idBrand)){
            throw new Exception();
        }
        TasteAsociadoResponse respuesta = new TasteAsociadoResponse();
        respuesta.setTasteesAsociadosTrabajados(
            tasteAsociadoRepository.findByBrand_Id(idBrand)
        );
        return respuesta;
    }

    @Override
    public TasteAsociadoResponse save(TasteAsociado tasteAsociado) throws Exception {
        boolean esBrandRegistrada = brandRepository.existsById(tasteAsociado.getBrand().getId());
        boolean esTasteYaAsociado = tasteAsociadoRepository.existsByBrand_IdAndTaste_Id(tasteAsociado.getBrand().getId(),tasteAsociado.getTaste().getId());
        if (!esBrandRegistrada | esTasteYaAsociado){
            throw new Exception();
        }
        TasteAsociadoResponse respuesta = new TasteAsociadoResponse();
        respuesta.setTasteTrabajado(
                tasteAsociadoRepository.save(tasteAsociado)
        );
        return respuesta;
    }

    @Override
    public TasteAsociadoResponse savePorMonton(List<TasteAsociado> tasteesAsociados) throws Exception {
        if (tasteesAsociados == null){
            throw new Exception();
        }
        TasteAsociadoResponse respuesta = new TasteAsociadoResponse();
        respuesta.setTasteesAsociadosTrabajados(
                tasteAsociadoRepository.saveAll(tasteesAsociados)
        );
        return respuesta;
    }

    @Override
    public TasteAsociadoResponse update(TasteAsociado tasteAsociado) throws Exception {
        boolean esTasteAsociadoExistente = tasteAsociadoRepository.existsByBrand_IdAndTaste_Id(
                tasteAsociado.getBrand().getId(),
                tasteAsociado.getTaste().getId()
        );
        if (esTasteAsociadoExistente){
            throw new Exception();
        }
        TasteAsociadoResponse respuesta = new TasteAsociadoResponse();
        respuesta.setTasteTrabajado(
                tasteAsociadoRepository.save(tasteAsociado)
        );
        return respuesta;
    }

    @Override
    public TasteAsociadoResponse delete(TasteAsociado tasteAsociado) throws Exception {
        if (!/**/tasteAsociadoRepository.existsById(tasteAsociado.getId())){
            throw new Exception();
        }
        TasteAsociadoResponse respuesta = new TasteAsociadoResponse();
        tasteAsociadoRepository.delete(tasteAsociado);

        respuesta.setTasteTrabajado(tasteAsociado);
        return respuesta;
    }
}
