package dggaleriaapi.services.Imp;

import dggaleriaapi.models.SaborAsociado;
import dggaleriaapi.repositories.MarcaRepository;
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
    MarcaRepository marcaRepository;

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
    public SaborAsociadoResponse getAllByIdMarca(Long idMarca) throws Exception {
        if (!saborAsociadoRepository.existByIdMarca(idMarca)){
            throw new Exception();
        }
        SaborAsociadoResponse respuesta = new SaborAsociadoResponse();
        respuesta.setSaboresAsociadosTrabajados(
            saborAsociadoRepository.findByMarca_Id(idMarca)
        );
        return respuesta;
    }

    @Override
    public SaborAsociadoResponse save(SaborAsociado saborAsociado) throws Exception {
        boolean esMarcaRegistrada = marcaRepository.existsById(saborAsociado.getMarca().getId());
        boolean esSaborYaAsociado = saborAsociadoRepository.existsByMarca_IdAndSabor_Id(saborAsociado.getMarca().getId(),saborAsociado.getSabor().getId());
        if (!esMarcaRegistrada | esSaborYaAsociado){
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
        boolean esSaborAsociadoExistente = saborAsociadoRepository.existsByMarca_IdAndSabor_Id(
                saborAsociado.getMarca().getId(),
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
