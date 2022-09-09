package dggaleriaapi.controllers;

import dggaleriaapi.models.Formato;
import dggaleriaapi.responses.FormatoResponse;
import dggaleriaapi.services.FormatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/formatos")
public class FormatoController {

    @Autowired
    FormatoService formatoService;

    @GetMapping
    public ResponseEntity<FormatoResponse> getAllFormatos() {
        String mensajeAfirmativo = "formatos obtenidos";
        String mensajeNegativo = "error al adquirir formatos";
        FormatoResponse formatoResponse = new FormatoResponse();
        ResponseEntity<FormatoResponse> respuesta;
        try {
            formatoResponse = formatoService.getAllFormatos();
            formatoResponse.setMensaje(mensajeAfirmativo);
            respuesta = new ResponseEntity<FormatoResponse>(formatoResponse, HttpStatus.OK);
        } catch (Exception e) {
            formatoResponse.setMensaje(mensajeNegativo);
            respuesta = new ResponseEntity<FormatoResponse>(formatoResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @PostMapping
    public ResponseEntity<FormatoResponse> saveFormato(@RequestParam(name = "tipo") String tipo) {
        String mensajeAfirmativo = "formato guardado";
        String mensajeNegativo = "error al intentar guardar formato";
        FormatoResponse formatoResponse = new FormatoResponse();
        ResponseEntity<FormatoResponse> respuesta;
        try {
            formatoResponse = formatoService.saveFormato(tipo);
            formatoResponse.setMensaje(mensajeAfirmativo);
            respuesta = new ResponseEntity<FormatoResponse>(formatoResponse, HttpStatus.OK);
        } catch (Exception e) {
            formatoResponse.setMensaje(mensajeNegativo);
            respuesta = new ResponseEntity<FormatoResponse>(formatoResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    @PutMapping
    public ResponseEntity<FormatoResponse> updateFormato(@RequestBody Formato formato) {
        String mensajeAfirmativo = "formato actualizado";
        String mensajeNegativo = "error al intentar actualizar formato";
        FormatoResponse formatoResponse = new FormatoResponse();
        ResponseEntity<FormatoResponse> respuesta;
        try {
            formatoResponse = formatoService.updateFormato(formato);
            formatoResponse.setMensaje(mensajeAfirmativo);
            respuesta = new ResponseEntity<FormatoResponse>(formatoResponse, HttpStatus.OK);
        } catch (Exception e) {
            formatoResponse.setMensaje(mensajeNegativo);
            respuesta = new ResponseEntity<FormatoResponse>(formatoResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @DeleteMapping
    public ResponseEntity<FormatoResponse> deleteFormato(@RequestParam(value = "id-formato") Long idFormato) {
        String mensajeAfirmativo = "formato eliminado";
        String mensajeNegativo = "error al intentar eliminar formato";
        FormatoResponse formatoResponse = new FormatoResponse();
        ResponseEntity<FormatoResponse> respuesta;
        try {
            formatoResponse = formatoService.deleteFormato(idFormato);
            formatoResponse.setMensaje(mensajeAfirmativo);
            respuesta = new ResponseEntity<FormatoResponse>(formatoResponse, HttpStatus.OK);
        } catch (Exception e) {
            formatoResponse.setMensaje(mensajeNegativo);
            respuesta = new ResponseEntity<FormatoResponse>(formatoResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
}
