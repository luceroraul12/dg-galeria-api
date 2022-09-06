package dggaleriaapi.services;

import dggaleriaapi.models.Sabor;
import dggaleriaapi.responses.GaleriaResponse;

public interface SaborService {

    GaleriaResponse getAllByIdMarca();
    GaleriaResponse getAllByIdMarcayStock();
    GaleriaResponse saveSabor(Sabor sabor);
}
