package dggaleriaapi.controllers;

import dggaleriaapi.models.Brand;
import dggaleriaapi.responses.BrandResponse;
import dggaleriaapi.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "brands")
public class BrandController {

    @Autowired
    BrandService brandService;

    @GetMapping
    public ResponseEntity<BrandResponse> getAll() {
        String successMessage = "brands obtenidas";
        String badMessage = "error al adquirir brands";
        BrandResponse brandResponse = new BrandResponse();
        ResponseEntity<BrandResponse> respuesta;
        try {
            brandResponse = brandService.getAll();
            brandResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<BrandResponse>(brandResponse, HttpStatus.OK);
        } catch (Exception e) {
            brandResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<BrandResponse>(brandResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @GetMapping(value = "/by-id")
    public ResponseEntity<BrandResponse> getBrandById(@RequestParam(name = "id") Long idBrand) {
        String successMessage = "brands obtenidas por id";
        String badMessage = "error al adquirir brands por id";
        BrandResponse brandResponse = new BrandResponse();
        ResponseEntity<BrandResponse> respuesta;
        try {
            brandResponse = brandService.getBrandById(idBrand);
            brandResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<BrandResponse>(brandResponse, HttpStatus.OK);
        } catch (Exception e) {
            brandResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<BrandResponse>(brandResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @PostMapping
    public ResponseEntity<BrandResponse> saveBrand(@RequestBody Brand brand) {
        String successMessage = "brand guardada";
        String badMessage = "error al guardar brand";
        BrandResponse brandResponse = new BrandResponse();
        ResponseEntity<BrandResponse> respuesta;
        try {
            brandResponse = brandService.saveBrand(brand);
            brandResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<BrandResponse>(brandResponse, HttpStatus.OK);
        } catch (Exception e) {
            brandResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<BrandResponse>(brandResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @PutMapping
    public ResponseEntity<BrandResponse> updateBrand(@RequestBody Brand brand) {
        String successMessage = "brand actualizada";
        String badMessage = "error al actualizar brand";
        BrandResponse brandResponse = new BrandResponse();
        ResponseEntity<BrandResponse> respuesta;
        try {
            brandResponse = brandService.updateBrand(brand);
            brandResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<BrandResponse>(brandResponse, HttpStatus.OK);
        } catch (Exception e) {
            brandResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<BrandResponse>(brandResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @DeleteMapping
    public ResponseEntity<BrandResponse> deleteBrand(@RequestParam(name = "id") Long idBrand) {
        String successMessage = "brand eliminada";
        String badMessage = "error al eliminar brand";
        BrandResponse brandResponse = new BrandResponse();
        ResponseEntity<BrandResponse> respuesta;
        try {
            brandResponse = brandService.deleteBrand(idBrand);
            brandResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<BrandResponse>(brandResponse, HttpStatus.OK);
        } catch (Exception e) {
            brandResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<BrandResponse>(brandResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
}
