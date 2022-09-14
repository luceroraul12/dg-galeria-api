package dggaleriaapi.dto;

import dggaleriaapi.models.Brand;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CustomerDTO {
    private Brand brandElegida;
    private List<TasteResumenDTO> tasteesResumidos;
}
