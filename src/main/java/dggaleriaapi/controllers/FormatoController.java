package dggaleriaapi.controllers;

import dggaleriaapi.models.DrinkContainer;
import dggaleriaapi.responses.FormatoResponse;
import dggaleriaapi.responses.StockDataResponse;
import dggaleriaapi.services.FormatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/formatos")
public class FormatoController {

    @Autowired
    FormatoService formatoService;

    @GetMapping
    public ResponseEntity<StockDataResponse<DrinkContainer>> getAllFormatos() {
        String succesMessage = "formatos obtenidos";
        String badMessage = "error al adquirir formatos";
        StockDataResponse formatoResponse = new StockDataResponse<>();
        ResponseEntity<StockDataResponse<DrinkContainer>> response;
        try {
            formatoResponse = formatoService.getAllFormatos();
            formatoResponse.setMessage(succesMessage);
            response = new ResponseEntity<StockDataResponse<DrinkContainer>>(formatoResponse, HttpStatus.OK);
        } catch (Exception e) {
            formatoResponse.setMessage(badMessage);
            response = new ResponseEntity<StockDataResponse<DrinkContainer>>(formatoResponse, HttpStatus.BAD_REQUEST);
        }
        return response;
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
    public ResponseEntity<FormatoResponse> updateFormato(@RequestBody DrinkContainer drinkContainer) {
        String mensajeAfirmativo = "drinkContainer actualizado";
        String mensajeNegativo = "error al intentar actualizar drinkContainer";
        FormatoResponse formatoResponse = new FormatoResponse();
        ResponseEntity<FormatoResponse> respuesta;
        try {
            formatoResponse = formatoService.updateFormato(drinkContainer);
            formatoResponse.setMensaje(mensajeAfirmativo);
            respuesta = new ResponseEntity<FormatoResponse>(formatoResponse, HttpStatus.OK);
        } catch (Exception e) {
            formatoResponse.setMensaje(mensajeNegativo);
            respuesta = new ResponseEntity<FormatoResponse>(formatoResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @DeleteMapping
    public ResponseEntity<FormatoResponse> deleteFormato(@RequestParam(value = "id") Long idFormato) {
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
