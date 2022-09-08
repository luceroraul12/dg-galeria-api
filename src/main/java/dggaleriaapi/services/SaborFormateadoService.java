package dggaleriaapi.services;

import dggaleriaapi.models.SaborFormateado;
import dggaleriaapi.responses.SaborFormateadoResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SaborFormateadoService {

    SaborFormateadoResponse getAll();

    SaborFormateadoResponse getBySaborAsociadoId();

    SaborFormateadoResponse save(SaborFormateado saborFormateado);

    SaborFormateadoResponse saveInicial(SaborFormateado saborFormateado);

    SaborFormateadoResponse savePorMonton(List<SaborFormateado> saboresFormateados);

    SaborFormateadoResponse savePorMontonInicial(List<SaborFormateado> saboresFormateados);

    SaborFormateadoResponse update(SaborFormateado saborFormateado);

    SaborFormateadoResponse delete(SaborFormateado saborFormateado);
}
