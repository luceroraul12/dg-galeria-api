package dggaleriaapi.services;

import dggaleriaapi.models.Marca;
import dggaleriaapi.responses.MarcaResponse;
import org.springframework.stereotype.Service;

@Service
public interface MarcaService {

    MarcaResponse getAll();

    MarcaResponse getMarcaById(Long idMarca);

    MarcaResponse saveMarca(Marca marca);
    MarcaResponse updateMarca(Marca marca);
    MarcaResponse deleteMarca(Long idMarca);


}
