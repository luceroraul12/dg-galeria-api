package dggaleriaapi.services;

import dggaleriaapi.models.SaborFormateado;
import dggaleriaapi.responses.SaborFormateadoResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SaborFormateadoService {

    SaborFormateadoResponse getAll();

    SaborFormateadoResponse getBySaborAsociadoId(SaborFormateado saborFormateado);

    SaborFormateadoResponse getAllByIdBrand(Long idBrand);

    SaborFormateadoResponse save(SaborFormateado saborFormateado) throws Exception;

    SaborFormateadoResponse saveInicial(SaborFormateado saborFormateado) throws Exception;

    SaborFormateadoResponse savePorMonton(List<SaborFormateado> saboresFormateados) throws Exception;

    SaborFormateadoResponse savePorMontonInicial(List<SaborFormateado> saboresFormateados) throws Exception;

    SaborFormateadoResponse update(SaborFormateado saborFormateado) throws Exception;

    SaborFormateadoResponse delete(SaborFormateado saborFormateado) throws Exception;
}
