package dggaleriaapi.controllers;

import dggaleriaapi.models.Marca;
import dggaleriaapi.responses.MarcaResponse;
import dggaleriaapi.services.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarcaController {

    @Autowired
    MarcaService marcaService;

    public ResponseEntity<MarcaResponse> getAll() {
        String mensajeAfirmativo = "marcas obtenidas";
        String mensajeNegativo = "error al adquirir marcas";
        MarcaResponse marcaResponse = new MarcaResponse();
        ResponseEntity<MarcaResponse> respuesta;
        try {
            marcaResponse = marcaService.getAll();
            marcaResponse.setMensaje(mensajeAfirmativo);
            respuesta = new ResponseEntity<MarcaResponse>(marcaResponse, HttpStatus.OK);
        } catch (Exception e) {
            marcaResponse.setMensaje(mensajeNegativo);
            respuesta = new ResponseEntity<MarcaResponse>(marcaResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    public ResponseEntity<MarcaResponse> getMarcaById(Long idMarca) {
        String mensajeAfirmativo = "marcas obtenidas por id";
        String mensajeNegativo = "error al adquirir marcas por id";
        MarcaResponse marcaResponse = new MarcaResponse();
        ResponseEntity<MarcaResponse> respuesta;
        try {
            marcaResponse = marcaService.getMarcaById(idMarca);
            marcaResponse.setMensaje(mensajeAfirmativo);
            respuesta = new ResponseEntity<MarcaResponse>(marcaResponse, HttpStatus.OK);
        } catch (Exception e) {
            marcaResponse.setMensaje(mensajeNegativo);
            respuesta = new ResponseEntity<MarcaResponse>(marcaResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    public ResponseEntity<MarcaResponse> saveMarca(Marca marca) {
        String mensajeAfirmativo = "marca guardada";
        String mensajeNegativo = "error al guardar marca";
        MarcaResponse marcaResponse = new MarcaResponse();
        ResponseEntity<MarcaResponse> respuesta;
        try {
            marcaResponse = marcaService.saveMarca(marca);
            marcaResponse.setMensaje(mensajeAfirmativo);
            respuesta = new ResponseEntity<MarcaResponse>(marcaResponse, HttpStatus.OK);
        } catch (Exception e) {
            marcaResponse.setMensaje(mensajeNegativo);
            respuesta = new ResponseEntity<MarcaResponse>(marcaResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    public ResponseEntity<MarcaResponse> updateMarca(Marca marca) {
        String mensajeAfirmativo = "marca actualizada";
        String mensajeNegativo = "error al actualizar marca";
        MarcaResponse marcaResponse = new MarcaResponse();
        ResponseEntity<MarcaResponse> respuesta;
        try {
            marcaResponse = marcaService.updateMarca(marca);
            marcaResponse.setMensaje(mensajeAfirmativo);
            respuesta = new ResponseEntity<MarcaResponse>(marcaResponse, HttpStatus.OK);
        } catch (Exception e) {
            marcaResponse.setMensaje(mensajeNegativo);
            respuesta = new ResponseEntity<MarcaResponse>(marcaResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    public ResponseEntity<MarcaResponse> deleteMarca(Long idMarca) {
        String mensajeAfirmativo = "marca eliminada";
        String mensajeNegativo = "error al eliminar marca";
        MarcaResponse marcaResponse = new MarcaResponse();
        ResponseEntity<MarcaResponse> respuesta;
        try {
            marcaResponse = marcaService.deleteMarca(idMarca);
            marcaResponse.setMensaje(mensajeAfirmativo);
            respuesta = new ResponseEntity<MarcaResponse>(marcaResponse, HttpStatus.OK);
        } catch (Exception e) {
            marcaResponse.setMensaje(mensajeNegativo);
            respuesta = new ResponseEntity<MarcaResponse>(marcaResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
}
