package dggaleriaapi.responses;

import dggaleriaapi.dto.CustomerDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTOResponse {
    private CustomerDTO customerResult;
    private String message;
}
