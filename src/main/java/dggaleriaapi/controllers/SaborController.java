package dggaleriaapi.controllers;

import dggaleriaapi.models.Sabor;
import dggaleriaapi.responses.SaborResponse;
import dggaleriaapi.services.SaborService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/sabores")
public class SaborController {

    @Autowired
    SaborService saborService;

    @GetMapping
    public ResponseEntity<SaborResponse> getAll() {
        String successMessage = "sabores encontrados";
        String badMessage = "error al buscar sabores";
        SaborResponse saborResponse = new SaborResponse();
        ResponseEntity<SaborResponse> respuesta;
        try {
            saborResponse = saborService.getAll();
            saborResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<SaborResponse>(saborResponse, HttpStatus.OK);
        } catch (Exception e) {
            saborResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<SaborResponse>(saborResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @PostMapping
    public ResponseEntity<SaborResponse> save(@RequestBody Sabor sabor) {
        String successMessage = "sabor creado";
        String badMessage = "error al crear sabor";
        SaborResponse saborResponse = new SaborResponse();
        ResponseEntity<SaborResponse> respuesta;
        try {
            saborResponse = saborService.save(sabor);
            saborResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<SaborResponse>(saborResponse, HttpStatus.OK);
        } catch (Exception e) {
            saborResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<SaborResponse>(saborResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @PostMapping(value = "/monton")
    public ResponseEntity<SaborResponse> savePorMonton(@RequestBody List<Sabor> sabores) {
        String successMessage = "sabores creados";
        String badMessage = "error al crear sabores";
        SaborResponse saborResponse = new SaborResponse();
        ResponseEntity<SaborResponse> respuesta;
        try {
            saborResponse = saborService.savePorMonton(sabores);
            saborResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<SaborResponse>(saborResponse, HttpStatus.OK);
        } catch (Exception e) {
            saborResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<SaborResponse>(saborResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @PutMapping
    public ResponseEntity<SaborResponse> update(@RequestBody Sabor sabor) {
        String successMessage = "sabor actualizado";
        String badMessage = "error al actualizar sabor";
        SaborResponse saborResponse = new SaborResponse();
        ResponseEntity<SaborResponse> respuesta;
        try {
            saborResponse = saborService.update(sabor);
            saborResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<SaborResponse>(saborResponse, HttpStatus.OK);
        } catch (Exception e) {
            saborResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<SaborResponse>(saborResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @DeleteMapping
    public ResponseEntity<SaborResponse> delete(@RequestBody Sabor sabor) {
        String successMessage = "sabor eliminado";
        String badMessage = "error al eliminar sabor";
        SaborResponse saborResponse = new SaborResponse();
        ResponseEntity<SaborResponse> respuesta;
        try {
            saborResponse = saborService.delete(sabor);
            saborResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<SaborResponse>(saborResponse, HttpStatus.OK);
        } catch (Exception e) {
            saborResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<SaborResponse>(saborResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
}
