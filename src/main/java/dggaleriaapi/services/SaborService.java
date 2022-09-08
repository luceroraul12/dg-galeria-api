package dggaleriaapi.services;

import dggaleriaapi.models.Sabor;
import dggaleriaapi.responses.GaleriaResponse;
import org.springframework.stereotype.Service;

@Service
public interface SaborService {

    GaleriaResponse getAll();
    GaleriaResponse save(String nombre);
    GaleriaResponse update(Sabor sabor);
    GaleriaResponse delete(Sabor sabor);
}
