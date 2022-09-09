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
@RequestMapping(value = "/sabores")
public class SaborController {

    @Autowired
    SaborService saborService;

    @GetMapping
    public ResponseEntity<SaborResponse> getAll() {
        String mensajeAfirmativo = "sabores encontrados";
        String mensajeNegativo = "error al buscar sabores";
        SaborResponse saborResponse = new SaborResponse();
        ResponseEntity<SaborResponse> respuesta;
        try {
            saborResponse = saborService.getAll();
            saborResponse.setMensaje(mensajeAfirmativo);
            respuesta = new ResponseEntity<SaborResponse>(saborResponse, HttpStatus.OK);
        } catch (Exception e) {
            saborResponse.setMensaje(mensajeNegativo);
            respuesta = new ResponseEntity<SaborResponse>(saborResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @PostMapping
    public ResponseEntity<SaborResponse> save(@RequestBody Sabor sabor) {
        String mensajeAfirmativo = "sabor creado";
        String mensajeNegativo = "error al crear sabor";
        SaborResponse saborResponse = new SaborResponse();
        ResponseEntity<SaborResponse> respuesta;
        try {
            saborResponse = saborService.save(sabor);
            saborResponse.setMensaje(mensajeAfirmativo);
            respuesta = new ResponseEntity<SaborResponse>(saborResponse, HttpStatus.OK);
        } catch (Exception e) {
            saborResponse.setMensaje(mensajeNegativo);
            respuesta = new ResponseEntity<SaborResponse>(saborResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @PostMapping(value = "/monton")
    public ResponseEntity<SaborResponse> savePorMonton(@RequestBody List<Sabor> sabores) {
        String mensajeAfirmativo = "sabores creados";
        String mensajeNegativo = "error al crear sabores";
        SaborResponse saborResponse = new SaborResponse();
        ResponseEntity<SaborResponse> respuesta;
        try {
            saborResponse = saborService.savePorMonton(sabores);
            saborResponse.setMensaje(mensajeAfirmativo);
            respuesta = new ResponseEntity<SaborResponse>(saborResponse, HttpStatus.OK);
        } catch (Exception e) {
            saborResponse.setMensaje(mensajeNegativo);
            respuesta = new ResponseEntity<SaborResponse>(saborResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @PutMapping
    public ResponseEntity<SaborResponse> update(@RequestBody Sabor sabor) {
        String mensajeAfirmativo = "sabor actualizado";
        String mensajeNegativo = "error al actualizar sabor";
        SaborResponse saborResponse = new SaborResponse();
        ResponseEntity<SaborResponse> respuesta;
        try {
            saborResponse = saborService.update(sabor);
            saborResponse.setMensaje(mensajeAfirmativo);
            respuesta = new ResponseEntity<SaborResponse>(saborResponse, HttpStatus.OK);
        } catch (Exception e) {
            saborResponse.setMensaje(mensajeNegativo);
            respuesta = new ResponseEntity<SaborResponse>(saborResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @DeleteMapping
    public ResponseEntity<SaborResponse> delete(@RequestBody Sabor sabor) {
        String mensajeAfirmativo = "sabor eliminado";
        String mensajeNegativo = "error al eliminar sabor";
        SaborResponse saborResponse = new SaborResponse();
        ResponseEntity<SaborResponse> respuesta;
        try {
            saborResponse = saborService.delete(sabor);
            saborResponse.setMensaje(mensajeAfirmativo);
            respuesta = new ResponseEntity<SaborResponse>(saborResponse, HttpStatus.OK);
        } catch (Exception e) {
            saborResponse.setMensaje(mensajeNegativo);
            respuesta = new ResponseEntity<SaborResponse>(saborResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
}
