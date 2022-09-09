package dggaleriaapi.controllers;

import dggaleriaapi.models.SaborAsociado;
import dggaleriaapi.responses.SaborAsociadoResponse;
import dggaleriaapi.services.SaborAsociadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SaborAsociadoController {

    @Autowired
    SaborAsociadoService saborAsociadoService;

    public SaborAsociadoResponse getAll() {
        return saborAsociadoService.getAll();
    }

    public SaborAsociadoResponse getAllByIdMarca(Long idMarca) {
        return saborAsociadoService.getAllByIdMarca(idMarca);
    }

    public SaborAsociadoResponse save(SaborAsociado saborAsociado) {
        return saborAsociadoService.save(saborAsociado);
    }

    public SaborAsociadoResponse savePorMonton(List<SaborAsociado> saboresAsociados) {
        return saborAsociadoService.savePorMonton(saboresAsociados);
    }

    public SaborAsociadoResponse update(SaborAsociado saborAsociado) {
        return saborAsociadoService.update(saborAsociado);
    }

    public SaborAsociadoResponse delete(SaborAsociado saborAsociado) {
        return saborAsociadoService.delete(saborAsociado);
    }
}
