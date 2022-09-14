package dggaleriaapi.services;

import dggaleriaapi.models.SaborAsociado;
import dggaleriaapi.responses.SaborAsociadoResponse;

import java.util.List;

public interface SaborAsociadoService {

    SaborAsociadoResponse getAll();
    SaborAsociadoResponse getAllByIdBrand(Long idBrand) throws Exception;
    SaborAsociadoResponse save(SaborAsociado saborAsociado) throws Exception;
    SaborAsociadoResponse savePorMonton(List<SaborAsociado> saboresAsociados) throws Exception;

    SaborAsociadoResponse update(SaborAsociado saborAsociado) throws Exception;

    SaborAsociadoResponse delete(SaborAsociado saborAsociado) throws Exception;

}
