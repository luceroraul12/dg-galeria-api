package dggaleriaapi.controllers;

import dggaleriaapi.models.Marca;
import dggaleriaapi.responses.MarcaResponse;
import dggaleriaapi.services.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarcaController {

    @Autowired
    MarcaService marcaService;

    public MarcaResponse getAll() {
        return marcaService.getAll();
    }

    public MarcaResponse getMarcaById(Long idMarca) {
        return marcaService.getMarcaById(idMarca);
    }

    public MarcaResponse saveMarca(Marca marca) {
        return marcaService.saveMarca(marca);
    }

    public MarcaResponse updateMarca(Marca marca) {
        return marcaService.updateMarca(marca);
    }

    public MarcaResponse deleteMarca(Long idMarca) {
        return marcaService.deleteMarca(idMarca);
    }
}
