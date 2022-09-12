package dggaleriaapi.responses;

import dggaleriaapi.dto.ClienteDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTOResponse {
    private ClienteDTO resumen;
    private String mensaje;
}
