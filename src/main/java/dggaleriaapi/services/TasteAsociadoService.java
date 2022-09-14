package dggaleriaapi.services;

import dggaleriaapi.models.TasteAsociado;
import dggaleriaapi.responses.TasteAsociadoResponse;

import java.util.List;

public interface TasteAsociadoService {

    TasteAsociadoResponse getAll();
    TasteAsociadoResponse getAllByIdBrand(Long idBrand) throws Exception;
    TasteAsociadoResponse save(TasteAsociado tasteAsociado) throws Exception;
    TasteAsociadoResponse savePorMonton(List<TasteAsociado> tasteesAsociados) throws Exception;

    TasteAsociadoResponse update(TasteAsociado tasteAsociado) throws Exception;

    TasteAsociadoResponse delete(TasteAsociado tasteAsociado) throws Exception;

}
