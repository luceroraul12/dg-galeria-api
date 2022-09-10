package dggaleriaapi.dto;

import dggaleriaapi.models.Marca;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ClienteDTO {
    private Marca marcaElegida;
    private List<SaborResumenDTO> saboresResumidos;
}
