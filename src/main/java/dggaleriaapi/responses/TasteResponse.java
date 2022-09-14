package dggaleriaapi.responses;

import dggaleriaapi.models.Taste;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TasteResponse {
    private List<Taste> tasteesTrabajados;
    private Taste tasteTrabajado;
    private String mensaje;

}
