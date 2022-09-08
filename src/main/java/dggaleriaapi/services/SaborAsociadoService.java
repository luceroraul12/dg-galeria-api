package dggaleriaapi.services;

import dggaleriaapi.models.SaborAsociado;
import dggaleriaapi.responses.SaborAsociadoResponse;

import java.util.List;

public interface SaborAsociadoService {

    SaborAsociadoResponse getAllByIdMarca(Long idMarca);
    SaborAsociadoResponse save(SaborAsociado saborAsociado);
    SaborAsociadoResponse savePorMonton(List<SaborAsociado> saboresAsociados);

    SaborAsociadoResponse update(SaborAsociado saborAsociado);

    SaborAsociadoResponse delete(SaborAsociado saborAsociado);

}
