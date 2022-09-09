package dggaleriaapi.services;

import dggaleriaapi.models.Marca;
import dggaleriaapi.responses.MarcaResponse;
import org.springframework.stereotype.Service;

@Service
public interface MarcaService {

    MarcaResponse getAll();

    MarcaResponse getMarcaById(Long idMarca) throws Exception;

    MarcaResponse saveMarca(Marca marca) throws Exception;
    MarcaResponse updateMarca(Marca marca) throws Exception;
    MarcaResponse deleteMarca(Long idMarca) throws Exception;


}
