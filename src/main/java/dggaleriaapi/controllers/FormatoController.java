package dggaleriaapi.controllers;

import dggaleriaapi.models.Formato;
import dggaleriaapi.responses.FormatoResponse;
import dggaleriaapi.services.FormatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FormatoController {

    @Autowired
    FormatoService formatoService;

    public FormatoResponse getAllFormatos() {
        return formatoService.getAllFormatos();
    }

    public FormatoResponse saveFormato(String tipo) {
        return formatoService.saveFormato(tipo);
    }

    public FormatoResponse updateFormato(Formato formato) {
        return formatoService.updateFormato(formato);
    }

    public FormatoResponse deleteFormato(Long idFormato) {
        return formatoService.deleteFormato(idFormato);
    }
}
