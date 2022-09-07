package dggaleriaapi.services;

import dggaleriaapi.models.Sabor;
import dggaleriaapi.responses.GaleriaResponse;

public interface SaborService {

    GaleriaResponse getAllByIdMarca(Long idMarca);
    GaleriaResponse getAllByIdMarcayStock(Long idMarca);
    GaleriaResponse saveSabor(Sabor sabor);
}
