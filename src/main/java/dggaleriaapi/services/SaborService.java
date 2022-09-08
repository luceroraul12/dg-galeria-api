package dggaleriaapi.services;

import dggaleriaapi.models.SaborAsociado;
import dggaleriaapi.responses.GaleriaResponse;

public interface SaborService {

    GaleriaResponse getAllByIdMarca(Long idMarca);
    GaleriaResponse getAllByIdMarcaParaVer(Long idMarca);
    GaleriaResponse getAllByIdMarcayStock(Long idMarca);
    GaleriaResponse saveSabor(SaborAsociado saborAsociado);

    GaleriaResponse updateSabor(SaborAsociado saborAsociado);

    GaleriaResponse deleteSabor(SaborAsociado saborAsociado);

}
