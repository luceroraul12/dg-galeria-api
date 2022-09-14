package dggaleriaapi.controllers;

import dggaleriaapi.models.BrandedTaste;
import dggaleriaapi.responses.BrandedTasteResponse;
import dggaleriaapi.services.BrandedTasteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/branded-taste")
public class BrandedTasteController {

    @Autowired
    BrandedTasteService brandedTasteService;

    @GetMapping
    public ResponseEntity<BrandedTasteResponse> getAll() {
        String successMessage = "tastees asociados encontrados";
        String badMessage = "error al buscar tastees asociados";
        BrandedTasteResponse brandedTasteResponse = new BrandedTasteResponse();
        ResponseEntity<BrandedTasteResponse> respuesta;
        try {
            brandedTasteResponse = brandedTasteService.getAll();
            brandedTasteResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<BrandedTasteResponse>(brandedTasteResponse, HttpStatus.OK);
        } catch (Exception e) {
            brandedTasteResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<BrandedTasteResponse>(brandedTasteResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    @GetMapping(value = "/por-brand")
    public ResponseEntity<BrandedTasteResponse> getAllByIdBrand(@RequestParam(name = "id") Long idBrand) {
        String successMessage = "tastees asociados por brand encontrados";
        String badMessage = "error al buscar tastees asociados por brand";
        BrandedTasteResponse brandedTasteResponse = new BrandedTasteResponse();
        ResponseEntity<BrandedTasteResponse> respuesta;
        try {
            brandedTasteResponse = brandedTasteService.getAllByIdBrand(idBrand);
            brandedTasteResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<BrandedTasteResponse>(brandedTasteResponse, HttpStatus.OK);
        } catch (Exception e) {
            brandedTasteResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<BrandedTasteResponse>(brandedTasteResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    @PostMapping
    public ResponseEntity<BrandedTasteResponse> save(@RequestBody BrandedTaste brandedTaste) {
        String successMessage = "taste asociado creado";
        String badMessage = "error al crear taste asociado";
        BrandedTasteResponse brandedTasteResponse = new BrandedTasteResponse();
        ResponseEntity<BrandedTasteResponse> respuesta;
        try {
            brandedTasteResponse = brandedTasteService.save(brandedTaste);
            brandedTasteResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<BrandedTasteResponse>(brandedTasteResponse, HttpStatus.OK);
        } catch (Exception e) {
            brandedTasteResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<BrandedTasteResponse>(brandedTasteResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    @PostMapping(value = "/monton")
    public ResponseEntity<BrandedTasteResponse> savePorMonton(@RequestBody List<BrandedTaste> tasteesAsociados) {
        String successMessage = "tastees asociados por brand creados";
        String badMessage = "error al crear tastees asociados";
        BrandedTasteResponse brandedTasteResponse = new BrandedTasteResponse();
        ResponseEntity<BrandedTasteResponse> respuesta;
        try {
            brandedTasteResponse = brandedTasteService.savePorMonton(tasteesAsociados);
            brandedTasteResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<BrandedTasteResponse>(brandedTasteResponse, HttpStatus.OK);
        } catch (Exception e) {
            brandedTasteResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<BrandedTasteResponse>(brandedTasteResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    @PutMapping
    public ResponseEntity<BrandedTasteResponse> update(@RequestBody BrandedTaste brandedTaste) {
        String successMessage = "taste asociado actualizado";
        String badMessage = "error al actualizar taste asociado";
        BrandedTasteResponse brandedTasteResponse = new BrandedTasteResponse();
        ResponseEntity<BrandedTasteResponse> respuesta;
        try {
            brandedTasteResponse = brandedTasteService.update(brandedTaste);
            brandedTasteResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<BrandedTasteResponse>(brandedTasteResponse, HttpStatus.OK);
        } catch (Exception e) {
            brandedTasteResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<BrandedTasteResponse>(brandedTasteResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    @DeleteMapping
    public ResponseEntity<BrandedTasteResponse> delete(@RequestBody BrandedTaste brandedTaste) {
        String successMessage = "taste asociado eliminado";
        String badMessage = "error al eliminar taste asociado";
        BrandedTasteResponse brandedTasteResponse = new BrandedTasteResponse();
        ResponseEntity<BrandedTasteResponse> respuesta;
        try {
            brandedTasteResponse = brandedTasteService.delete(brandedTaste);
            brandedTasteResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<BrandedTasteResponse>(brandedTasteResponse, HttpStatus.OK);
        } catch (Exception e) {
            brandedTasteResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<BrandedTasteResponse>(brandedTasteResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
}
