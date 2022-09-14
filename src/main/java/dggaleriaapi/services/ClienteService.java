package dggaleriaapi.services;

import dggaleriaapi.models.Brand;
import dggaleriaapi.responses.ClienteDTOResponse;
import org.springframework.stereotype.Service;

@Service
public interface ClienteService {

    ClienteDTOResponse obtenerResumenPorBrand(Brand brand);
}
