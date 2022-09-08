package dggaleriaapi.services.Imp;

import dggaleriaapi.models.SaborAsociado;
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
    public SaborAsociadoResponse getAllByIdMarca(Long idMarca) {
        SaborAsociadoResponse respuesta = new SaborAsociadoResponse();
        respuesta.setSaboresAsociadosTrabajados(
            saborAsociadoRepository.findByMarca_Id(idMarca)
        );
        return respuesta;
    }

    @Override
    public SaborAsociadoResponse save(SaborAsociado saborAsociado) {
        SaborAsociadoResponse respuesta = new SaborAsociadoResponse();
        respuesta.setSaborTrabajado(
                saborAsociadoRepository.save(saborAsociado)
        );
        return respuesta;
    }

    @Override
    public SaborAsociadoResponse savePorMonton(List<SaborAsociado> saboresAsociados) {
        SaborAsociadoResponse respuesta = new SaborAsociadoResponse();
        respuesta.setSaboresAsociadosTrabajados(
                saborAsociadoRepository.saveAll(saboresAsociados)
        );
        return respuesta;
    }

    @Override
    public SaborAsociadoResponse update(SaborAsociado saborAsociado) {
        SaborAsociadoResponse respuesta = new SaborAsociadoResponse();
        respuesta.setSaborTrabajado(
                saborAsociadoRepository.save(saborAsociado)
        );
        return respuesta;
    }

    @Override
    public SaborAsociadoResponse delete(SaborAsociado saborAsociado) {
        SaborAsociadoResponse respuesta = new SaborAsociadoResponse();
        saborAsociadoRepository.delete(saborAsociado);

        respuesta.setSaborTrabajado(saborAsociado);
        return respuesta;
    }
}
