package dggaleriaapi.controllers;

import dggaleriaapi.models.BrandHasTaste;
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
    public ResponseEntity<StockDataResponse<BrandHasTaste>> getAll() {
        String successMessage = "tastees asociados encontrados";
        String badMessage = "error al buscar tastees asociados";
        StockDataResponse<BrandHasTaste>  brandResponse = new StockDataResponse<>();
        ResponseEntity<StockDataResponse<BrandHasTaste>> response;
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
    public ResponseEntity<StockDataResponse<BrandHasTaste>> getAllByIdBrand(@RequestBody BrandHasTaste brandHasTaste) {
        String successMessage = "tastees asociados por brand encontrados";
        String badMessage = "error al buscar tastees asociados por brand";
        StockDataResponse<BrandHasTaste>  brandResponse = new StockDataResponse<>();
        ResponseEntity<StockDataResponse<BrandHasTaste>> response;
        try {
            brandResponse = brandedTasteService.getAllByIdBrand(brandHasTaste);
            brandResponse.setMessage(successMessage);
            response = new ResponseEntity<>(brandResponse, HttpStatus.OK);
        } catch (Exception e) {
            brandResponse.setMessage(badMessage);
            response = new ResponseEntity<>(brandResponse, HttpStatus.BAD_REQUEST);
        }
        return response;
    }
    @PostMapping
    public ResponseEntity<StockDataResponse<BrandHasTaste>> save(@RequestBody BrandHasTaste brandHasTaste) {
        String successMessage = "taste asociado creado";
        String badMessage = "error al crear taste asociado";
        StockDataResponse<BrandHasTaste>  brandResponse = new StockDataResponse<>();
        ResponseEntity<StockDataResponse<BrandHasTaste>> response;
        try {
            brandResponse = brandedTasteService.save(brandHasTaste);
            brandResponse.setMessage(successMessage);
            response = new ResponseEntity<>(brandResponse, HttpStatus.OK);
        } catch (Exception e) {
            brandResponse.setMessage(badMessage);
            response = new ResponseEntity<>(brandResponse, HttpStatus.BAD_REQUEST);
        }
        return response;
    }
    @PostMapping(value = "/monton")
    public ResponseEntity<StockDataResponse<BrandHasTaste>> savePorMonton(@RequestBody List<BrandHasTaste> brandHasTastes) {
        String successMessage = "tastees asociados por brand creados";
        String badMessage = "error al crear tastees asociados";
        StockDataResponse<BrandHasTaste>  brandResponse = new StockDataResponse<>();
        ResponseEntity<StockDataResponse<BrandHasTaste>> response;
        try {
            brandResponse = brandedTasteService.savePorMonton(brandHasTastes);
            brandResponse.setMessage(successMessage);
            response = new ResponseEntity<>(brandResponse, HttpStatus.OK);
        } catch (Exception e) {
            brandResponse.setMessage(badMessage);
            response = new ResponseEntity<>(brandResponse, HttpStatus.BAD_REQUEST);
        }
        return response;
    }
    @PutMapping
    public ResponseEntity<StockDataResponse<BrandHasTaste>> update(@RequestBody BrandHasTaste brandHasTaste) {
        String successMessage = "taste asociado actualizado";
        String badMessage = "error al actualizar taste asociado";
        StockDataResponse<BrandHasTaste>  brandResponse = new StockDataResponse<>();
        ResponseEntity<StockDataResponse<BrandHasTaste>> response;
        try {
            brandResponse = brandedTasteService.update(brandHasTaste);
            brandResponse.setMessage(successMessage);
            response = new ResponseEntity<>(brandResponse, HttpStatus.OK);
        } catch (Exception e) {
            brandResponse.setMessage(badMessage);
            response = new ResponseEntity<>(brandResponse, HttpStatus.BAD_REQUEST);
        }
        return response;
    }
    @PatchMapping
    public ResponseEntity<StockDataResponse<BrandHasTaste>> changeStockState(@RequestBody BrandHasTaste brandHasTaste) {
        String successMessage = "taste asociado actualizado";
        String badMessage = "error al actualizar taste asociado";
        StockDataResponse<BrandHasTaste>  brandResponse = new StockDataResponse<>();
        ResponseEntity<StockDataResponse<BrandHasTaste>> response;
        try {
            brandResponse = brandedTasteService.changeStockState(brandHasTaste);
            brandResponse.setMessage(successMessage);
            response = new ResponseEntity<>(brandResponse, HttpStatus.OK);
        } catch (Exception e) {
            brandResponse.setMessage(badMessage);
            response = new ResponseEntity<>(brandResponse, HttpStatus.BAD_REQUEST);
        }
        return response;
    }
    @DeleteMapping
    public ResponseEntity<StockDataResponse<BrandHasTaste>> delete(@RequestBody BrandHasTaste brandHasTaste) {
        String successMessage = "taste asociado eliminado";
        String badMessage = "error al eliminar taste asociado";
        StockDataResponse<BrandHasTaste>  brandResponse = new StockDataResponse<>();
        ResponseEntity<StockDataResponse<BrandHasTaste>> response;
        try {
            brandResponse = brandedTasteService.delete(brandHasTaste);
            brandResponse.setMessage(successMessage);
            response = new ResponseEntity<>(brandResponse, HttpStatus.OK);
        } catch (Exception e) {
            brandResponse.setMessage(badMessage);
            response = new ResponseEntity<>(brandResponse, HttpStatus.BAD_REQUEST);
        }
        return response;
    }
}
