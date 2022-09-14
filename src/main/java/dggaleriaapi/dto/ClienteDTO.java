package dggaleriaapi.dto;

import dggaleriaapi.models.Brand;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ClienteDTO {
    private Brand brandElegida;
    private List<TasteResumenDTO> tasteesResumidos;
}
