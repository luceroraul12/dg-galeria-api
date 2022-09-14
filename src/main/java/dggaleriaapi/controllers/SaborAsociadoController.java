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
@CrossOrigin
@RequestMapping(value = "/sabores-asociados")
public class SaborAsociadoController {

    @Autowired
    SaborAsociadoService saborAsociadoService;

    @GetMapping
    public ResponseEntity<SaborAsociadoResponse> getAll() {
        String successMessage = "sabores asociados encontrados";
        String badMessage = "error al buscar sabores asociados";
        SaborAsociadoResponse saborAsociadoResponse = new SaborAsociadoResponse();
        ResponseEntity<SaborAsociadoResponse> respuesta;
        try {
            saborAsociadoResponse = saborAsociadoService.getAll();
            saborAsociadoResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<SaborAsociadoResponse>(saborAsociadoResponse, HttpStatus.OK);
        } catch (Exception e) {
            saborAsociadoResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<SaborAsociadoResponse>(saborAsociadoResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    @GetMapping(value = "/por-brand")
    public ResponseEntity<SaborAsociadoResponse> getAllByIdBrand(@RequestParam(name = "id") Long idBrand) {
        String successMessage = "sabores asociados por brand encontrados";
        String badMessage = "error al buscar sabores asociados por brand";
        SaborAsociadoResponse saborAsociadoResponse = new SaborAsociadoResponse();
        ResponseEntity<SaborAsociadoResponse> respuesta;
        try {
            saborAsociadoResponse = saborAsociadoService.getAllByIdBrand(idBrand);
            saborAsociadoResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<SaborAsociadoResponse>(saborAsociadoResponse, HttpStatus.OK);
        } catch (Exception e) {
            saborAsociadoResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<SaborAsociadoResponse>(saborAsociadoResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    @PostMapping
    public ResponseEntity<SaborAsociadoResponse> save(@RequestBody SaborAsociado saborAsociado) {
        String successMessage = "sabor asociado creado";
        String badMessage = "error al crear sabor asociado";
        SaborAsociadoResponse saborAsociadoResponse = new SaborAsociadoResponse();
        ResponseEntity<SaborAsociadoResponse> respuesta;
        try {
            saborAsociadoResponse = saborAsociadoService.save(saborAsociado);
            saborAsociadoResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<SaborAsociadoResponse>(saborAsociadoResponse, HttpStatus.OK);
        } catch (Exception e) {
            saborAsociadoResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<SaborAsociadoResponse>(saborAsociadoResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    @PostMapping(value = "/monton")
    public ResponseEntity<SaborAsociadoResponse> savePorMonton(@RequestBody List<SaborAsociado> saboresAsociados) {
        String successMessage = "sabores asociados por brand creados";
        String badMessage = "error al crear sabores asociados";
        SaborAsociadoResponse saborAsociadoResponse = new SaborAsociadoResponse();
        ResponseEntity<SaborAsociadoResponse> respuesta;
        try {
            saborAsociadoResponse = saborAsociadoService.savePorMonton(saboresAsociados);
            saborAsociadoResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<SaborAsociadoResponse>(saborAsociadoResponse, HttpStatus.OK);
        } catch (Exception e) {
            saborAsociadoResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<SaborAsociadoResponse>(saborAsociadoResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    @PutMapping
    public ResponseEntity<SaborAsociadoResponse> update(@RequestBody SaborAsociado saborAsociado) {
        String successMessage = "sabor asociado actualizado";
        String badMessage = "error al actualizar sabor asociado";
        SaborAsociadoResponse saborAsociadoResponse = new SaborAsociadoResponse();
        ResponseEntity<SaborAsociadoResponse> respuesta;
        try {
            saborAsociadoResponse = saborAsociadoService.update(saborAsociado);
            saborAsociadoResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<SaborAsociadoResponse>(saborAsociadoResponse, HttpStatus.OK);
        } catch (Exception e) {
            saborAsociadoResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<SaborAsociadoResponse>(saborAsociadoResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    @DeleteMapping
    public ResponseEntity<SaborAsociadoResponse> delete(@RequestBody SaborAsociado saborAsociado) {
        String successMessage = "sabor asociado eliminado";
        String badMessage = "error al eliminar sabor asociado";
        SaborAsociadoResponse saborAsociadoResponse = new SaborAsociadoResponse();
        ResponseEntity<SaborAsociadoResponse> respuesta;
        try {
            saborAsociadoResponse = saborAsociadoService.delete(saborAsociado);
            saborAsociadoResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<SaborAsociadoResponse>(saborAsociadoResponse, HttpStatus.OK);
        } catch (Exception e) {
            saborAsociadoResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<SaborAsociadoResponse>(saborAsociadoResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
}
