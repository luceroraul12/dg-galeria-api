package dggaleriaapi.responses;

import dggaleriaapi.models.Brand;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BrandResponse {
    private Brand brandTrabajada;
    private List<Brand> brandsTrabajadas;
    private String mensaje;

}
