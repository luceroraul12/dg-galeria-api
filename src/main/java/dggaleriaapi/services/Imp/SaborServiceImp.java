package dggaleriaapi.services.Imp;

import dggaleriaapi.models.Sabor;
import dggaleriaapi.repositories.SaborRepository;
import dggaleriaapi.responses.GaleriaResponse;
import dggaleriaapi.services.SaborService;
import org.springframework.beans.factory.annotation.Autowired;

public class SaborServiceImp implements SaborService {

    @Autowired
    SaborRepository saborRepository;

    public SaborServiceImp(SaborRepository saborRepository) {
        this.saborRepository = saborRepository;
    }

    @Override
    public GaleriaResponse getAllByIdMarca(Long idMarca) {
        GaleriaResponse resultado = new GaleriaResponse();
        resultado.setSaboresCreados(
            saborRepository.findByMarca_Id(idMarca)
        );
        return resultado;
    }

    @Override
    public GaleriaResponse getAllByIdMarcayStock(Long idMarca) {
        GaleriaResponse resultado = new GaleriaResponse();
        resultado.setSaboresDisponibles(
                saborRepository.getAllByIdMacaryStock(idMarca)
        );
        return resultado;
    }

    @Override
    public GaleriaResponse saveSabor(Sabor sabor) {
        GaleriaResponse resultado = new GaleriaResponse();
        resultado.setSaboresTrabajado(
                saborRepository.save(sabor)
        );
        return resultado;
    }
}
