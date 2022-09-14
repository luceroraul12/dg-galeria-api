package dggaleriaapi.services.Imp;

import dggaleriaapi.models.SaborAsociado;
import dggaleriaapi.repositories.BrandRepository;
import dggaleriaapi.repositories.SaborAsociadoRepository;
import dggaleriaapi.responses.SaborAsociadoResponse;
import dggaleriaapi.services.SaborAsociadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaborAsociadoServiceImp implements SaborAsociadoService {

    @Autowired
    SaborAsociadoRepository saborAsociadoRepository;

    @Autowired
    BrandRepository brandRepository;

    public SaborAsociadoServiceImp(SaborAsociadoRepository saborAsociadoRepository) {
        this.saborAsociadoRepository = saborAsociadoRepository;
    }

    @Override
    public SaborAsociadoResponse getAll() {
        SaborAsociadoResponse respuesta = new SaborAsociadoResponse();
        respuesta.setSaboresAsociadosTrabajados(
                saborAsociadoRepository.findAll()
        );
        return respuesta;
    }

    @Override
    public SaborAsociadoResponse getAllByIdBrand(Long idBrand) throws Exception {
        if (!saborAsociadoRepository.existByIdBrand(idBrand)){
            throw new Exception();
        }
        SaborAsociadoResponse respuesta = new SaborAsociadoResponse();
        respuesta.setSaboresAsociadosTrabajados(
            saborAsociadoRepository.findByBrand_Id(idBrand)
        );
        return respuesta;
    }

    @Override
    public SaborAsociadoResponse save(SaborAsociado saborAsociado) throws Exception {
        boolean esBrandRegistrada = brandRepository.existsById(saborAsociado.getBrand().getId());
        boolean esSaborYaAsociado = saborAsociadoRepository.existsByBrand_IdAndSabor_Id(saborAsociado.getBrand().getId(),saborAsociado.getSabor().getId());
        if (!esBrandRegistrada | esSaborYaAsociado){
            throw new Exception();
        }
        SaborAsociadoResponse respuesta = new SaborAsociadoResponse();
        respuesta.setSaborTrabajado(
                saborAsociadoRepository.save(saborAsociado)
        );
        return respuesta;
    }

    @Override
    public SaborAsociadoResponse savePorMonton(List<SaborAsociado> saboresAsociados) throws Exception {
        if (saboresAsociados == null){
            throw new Exception();
        }
        SaborAsociadoResponse respuesta = new SaborAsociadoResponse();
        respuesta.setSaboresAsociadosTrabajados(
                saborAsociadoRepository.saveAll(saboresAsociados)
        );
        return respuesta;
    }

    @Override
    public SaborAsociadoResponse update(SaborAsociado saborAsociado) throws Exception {
        boolean esSaborAsociadoExistente = saborAsociadoRepository.existsByBrand_IdAndSabor_Id(
                saborAsociado.getBrand().getId(),
                saborAsociado.getSabor().getId()
        );
        if (esSaborAsociadoExistente){
            throw new Exception();
        }
        SaborAsociadoResponse respuesta = new SaborAsociadoResponse();
        respuesta.setSaborTrabajado(
                saborAsociadoRepository.save(saborAsociado)
        );
        return respuesta;
    }

    @Override
    public SaborAsociadoResponse delete(SaborAsociado saborAsociado) throws Exception {
        if (!/**/saborAsociadoRepository.existsById(saborAsociado.getId())){
            throw new Exception();
        }
        SaborAsociadoResponse respuesta = new SaborAsociadoResponse();
        saborAsociadoRepository.delete(saborAsociado);

        respuesta.setSaborTrabajado(saborAsociado);
        return respuesta;
    }
}
