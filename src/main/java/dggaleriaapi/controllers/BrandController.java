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
        String mensajeAfirmativo = "brands obtenidas";
        String mensajeNegativo = "error al adquirir brands";
        BrandResponse brandResponse = new BrandResponse();
        ResponseEntity<BrandResponse> respuesta;
        try {
            brandResponse = brandService.getAll();
            brandResponse.setMensaje(mensajeAfirmativo);
            respuesta = new ResponseEntity<BrandResponse>(brandResponse, HttpStatus.OK);
        } catch (Exception e) {
            brandResponse.setMensaje(mensajeNegativo);
            respuesta = new ResponseEntity<BrandResponse>(brandResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @GetMapping(value = "/by-id")
    public ResponseEntity<BrandResponse> getBrandById(@RequestParam(name = "id") Long idBrand) {
        String mensajeAfirmativo = "brands obtenidas por id";
        String mensajeNegativo = "error al adquirir brands por id";
        BrandResponse brandResponse = new BrandResponse();
        ResponseEntity<BrandResponse> respuesta;
        try {
            brandResponse = brandService.getBrandById(idBrand);
            brandResponse.setMensaje(mensajeAfirmativo);
            respuesta = new ResponseEntity<BrandResponse>(brandResponse, HttpStatus.OK);
        } catch (Exception e) {
            brandResponse.setMensaje(mensajeNegativo);
            respuesta = new ResponseEntity<BrandResponse>(brandResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @PostMapping
    public ResponseEntity<BrandResponse> saveBrand(@RequestBody Brand brand) {
        String mensajeAfirmativo = "brand guardada";
        String mensajeNegativo = "error al guardar brand";
        BrandResponse brandResponse = new BrandResponse();
        ResponseEntity<BrandResponse> respuesta;
        try {
            brandResponse = brandService.saveBrand(brand);
            brandResponse.setMensaje(mensajeAfirmativo);
            respuesta = new ResponseEntity<BrandResponse>(brandResponse, HttpStatus.OK);
        } catch (Exception e) {
            brandResponse.setMensaje(mensajeNegativo);
            respuesta = new ResponseEntity<BrandResponse>(brandResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @PutMapping
    public ResponseEntity<BrandResponse> updateBrand(@RequestBody Brand brand) {
        String mensajeAfirmativo = "brand actualizada";
        String mensajeNegativo = "error al actualizar brand";
        BrandResponse brandResponse = new BrandResponse();
        ResponseEntity<BrandResponse> respuesta;
        try {
            brandResponse = brandService.updateBrand(brand);
            brandResponse.setMensaje(mensajeAfirmativo);
            respuesta = new ResponseEntity<BrandResponse>(brandResponse, HttpStatus.OK);
        } catch (Exception e) {
            brandResponse.setMensaje(mensajeNegativo);
            respuesta = new ResponseEntity<BrandResponse>(brandResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @DeleteMapping
    public ResponseEntity<BrandResponse> deleteBrand(@RequestParam(name = "id") Long idBrand) {
        String mensajeAfirmativo = "brand eliminada";
        String mensajeNegativo = "error al eliminar brand";
        BrandResponse brandResponse = new BrandResponse();
        ResponseEntity<BrandResponse> respuesta;
        try {
            brandResponse = brandService.deleteBrand(idBrand);
            brandResponse.setMensaje(mensajeAfirmativo);
            respuesta = new ResponseEntity<BrandResponse>(brandResponse, HttpStatus.OK);
        } catch (Exception e) {
            brandResponse.setMensaje(mensajeNegativo);
            respuesta = new ResponseEntity<BrandResponse>(brandResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
}
