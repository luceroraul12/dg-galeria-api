package dggaleriaapi.controllers;

import dggaleriaapi.models.Formato;
import dggaleriaapi.models.Sabor;
import dggaleriaapi.responses.GaleriaResponse;
import dggaleriaapi.services.FormatoService;
import dggaleriaapi.services.MarcaService;
import dggaleriaapi.services.SaborService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/formatos")
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

    @PostMapping(value = "/formatos")
    public ResponseEntity<GaleriaResponse> saveFormato(@RequestParam(name = "tipo") String tipo){
        ResponseEntity<GaleriaResponse> respuesta;
        try {
            GaleriaResponse resultado = formatoService.saveFormato(tipo);
            respuesta = new ResponseEntity<GaleriaResponse>(resultado, HttpStatus.OK);
        } catch (Exception e) {
            respuesta = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @PutMapping(value = "/formatos", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GaleriaResponse> updateFormato(@RequestBody Formato formato){
        ResponseEntity<GaleriaResponse> respuesta;
        try {
            GaleriaResponse resultado = formatoService.updateFormato(formato);
            respuesta = new ResponseEntity<GaleriaResponse>(resultado, HttpStatus.OK);
        } catch (Exception e) {
            respuesta = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @DeleteMapping(value = "/formatos")
    public ResponseEntity<GaleriaResponse> deleteFormato(@RequestParam(name = "id-formato") Long idFormato){
        ResponseEntity<GaleriaResponse> respuesta;
        try {
            GaleriaResponse resultado = formatoService.deleteFormato(idFormato);
            respuesta = new ResponseEntity<GaleriaResponse>(resultado, HttpStatus.OK);
        } catch (Exception e) {
            respuesta = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @GetMapping(value = "/marcas")
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

    @PostMapping(value = "/marcas")
    public ResponseEntity<GaleriaResponse> saveMarca(@RequestParam(name = "nombre") String nombre){
        return null;
    }

    @GetMapping(value = "/sabores")
    public ResponseEntity<GaleriaResponse> getAllSaboresByIdMarca(@RequestParam(name = "id-marca") Long id){
        ResponseEntity<GaleriaResponse> respuesta;
        try {
            GaleriaResponse resultado = saborService.getAllByIdMarca(id);
            respuesta = new ResponseEntity<GaleriaResponse>(resultado, HttpStatus.OK);
        } catch (Exception e) {
            respuesta = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @GetMapping(value = "/sabores/con-stock")
    public ResponseEntity<GaleriaResponse> getAllSaboresByIdMarcayEnStock(@RequestParam(name = "id-marca") Long id) {
        ResponseEntity<GaleriaResponse> respuesta;
        try {
            GaleriaResponse resultado = saborService.getAllByIdMarcayStock(id);
            respuesta = new ResponseEntity<GaleriaResponse>(resultado, HttpStatus.OK);
        } catch (Exception e) {
            respuesta = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @PostMapping(value = "/sabores", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GaleriaResponse> saveSaborByIdMarca(@RequestBody Sabor sabor){
        return null;
    }
}
