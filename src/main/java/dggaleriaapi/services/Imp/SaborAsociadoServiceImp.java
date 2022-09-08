package dggaleriaapi.services.Imp;

import dggaleriaapi.models.SaborAsociado;
import dggaleriaapi.repositories.SaborAsociadoRepository;
import dggaleriaapi.responses.GaleriaResponse;
import dggaleriaapi.services.SaborAsociadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaborAsociadoServiceImp implements SaborAsociadoService {

    @Autowired
    SaborAsociadoRepository saborAsociadoRepository;

    public SaborAsociadoServiceImp(SaborAsociadoRepository saborAsociadoRepository) {
        this.saborAsociadoRepository = saborAsociadoRepository;
    }

    @Override
    public GaleriaResponse getAllByIdMarca(Long idMarca) {
        GaleriaResponse resultado = new GaleriaResponse();
        resultado.setSaboresCreados(
            saborAsociadoRepository.findByMarca_Id(idMarca)
        );
        return resultado;
    }

    @Override
    public GaleriaResponse saveSabor(SaborAsociado saborAsociado) {
        GaleriaResponse resultado = new GaleriaResponse();
        resultado.setSaborAsociadoTrabajado(
                saborAsociadoRepository.save(saborAsociado)
        );
        return resultado;
    }

    @Override
    public GaleriaResponse updateSabor(SaborAsociado saborAsociado) {
        GaleriaResponse resultado = new GaleriaResponse();
        resultado.setSaborAsociadoTrabajado(
                saborAsociadoRepository.save(saborAsociado)
        );
        return resultado;
    }

    @Override
    public GaleriaResponse deleteSabor(SaborAsociado saborAsociado) {
        GaleriaResponse resultado = new GaleriaResponse();
        saborAsociadoRepository.delete(saborAsociado);

        resultado.setSaborAsociadoTrabajado(saborAsociado);
        return resultado;
    }
}
