package dggaleriaapi.controllers;

import dggaleriaapi.models.BrandedTaste;
import dggaleriaapi.responses.StockDataResponse;
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
    public ResponseEntity<StockDataResponse<BrandedTaste>> getAll() {
        String successMessage = "tastees asociados encontrados";
        String badMessage = "error al buscar tastees asociados";
        StockDataResponse<BrandedTaste>  brandResponse = new StockDataResponse<BrandedTaste> ();
        ResponseEntity<StockDataResponse<BrandedTaste>> response;
        try {
            brandResponse = brandedTasteService.getAll();
            brandResponse.setMessage(successMessage);
            response = new ResponseEntity<>(brandResponse, HttpStatus.OK);
        } catch (Exception e) {
            brandResponse.setMessage(badMessage);
            response = new ResponseEntity<>(brandResponse, HttpStatus.BAD_REQUEST);
        }
        return response;
    }
    @GetMapping(value = "/id")
    public ResponseEntity<StockDataResponse<BrandedTaste>> getAllByIdBrand(@RequestBody BrandedTaste brandedTaste) {
        String successMessage = "tastees asociados por brand encontrados";
        String badMessage = "error al buscar tastees asociados por brand";
        StockDataResponse<BrandedTaste>  brandResponse = new StockDataResponse<BrandedTaste> ();
        ResponseEntity<StockDataResponse<BrandedTaste>> response;
        try {
            brandResponse = brandedTasteService.getAllByIdBrand(brandedTaste);
            brandResponse.setMessage(successMessage);
            response = new ResponseEntity<>(brandResponse, HttpStatus.OK);
        } catch (Exception e) {
            brandResponse.setMessage(badMessage);
            response = new ResponseEntity<>(brandResponse, HttpStatus.BAD_REQUEST);
        }
        return response;
    }
    @PostMapping
    public ResponseEntity<StockDataResponse<BrandedTaste>> save(@RequestBody BrandedTaste brandedTaste) {
        String successMessage = "taste asociado creado";
        String badMessage = "error al crear taste asociado";
        StockDataResponse<BrandedTaste>  brandResponse = new StockDataResponse<BrandedTaste> ();
        ResponseEntity<StockDataResponse<BrandedTaste>> response;
        try {
            brandResponse = brandedTasteService.save(brandedTaste);
            brandResponse.setMessage(successMessage);
            response = new ResponseEntity<>(brandResponse, HttpStatus.OK);
        } catch (Exception e) {
            brandResponse.setMessage(badMessage);
            response = new ResponseEntity<>(brandResponse, HttpStatus.BAD_REQUEST);
        }
        return response;
    }
    @PostMapping(value = "/monton")
    public ResponseEntity<StockDataResponse<BrandedTaste>> savePorMonton(@RequestBody List<BrandedTaste> brandedTastes) {
        String successMessage = "tastees asociados por brand creados";
        String badMessage = "error al crear tastees asociados";
        StockDataResponse<BrandedTaste>  brandResponse = new StockDataResponse<BrandedTaste> ();
        ResponseEntity<StockDataResponse<BrandedTaste>> response;
        try {
            brandResponse = brandedTasteService.savePorMonton(brandedTastes);
            brandResponse.setMessage(successMessage);
            response = new ResponseEntity<>(brandResponse, HttpStatus.OK);
        } catch (Exception e) {
            brandResponse.setMessage(badMessage);
            response = new ResponseEntity<>(brandResponse, HttpStatus.BAD_REQUEST);
        }
        return response;
    }
    @PutMapping
    public ResponseEntity<StockDataResponse<BrandedTaste>> update(@RequestBody BrandedTaste brandedTaste) {
        String successMessage = "taste asociado actualizado";
        String badMessage = "error al actualizar taste asociado";
        StockDataResponse<BrandedTaste>  brandResponse = new StockDataResponse<BrandedTaste> ();
        ResponseEntity<StockDataResponse<BrandedTaste>> response;
        try {
            brandResponse = brandedTasteService.update(brandedTaste);
            brandResponse.setMessage(successMessage);
            response = new ResponseEntity<>(brandResponse, HttpStatus.OK);
        } catch (Exception e) {
            brandResponse.setMessage(badMessage);
            response = new ResponseEntity<>(brandResponse, HttpStatus.BAD_REQUEST);
        }
        return response;
    }
    @DeleteMapping
    public ResponseEntity<StockDataResponse<BrandedTaste>> delete(@RequestBody BrandedTaste brandedTaste) {
        String successMessage = "taste asociado eliminado";
        String badMessage = "error al eliminar taste asociado";
        StockDataResponse<BrandedTaste>  brandResponse = new StockDataResponse<BrandedTaste> ();
        ResponseEntity<StockDataResponse<BrandedTaste>> response;
        try {
            brandResponse = brandedTasteService.delete(brandedTaste);
            brandResponse.setMessage(successMessage);
            response = new ResponseEntity<>(brandResponse, HttpStatus.OK);
        } catch (Exception e) {
            brandResponse.setMessage(badMessage);
            response = new ResponseEntity<>(brandResponse, HttpStatus.BAD_REQUEST);
        }
        return response;
    }
}
