package dggaleriaapi.controllers;

import dggaleriaapi.models.Formato;
import dggaleriaapi.models.Marca;
import dggaleriaapi.models.SaborAsociado;
import dggaleriaapi.responses.GaleriaResponse;
import dggaleriaapi.services.FormatoService;
import dggaleriaapi.services.MarcaService;
import dggaleriaapi.services.SaborAsociadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/galeria")
@CrossOrigin
public class GaleriaBebidasController {

    @Autowired
    private FormatoService formatoService;
    @Autowired
    private MarcaService marcaService;
    @Autowired
    private SaborAsociadoService saborAsociadoService;

    public GaleriaBebidasController(FormatoService formatoService, MarcaService marcaService, SaborAsociadoService saborAsociadoService) {
        this.formatoService = formatoService;
        this.marcaService = marcaService;
        this.saborAsociadoService = saborAsociadoService;
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

    @GetMapping(value = "/marca")
    public ResponseEntity<GaleriaResponse> getMarcaById(@RequestParam(name = "id-marca") Long idMarca){
        ResponseEntity<GaleriaResponse> respuesta;
        try {
            GaleriaResponse resultado = marcaService.getMarcaById(idMarca);
            respuesta = new ResponseEntity<GaleriaResponse>(resultado, HttpStatus.OK);
        } catch (Exception e) {
            respuesta = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @PostMapping(value = "/marcas", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GaleriaResponse> saveMarca(@RequestBody Marca marca){
        ResponseEntity<GaleriaResponse> respuesta;
        try {
            GaleriaResponse resultado = marcaService.saveMarca(marca);
            respuesta = new ResponseEntity<GaleriaResponse>(resultado, HttpStatus.OK);
        } catch (Exception e) {
            respuesta = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @PutMapping(value = "/marcas", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GaleriaResponse> updateMarca(@RequestBody Marca marca){
        ResponseEntity<GaleriaResponse> respuesta;
        try {
            GaleriaResponse resultado = marcaService.updateMarca(marca);
            respuesta = new ResponseEntity<GaleriaResponse>(resultado, HttpStatus.OK);
        } catch (Exception e) {
            respuesta = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @DeleteMapping(value = "/marcas", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GaleriaResponse> deleteMarca(@RequestBody Marca marca){
        ResponseEntity<GaleriaResponse> respuesta;
        try {
            GaleriaResponse resultado = marcaService.deleteMarca(marca.getId());
            respuesta = new ResponseEntity<GaleriaResponse>(resultado, HttpStatus.OK);
        } catch (Exception e) {
            respuesta = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }



    @GetMapping(value = "/sabores-asociados")
    public ResponseEntity<GaleriaResponse> getAllSaboresByIdMarca(@RequestParam(name = "id-marca") Long id){
        ResponseEntity<GaleriaResponse> respuesta;
        try {
            GaleriaResponse resultado = saborAsociadoService.getAllByIdMarca(id);
            respuesta = new ResponseEntity<GaleriaResponse>(resultado, HttpStatus.OK);
        } catch (Exception e) {
            respuesta = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @GetMapping(value = "/sabores-asociados/ver")
    public ResponseEntity<GaleriaResponse> getAllSaboresByIdMarcaParaVer(@RequestParam(name = "id-marca") Long id){
        ResponseEntity<GaleriaResponse> respuesta;
        try {
            GaleriaResponse resultado = saborAsociadoService.getAllByIdMarcaParaVer(id);
            respuesta = new ResponseEntity<GaleriaResponse>(resultado, HttpStatus.OK);
        } catch (Exception e) {
            respuesta = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @GetMapping(value = "/sabores-asociados/con-stock")
    public ResponseEntity<GaleriaResponse> getAllSaboresByIdMarcayEnStock(@RequestParam(name = "id-marca") Long id) {
        ResponseEntity<GaleriaResponse> respuesta;
        try {
            GaleriaResponse resultado = saborAsociadoService.getAllByIdMarcayStock(id);
            respuesta = new ResponseEntity<GaleriaResponse>(resultado, HttpStatus.OK);
        } catch (Exception e) {
            respuesta = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @PostMapping(value = "/sabores-asociados", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GaleriaResponse> saveSabor(@RequestBody SaborAsociado saborAsociado){
        ResponseEntity<GaleriaResponse> respuesta;
        try {
            GaleriaResponse resultado = saborAsociadoService.saveSabor(saborAsociado);
            respuesta = new ResponseEntity<GaleriaResponse>(resultado, HttpStatus.OK);
        } catch (Exception e) {
            respuesta = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @PutMapping(value = "/sabores-asociados", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GaleriaResponse> updateSabor(@RequestBody SaborAsociado saborAsociado){
        ResponseEntity<GaleriaResponse> respuesta;
        try {
            GaleriaResponse resultado = saborAsociadoService.updateSabor(saborAsociado);
            respuesta = new ResponseEntity<GaleriaResponse>(resultado, HttpStatus.OK);
        } catch (Exception e) {
            respuesta = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @DeleteMapping(value = "/sabores-asociados", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GaleriaResponse> deleteSabor(@RequestBody SaborAsociado saborAsociado){
        ResponseEntity<GaleriaResponse> respuesta;
        try {
            GaleriaResponse resultado = saborAsociadoService.deleteSabor(saborAsociado);
            respuesta = new ResponseEntity<GaleriaResponse>(resultado, HttpStatus.OK);
        } catch (Exception e) {
            respuesta = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
}
