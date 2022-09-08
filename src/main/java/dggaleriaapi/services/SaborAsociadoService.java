package dggaleriaapi.services;

import dggaleriaapi.models.SaborAsociado;
import dggaleriaapi.responses.GaleriaResponse;
import dggaleriaapi.responses.SaborAsociadoResponse;

public interface SaborAsociadoService {

    SaborAsociadoResponse getAllByIdMarca(Long idMarca);
    SaborAsociadoResponse saveSabor(SaborAsociado saborAsociado);

    SaborAsociadoResponse updateSabor(SaborAsociado saborAsociado);

    SaborAsociadoResponse deleteSabor(SaborAsociado saborAsociado);

}
