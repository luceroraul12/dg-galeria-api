package dggaleriaapi.controllers;

import dggaleriaapi.models.Sabor;
import dggaleriaapi.responses.SaborResponse;
import dggaleriaapi.services.SaborService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SaborController {

    @Autowired
    SaborService saborService;

    public SaborResponse getAll() {
        return saborService.getAll();
    }

    public SaborResponse save(Sabor sabor) {
        return saborService.save(sabor);
    }

    public SaborResponse savePorMonton(List<Sabor> sabores) {
        return saborService.savePorMonton(sabores);
    }

    public SaborResponse update(Sabor sabor) {
        return saborService.update(sabor);
    }

    public SaborResponse delete(Sabor sabor) {
        return saborService.delete(sabor);
    }
}
