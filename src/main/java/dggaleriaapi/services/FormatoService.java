package dggaleriaapi.services;

import dggaleriaapi.models.Formato;
import dggaleriaapi.responses.FormatoResponse;
import org.springframework.stereotype.Service;

@Service
public interface FormatoService {

    FormatoResponse getAllFormatos();
    FormatoResponse saveFormato(String tipo);

    FormatoResponse updateFormato(Formato formato) throws Exception;

    FormatoResponse deleteFormato(Long idFormato) throws Exception;
}
