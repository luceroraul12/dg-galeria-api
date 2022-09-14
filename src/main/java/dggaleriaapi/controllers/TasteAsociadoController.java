package dggaleriaapi.controllers;

import dggaleriaapi.models.TasteAsociado;
import dggaleriaapi.responses.TasteAsociadoResponse;
import dggaleriaapi.services.TasteAsociadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/tastees-asociados")
public class TasteAsociadoController {

    @Autowired
    TasteAsociadoService tasteAsociadoService;

    @GetMapping
    public ResponseEntity<TasteAsociadoResponse> getAll() {
        String successMessage = "tastees asociados encontrados";
        String badMessage = "error al buscar tastees asociados";
        TasteAsociadoResponse tasteAsociadoResponse = new TasteAsociadoResponse();
        ResponseEntity<TasteAsociadoResponse> respuesta;
        try {
            tasteAsociadoResponse = tasteAsociadoService.getAll();
            tasteAsociadoResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<TasteAsociadoResponse>(tasteAsociadoResponse, HttpStatus.OK);
        } catch (Exception e) {
            tasteAsociadoResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<TasteAsociadoResponse>(tasteAsociadoResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    @GetMapping(value = "/por-brand")
    public ResponseEntity<TasteAsociadoResponse> getAllByIdBrand(@RequestParam(name = "id") Long idBrand) {
        String successMessage = "tastees asociados por brand encontrados";
        String badMessage = "error al buscar tastees asociados por brand";
        TasteAsociadoResponse tasteAsociadoResponse = new TasteAsociadoResponse();
        ResponseEntity<TasteAsociadoResponse> respuesta;
        try {
            tasteAsociadoResponse = tasteAsociadoService.getAllByIdBrand(idBrand);
            tasteAsociadoResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<TasteAsociadoResponse>(tasteAsociadoResponse, HttpStatus.OK);
        } catch (Exception e) {
            tasteAsociadoResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<TasteAsociadoResponse>(tasteAsociadoResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    @PostMapping
    public ResponseEntity<TasteAsociadoResponse> save(@RequestBody TasteAsociado tasteAsociado) {
        String successMessage = "taste asociado creado";
        String badMessage = "error al crear taste asociado";
        TasteAsociadoResponse tasteAsociadoResponse = new TasteAsociadoResponse();
        ResponseEntity<TasteAsociadoResponse> respuesta;
        try {
            tasteAsociadoResponse = tasteAsociadoService.save(tasteAsociado);
            tasteAsociadoResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<TasteAsociadoResponse>(tasteAsociadoResponse, HttpStatus.OK);
        } catch (Exception e) {
            tasteAsociadoResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<TasteAsociadoResponse>(tasteAsociadoResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    @PostMapping(value = "/monton")
    public ResponseEntity<TasteAsociadoResponse> savePorMonton(@RequestBody List<TasteAsociado> tasteesAsociados) {
        String successMessage = "tastees asociados por brand creados";
        String badMessage = "error al crear tastees asociados";
        TasteAsociadoResponse tasteAsociadoResponse = new TasteAsociadoResponse();
        ResponseEntity<TasteAsociadoResponse> respuesta;
        try {
            tasteAsociadoResponse = tasteAsociadoService.savePorMonton(tasteesAsociados);
            tasteAsociadoResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<TasteAsociadoResponse>(tasteAsociadoResponse, HttpStatus.OK);
        } catch (Exception e) {
            tasteAsociadoResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<TasteAsociadoResponse>(tasteAsociadoResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    @PutMapping
    public ResponseEntity<TasteAsociadoResponse> update(@RequestBody TasteAsociado tasteAsociado) {
        String successMessage = "taste asociado actualizado";
        String badMessage = "error al actualizar taste asociado";
        TasteAsociadoResponse tasteAsociadoResponse = new TasteAsociadoResponse();
        ResponseEntity<TasteAsociadoResponse> respuesta;
        try {
            tasteAsociadoResponse = tasteAsociadoService.update(tasteAsociado);
            tasteAsociadoResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<TasteAsociadoResponse>(tasteAsociadoResponse, HttpStatus.OK);
        } catch (Exception e) {
            tasteAsociadoResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<TasteAsociadoResponse>(tasteAsociadoResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    @DeleteMapping
    public ResponseEntity<TasteAsociadoResponse> delete(@RequestBody TasteAsociado tasteAsociado) {
        String successMessage = "taste asociado eliminado";
        String badMessage = "error al eliminar taste asociado";
        TasteAsociadoResponse tasteAsociadoResponse = new TasteAsociadoResponse();
        ResponseEntity<TasteAsociadoResponse> respuesta;
        try {
            tasteAsociadoResponse = tasteAsociadoService.delete(tasteAsociado);
            tasteAsociadoResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<TasteAsociadoResponse>(tasteAsociadoResponse, HttpStatus.OK);
        } catch (Exception e) {
            tasteAsociadoResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<TasteAsociadoResponse>(tasteAsociadoResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
}
