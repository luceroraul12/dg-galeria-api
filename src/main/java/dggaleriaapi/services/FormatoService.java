package dggaleriaapi.services;

import dggaleriaapi.responses.GaleriaResponse;
import org.springframework.stereotype.Service;

@Service
public interface FormatoService {

    GaleriaResponse getAllFormatos();
    GaleriaResponse saveFormato(String tipo);
}
