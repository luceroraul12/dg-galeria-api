package dggaleriaapi.controllers;

import dggaleriaapi.models.SaborAsociado;
import dggaleriaapi.responses.SaborAsociadoResponse;
import dggaleriaapi.services.SaborAsociadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/sabores-asociados")
public class SaborAsociadoController {

    @Autowired
    SaborAsociadoService saborAsociadoService;

    @GetMapping
    public ResponseEntity<SaborAsociadoResponse> getAll() {
        String mensajeAfirmativo = "sabores asociados encontrados";
        String mensajeNegativo = "error al buscar sabores asociados";
        SaborAsociadoResponse saborAsociadoResponse = new SaborAsociadoResponse();
        ResponseEntity<SaborAsociadoResponse> respuesta;
        try {
            saborAsociadoResponse = saborAsociadoService.getAll();
            saborAsociadoResponse.setMensaje(mensajeAfirmativo);
            respuesta = new ResponseEntity<SaborAsociadoResponse>(saborAsociadoResponse, HttpStatus.OK);
        } catch (Exception e) {
            saborAsociadoResponse.setMensaje(mensajeNegativo);
            respuesta = new ResponseEntity<SaborAsociadoResponse>(saborAsociadoResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    @GetMapping(value = "/por-marca")
    public ResponseEntity<SaborAsociadoResponse> getAllByIdMarca(@RequestParam(name = "id") Long idMarca) {
        String mensajeAfirmativo = "sabores asociados por marca encontrados";
        String mensajeNegativo = "error al buscar sabores asociados por marca";
        SaborAsociadoResponse saborAsociadoResponse = new SaborAsociadoResponse();
        ResponseEntity<SaborAsociadoResponse> respuesta;
        try {
            saborAsociadoResponse = saborAsociadoService.getAllByIdMarca(idMarca);
            saborAsociadoResponse.setMensaje(mensajeAfirmativo);
            respuesta = new ResponseEntity<SaborAsociadoResponse>(saborAsociadoResponse, HttpStatus.OK);
        } catch (Exception e) {
            saborAsociadoResponse.setMensaje(mensajeNegativo);
            respuesta = new ResponseEntity<SaborAsociadoResponse>(saborAsociadoResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    @PostMapping
    public ResponseEntity<SaborAsociadoResponse> save(@RequestBody SaborAsociado saborAsociado) {
        String mensajeAfirmativo = "sabor asociado creado";
        String mensajeNegativo = "error al crear sabor asociado";
        SaborAsociadoResponse saborAsociadoResponse = new SaborAsociadoResponse();
        ResponseEntity<SaborAsociadoResponse> respuesta;
        try {
            saborAsociadoResponse = saborAsociadoService.save(saborAsociado);
            saborAsociadoResponse.setMensaje(mensajeAfirmativo);
            respuesta = new ResponseEntity<SaborAsociadoResponse>(saborAsociadoResponse, HttpStatus.OK);
        } catch (Exception e) {
            saborAsociadoResponse.setMensaje(mensajeNegativo);
            respuesta = new ResponseEntity<SaborAsociadoResponse>(saborAsociadoResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    @PostMapping(value = "/monton")
    public ResponseEntity<SaborAsociadoResponse> savePorMonton(@RequestBody List<SaborAsociado> saboresAsociados) {
        String mensajeAfirmativo = "sabores asociados por marca creados";
        String mensajeNegativo = "error al crear sabores asociados";
        SaborAsociadoResponse saborAsociadoResponse = new SaborAsociadoResponse();
        ResponseEntity<SaborAsociadoResponse> respuesta;
        try {
            saborAsociadoResponse = saborAsociadoService.savePorMonton(saboresAsociados);
            saborAsociadoResponse.setMensaje(mensajeAfirmativo);
            respuesta = new ResponseEntity<SaborAsociadoResponse>(saborAsociadoResponse, HttpStatus.OK);
        } catch (Exception e) {
            saborAsociadoResponse.setMensaje(mensajeNegativo);
            respuesta = new ResponseEntity<SaborAsociadoResponse>(saborAsociadoResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    @PutMapping
    public ResponseEntity<SaborAsociadoResponse> update(@RequestBody SaborAsociado saborAsociado) {
        String mensajeAfirmativo = "sabor asociado actualizado";
        String mensajeNegativo = "error al actualizar sabor asociado";
        SaborAsociadoResponse saborAsociadoResponse = new SaborAsociadoResponse();
        ResponseEntity<SaborAsociadoResponse> respuesta;
        try {
            saborAsociadoResponse = saborAsociadoService.update(saborAsociado);
            saborAsociadoResponse.setMensaje(mensajeAfirmativo);
            respuesta = new ResponseEntity<SaborAsociadoResponse>(saborAsociadoResponse, HttpStatus.OK);
        } catch (Exception e) {
            saborAsociadoResponse.setMensaje(mensajeNegativo);
            respuesta = new ResponseEntity<SaborAsociadoResponse>(saborAsociadoResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    @DeleteMapping
    public ResponseEntity<SaborAsociadoResponse> delete(@RequestBody SaborAsociado saborAsociado) {
        String mensajeAfirmativo = "sabor asociado eliminado";
        String mensajeNegativo = "error al eliminar sabor asociado";
        SaborAsociadoResponse saborAsociadoResponse = new SaborAsociadoResponse();
        ResponseEntity<SaborAsociadoResponse> respuesta;
        try {
            saborAsociadoResponse = saborAsociadoService.delete(saborAsociado);
            saborAsociadoResponse.setMensaje(mensajeAfirmativo);
            respuesta = new ResponseEntity<SaborAsociadoResponse>(saborAsociadoResponse, HttpStatus.OK);
        } catch (Exception e) {
            saborAsociadoResponse.setMensaje(mensajeNegativo);
            respuesta = new ResponseEntity<SaborAsociadoResponse>(saborAsociadoResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
}
