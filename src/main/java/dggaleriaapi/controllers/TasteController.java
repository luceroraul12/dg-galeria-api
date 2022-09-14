package dggaleriaapi.controllers;

import dggaleriaapi.models.Taste;
import dggaleriaapi.responses.TasteResponse;
import dggaleriaapi.services.TasteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/tastees")
public class TasteController {

    @Autowired
    TasteService tasteService;

    @GetMapping
    public ResponseEntity<TasteResponse> getAll() {
        String successMessage = "tastees encontrados";
        String badMessage = "error al buscar tastees";
        TasteResponse tasteResponse = new TasteResponse();
        ResponseEntity<TasteResponse> respuesta;
        try {
            tasteResponse = tasteService.getAll();
            tasteResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<TasteResponse>(tasteResponse, HttpStatus.OK);
        } catch (Exception e) {
            tasteResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<TasteResponse>(tasteResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @PostMapping
    public ResponseEntity<TasteResponse> save(@RequestBody Taste taste) {
        String successMessage = "taste creado";
        String badMessage = "error al crear taste";
        TasteResponse tasteResponse = new TasteResponse();
        ResponseEntity<TasteResponse> respuesta;
        try {
            tasteResponse = tasteService.save(taste);
            tasteResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<TasteResponse>(tasteResponse, HttpStatus.OK);
        } catch (Exception e) {
            tasteResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<TasteResponse>(tasteResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @PostMapping(value = "/monton")
    public ResponseEntity<TasteResponse> savePorMonton(@RequestBody List<Taste> tastees) {
        String successMessage = "tastees creados";
        String badMessage = "error al crear tastees";
        TasteResponse tasteResponse = new TasteResponse();
        ResponseEntity<TasteResponse> respuesta;
        try {
            tasteResponse = tasteService.savePorMonton(tastees);
            tasteResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<TasteResponse>(tasteResponse, HttpStatus.OK);
        } catch (Exception e) {
            tasteResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<TasteResponse>(tasteResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @PutMapping
    public ResponseEntity<TasteResponse> update(@RequestBody Taste taste) {
        String successMessage = "taste actualizado";
        String badMessage = "error al actualizar taste";
        TasteResponse tasteResponse = new TasteResponse();
        ResponseEntity<TasteResponse> respuesta;
        try {
            tasteResponse = tasteService.update(taste);
            tasteResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<TasteResponse>(tasteResponse, HttpStatus.OK);
        } catch (Exception e) {
            tasteResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<TasteResponse>(tasteResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @DeleteMapping
    public ResponseEntity<TasteResponse> delete(@RequestBody Taste taste) {
        String successMessage = "taste eliminado";
        String badMessage = "error al eliminar taste";
        TasteResponse tasteResponse = new TasteResponse();
        ResponseEntity<TasteResponse> respuesta;
        try {
            tasteResponse = tasteService.delete(taste);
            tasteResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<TasteResponse>(tasteResponse, HttpStatus.OK);
        } catch (Exception e) {
            tasteResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<TasteResponse>(tasteResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
}
