package dggaleriaapi.controllers;

import dggaleriaapi.models.TasteFormateado;
import dggaleriaapi.responses.TasteFormateadoResponse;
import dggaleriaapi.services.TasteFormateadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/tastees-formateados")
public class TasteFormateadoController {

    @Autowired
    TasteFormateadoService tasteFormateadoService;

    @GetMapping
    public ResponseEntity<TasteFormateadoResponse> getAll() {
        String successMessage = "tastees formateados encontrados";
        String badMessage = "error al buscar tastees formateados";
        TasteFormateadoResponse tasteFormateadoResponse = new TasteFormateadoResponse();
        ResponseEntity<TasteFormateadoResponse> respuesta;
        try {
            tasteFormateadoResponse = tasteFormateadoService.getAll();
            tasteFormateadoResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<TasteFormateadoResponse>(tasteFormateadoResponse, HttpStatus.OK);
        } catch (Exception e) {
            tasteFormateadoResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<TasteFormateadoResponse>(tasteFormateadoResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    @GetMapping("/taste-asociado")
    public ResponseEntity<TasteFormateadoResponse> getByBrandedTasteId(@RequestBody TasteFormateado tasteFormateado) {
        String successMessage = "tastees encontrados";
        String badMessage = "error al buscar tastees";
        TasteFormateadoResponse tasteFormateadoResponse = new TasteFormateadoResponse();
        ResponseEntity<TasteFormateadoResponse> respuesta;
        try {
            tasteFormateadoResponse = tasteFormateadoService.getByBrandedTasteId(tasteFormateado);
            tasteFormateadoResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<TasteFormateadoResponse>(tasteFormateadoResponse, HttpStatus.OK);
        } catch (Exception e) {
            tasteFormateadoResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<TasteFormateadoResponse>(tasteFormateadoResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    @GetMapping("/por-brand")
    public ResponseEntity<TasteFormateadoResponse> getAllByIdBrand(@RequestParam(name = "id") Long idBrand) {
        String successMessage = "tastees encontrados";
        String badMessage = "error al buscar tastees";
        TasteFormateadoResponse tasteFormateadoResponse = new TasteFormateadoResponse();
        ResponseEntity<TasteFormateadoResponse> respuesta;
        try {
            tasteFormateadoResponse = tasteFormateadoService.getAllByIdBrand(idBrand);
            tasteFormateadoResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<TasteFormateadoResponse>(tasteFormateadoResponse, HttpStatus.OK);
        } catch (Exception e) {
            tasteFormateadoResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<TasteFormateadoResponse>(tasteFormateadoResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    @PostMapping
    public ResponseEntity<TasteFormateadoResponse> save(@RequestBody TasteFormateado tasteFormateado) {
        String successMessage = "taste creado";
        String badMessage = "error al crear taste";
        TasteFormateadoResponse tasteFormateadoResponse = new TasteFormateadoResponse();
        ResponseEntity<TasteFormateadoResponse> respuesta;
        try {
            tasteFormateadoResponse = tasteFormateadoService.save(tasteFormateado);
            tasteFormateadoResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<TasteFormateadoResponse>(tasteFormateadoResponse, HttpStatus.OK);
        } catch (Exception e) {
            tasteFormateadoResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<TasteFormateadoResponse>(tasteFormateadoResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    @PostMapping("/save-inicial")
    public ResponseEntity<TasteFormateadoResponse> saveInicial(@RequestBody TasteFormateado tasteFormateado) {
        String successMessage = "tastees formateados creados inicialmente";
        String badMessage = "error al crear tastees formateados inicialmente";
        TasteFormateadoResponse tasteFormateadoResponse = new TasteFormateadoResponse();
        ResponseEntity<TasteFormateadoResponse> respuesta;
        try {
            tasteFormateadoResponse = tasteFormateadoService.saveInicial(tasteFormateado);
            tasteFormateadoResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<TasteFormateadoResponse>(tasteFormateadoResponse, HttpStatus.OK);
        } catch (Exception e) {
            tasteFormateadoResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<TasteFormateadoResponse>(tasteFormateadoResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @PostMapping("/save-monton")
    public ResponseEntity<TasteFormateadoResponse> savePorMonton(@RequestBody List<TasteFormateado> tasteesFormateados) {
        String successMessage = "tastees formateados por monton creados";
        String badMessage = "error al crear tastees formateados por monton";
        TasteFormateadoResponse tasteFormateadoResponse = new TasteFormateadoResponse();
        ResponseEntity<TasteFormateadoResponse> respuesta;
        try {
            tasteFormateadoResponse = tasteFormateadoService.savePorMonton(tasteesFormateados);
            tasteFormateadoResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<TasteFormateadoResponse>(tasteFormateadoResponse, HttpStatus.OK);
        } catch (Exception e) {
            tasteFormateadoResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<TasteFormateadoResponse>(tasteFormateadoResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @PostMapping("/save-monton-inicial")
    public ResponseEntity<TasteFormateadoResponse> savePorMontonInicial(@RequestBody List<TasteFormateado> tasteesFormateados) {
        String successMessage = "tastees formateados por monton inicial creados";
        String badMessage = "error al crear tastees formateados inicial por monton";
        TasteFormateadoResponse tasteFormateadoResponse = new TasteFormateadoResponse();
        ResponseEntity<TasteFormateadoResponse> respuesta;
        try {
            tasteFormateadoResponse = tasteFormateadoService.savePorMontonInicial(tasteesFormateados);
            tasteFormateadoResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<TasteFormateadoResponse>(tasteFormateadoResponse, HttpStatus.OK);
        } catch (Exception e) {
            tasteFormateadoResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<TasteFormateadoResponse>(tasteFormateadoResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    @PutMapping
    public ResponseEntity<TasteFormateadoResponse> update(@RequestBody TasteFormateado tasteFormateado) {
        String successMessage = "tastee formateado actualizado";
        String badMessage = "error al actualizar taste formateado";
        TasteFormateadoResponse tasteFormateadoResponse = new TasteFormateadoResponse();
        ResponseEntity<TasteFormateadoResponse> respuesta;
        try {
            tasteFormateadoResponse = tasteFormateadoService.update(tasteFormateado);
            tasteFormateadoResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<TasteFormateadoResponse>(tasteFormateadoResponse, HttpStatus.OK);
        } catch (Exception e) {
            tasteFormateadoResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<TasteFormateadoResponse>(tasteFormateadoResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @DeleteMapping
    public ResponseEntity<TasteFormateadoResponse> delete(@RequestBody TasteFormateado tasteFormateado) {
        String successMessage = "taste formateado eliminado";
        String badMessage = "error al borrar taste formateado";
        TasteFormateadoResponse tasteFormateadoResponse = new TasteFormateadoResponse();
        ResponseEntity<TasteFormateadoResponse> respuesta;
        try {
            tasteFormateadoResponse = tasteFormateadoService.delete(tasteFormateado);
            tasteFormateadoResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<TasteFormateadoResponse>(tasteFormateadoResponse, HttpStatus.OK);
        } catch (Exception e) {
            tasteFormateadoResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<TasteFormateadoResponse>(tasteFormateadoResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
}
