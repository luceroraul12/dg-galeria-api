package dggaleriaapi.services.Imp;

import dggaleriaapi.models.Sabor;
import dggaleriaapi.repositories.SaborRepository;
import dggaleriaapi.responses.GaleriaResponse;
import dggaleriaapi.services.SaborService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaborServiceImp implements SaborService {

    @Autowired
    SaborRepository saborRepository;

    @Override
    public GaleriaResponse getAll() {
        GaleriaResponse respuesta = new GaleriaResponse();
        respuesta.setSabores

        return null;
    }

    @Override
    public GaleriaResponse save(String nombre) {
        return null;
    }

    @Override
    public GaleriaResponse update(Sabor sabor) {
        return null;
    }

    @Override
    public GaleriaResponse delete(Sabor sabor) {
        return null;
    }
}
