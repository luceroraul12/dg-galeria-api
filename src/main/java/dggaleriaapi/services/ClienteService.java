package dggaleriaapi.services;

import dggaleriaapi.models.Marca;
import dggaleriaapi.responses.ClienteDTOResponse;
import org.springframework.stereotype.Service;

@Service
public interface ClienteService {

    ClienteDTOResponse obtenerResumenPorMarca(Marca marca);
}
