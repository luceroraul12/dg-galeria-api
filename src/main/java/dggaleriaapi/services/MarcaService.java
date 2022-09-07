package dggaleriaapi.services;

import dggaleriaapi.models.Marca;
import dggaleriaapi.responses.GaleriaResponse;
import org.springframework.stereotype.Service;

@Service
public interface MarcaService {

    GaleriaResponse getAll();
    GaleriaResponse getMarcaById(Long id);
    GaleriaResponse saveMarca(Marca marca);
    GaleriaResponse updateMarca(Marca marca);
    GaleriaResponse deleteMarca(Long idMarca);

}
