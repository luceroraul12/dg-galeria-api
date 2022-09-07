package dggaleriaapi.services;

import dggaleriaapi.models.Formato;
import dggaleriaapi.responses.GaleriaResponse;
import org.springframework.stereotype.Service;

@Service
public interface FormatoService {

    GaleriaResponse getAllFormatos();
    GaleriaResponse saveFormato(String tipo);

    GaleriaResponse updateFormato(Formato formato);

    GaleriaResponse deleteFormato(Long idFormato);
}
