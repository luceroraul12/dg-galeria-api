package dggaleriaapi.services;

import dggaleriaapi.models.Formato;
import dggaleriaapi.responses.FormatoResponse;
import org.springframework.stereotype.Service;

@Service
public interface FormatoService {

    FormatoResponse getAllFormatos();
    FormatoResponse saveFormato(String tipo);

    FormatoResponse updateFormato(Formato formato);

    FormatoResponse deleteFormato(Long idFormato);
}
