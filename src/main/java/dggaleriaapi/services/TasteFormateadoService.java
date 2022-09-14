package dggaleriaapi.services;

import dggaleriaapi.models.TasteFormateado;
import dggaleriaapi.responses.TasteFormateadoResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TasteFormateadoService {

    TasteFormateadoResponse getAll();

    TasteFormateadoResponse getByBrandedTasteId(TasteFormateado tasteFormateado);

    TasteFormateadoResponse getAllByIdBrand(Long idBrand);

    TasteFormateadoResponse save(TasteFormateado tasteFormateado) throws Exception;

    TasteFormateadoResponse saveInicial(TasteFormateado tasteFormateado) throws Exception;

    TasteFormateadoResponse savePorMonton(List<TasteFormateado> tasteesFormateados) throws Exception;

    TasteFormateadoResponse savePorMontonInicial(List<TasteFormateado> tasteesFormateados) throws Exception;

    TasteFormateadoResponse update(TasteFormateado tasteFormateado) throws Exception;

    TasteFormateadoResponse delete(TasteFormateado tasteFormateado) throws Exception;
}
