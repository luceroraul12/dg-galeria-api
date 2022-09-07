package dggaleriaapi.controllers;

import dggaleriaapi.responses.GaleriaResponse;
import dggaleriaapi.services.FormatoService;
import dggaleriaapi.services.MarcaService;
import dggaleriaapi.services.SaborService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/galeria")
public class GaleriaBebidasController {

    @Autowired
    private FormatoService formatoService;
    @Autowired
    private MarcaService marcaService;
    @Autowired
    private SaborService saborService;

    public GaleriaBebidasController(FormatoService formatoService, MarcaService marcaService, SaborService saborService) {
        this.formatoService = formatoService;
        this.marcaService = marcaService;
        this.saborService = saborService;
    }

    @GetMapping(name = "/formatos")
    public ResponseEntity<GaleriaResponse> getAllFormatos(){
        ResponseEntity<GaleriaResponse> respuesta;
        try {
            GaleriaResponse resultado = formatoService.getAllFormatos();
            respuesta = new ResponseEntity<GaleriaResponse>(resultado, HttpStatus.OK);
        } catch (Exception e) {
            respuesta = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @PostMapping(name = "/formatos")
    public ResponseEntity<GaleriaResponse> saveFormato(String tipo){
        return null;
    }

    @GetMapping(name = "/marcas")
    public ResponseEntity<GaleriaResponse> getAllMarcas(){
        ResponseEntity<GaleriaResponse> respuesta;
        try {
            GaleriaResponse resultado = marcaService.getAll();
            respuesta = new ResponseEntity<GaleriaResponse>(resultado, HttpStatus.OK);
        } catch (Exception e) {
            respuesta = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @PostMapping(name = "/marcas")
    public ResponseEntity<GaleriaResponse> saveMarca(String nombre){
        return null;
    }

    @GetMapping(name = "/sabores")
    public ResponseEntity<GaleriaResponse> getAllSaboresByIdMarca(Long id){
        ResponseEntity<GaleriaResponse> respuesta;
        try {
            GaleriaResponse resultado = saborService.getAllByIdMarca(id);
            respuesta = new ResponseEntity<GaleriaResponse>(resultado, HttpStatus.OK);
        } catch (Exception e) {
            respuesta = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @GetMapping(name = "/sabores/")
    public ResponseEntity<GaleriaResponse> getAllSaboresByIdMarcayEnStock(Long id) {
        ResponseEntity<GaleriaResponse> respuesta;
        try {
            GaleriaResponse resultado = saborService.getAllByIdMarcayStock(id);
            respuesta = new ResponseEntity<GaleriaResponse>(resultado, HttpStatus.OK);
        } catch (Exception e) {
            respuesta = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @PostMapping(name = "/sabores")
    public ResponseEntity<GaleriaResponse> saveSaborByIdMarca(String tipo){
        return null;
    }
}
