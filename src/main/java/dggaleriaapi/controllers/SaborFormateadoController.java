package dggaleriaapi.controllers;

import dggaleriaapi.models.SaborFormateado;
import dggaleriaapi.responses.SaborFormateadoResponse;
import dggaleriaapi.services.SaborFormateadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SaborFormateadoController {

    @Autowired
    SaborFormateadoService saborFormateadoService;

    public SaborFormateadoResponse getAll() {
        return saborFormateadoService.getAll();
    }

    public SaborFormateadoResponse getBySaborAsociadoId(SaborFormateado saborFormateado) {
        return saborFormateadoService.getBySaborAsociadoId(saborFormateado);
    }

    public SaborFormateadoResponse save(SaborFormateado saborFormateado) {
        return saborFormateadoService.save(saborFormateado);
    }

    public SaborFormateadoResponse saveInicial(SaborFormateado saborFormateado) {
        return saborFormateadoService.saveInicial(saborFormateado);
    }

    public SaborFormateadoResponse savePorMonton(List<SaborFormateado> saboresFormateados) {
        return saborFormateadoService.savePorMonton(saboresFormateados);
    }

    public SaborFormateadoResponse savePorMontonInicial(List<SaborFormateado> saboresFormateados) {
        return saborFormateadoService.savePorMontonInicial(saboresFormateados);
    }

    public SaborFormateadoResponse update(SaborFormateado saborFormateado) {
        return saborFormateadoService.update(saborFormateado);
    }

    public SaborFormateadoResponse delete(SaborFormateado saborFormateado) {
        return saborFormateadoService.delete(saborFormateado);
    }
}
