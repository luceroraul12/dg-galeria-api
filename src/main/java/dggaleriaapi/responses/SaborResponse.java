package dggaleriaapi.responses;

import dggaleriaapi.models.Sabor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SaborResponse {
    private List<Sabor> saboresTrabajados;
    private Sabor saborTrabajado;
    private String mensaje;

}
