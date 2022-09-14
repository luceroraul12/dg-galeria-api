package dggaleriaapi.services;

import dggaleriaapi.models.Brand;
import dggaleriaapi.responses.CustomerDTOResponse;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

    CustomerDTOResponse obtenerResumenPorBrand(Brand brand);
}
