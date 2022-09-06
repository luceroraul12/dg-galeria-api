package dggaleriaapi.services;

import dggaleriaapi.responses.GaleriaResponse;
import org.springframework.stereotype.Service;

@Service
public interface MarcaService {

    GaleriaResponse getAll();
    GaleriaResponse getById();
    GaleriaResponse saveMarca();
}
