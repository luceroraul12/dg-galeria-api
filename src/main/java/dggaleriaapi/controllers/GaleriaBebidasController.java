package dggaleriaapi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/galeria")
public class GaleriaBebidasController {

    @GetMapping(name = "/formatos")
    public ResponseEntity getAllFormatos(){
        return null;
    }

    @PostMapping(name = "/formatos")
    public ResponseEntity saveFormato(String tipo){
        return null;
    }

    @GetMapping(name = "/marcas")
    public ResponseEntity getAllMarcas(){
        return null;
    }

    @PostMapping(name = "/marcas")
    public ResponseEntity saveMarca(String nombre){
        return null;
    }

    @GetMapping(name = "/sabores")
    public ResponseEntity getAllSaboresByIdMarca(){
        return null;
    }

    @PostMapping(name = "/sabores")
    public ResponseEntity saveSaborByIdMarca(String tipo){
        return null;
    }
}
