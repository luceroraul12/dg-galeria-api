package dggaleriaapi.controllers;

import dggaleriaapi.responses.GaleriaResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/galeria")
public class GaleriaBebidasController {

    @GetMapping(name = "/formatos")
    public ResponseEntity<GaleriaResponse> getAllFormatos(){
        return null;
    }

    @PostMapping(name = "/formatos")
    public ResponseEntity<GaleriaResponse> saveFormato(String tipo){
        return null;
    }

    @GetMapping(name = "/marcas")
    public ResponseEntity<GaleriaResponse> getAllMarcas(){
        return null;
    }

    @PostMapping(name = "/marcas")
    public ResponseEntity<GaleriaResponse> saveMarca(String nombre){
        return null;
    }

    @GetMapping(name = "/sabores")
    public ResponseEntity<GaleriaResponse> getAllSaboresByIdMarca(){
        return null;
    }

    @GetMapping(name = "/sabores/")
    public ResponseEntity<GaleriaResponse> getAllSaboresByIdMarcayEnStock() {
        return null;
    }

    @PostMapping(name = "/sabores")
    public ResponseEntity<GaleriaResponse> saveSaborByIdMarca(String tipo){
        return null;
    }
}
