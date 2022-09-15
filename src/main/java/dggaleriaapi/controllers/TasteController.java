package dggaleriaapi.controllers;

import dggaleriaapi.models.Taste;
import dggaleriaapi.responses.StockDataResponse;
import dggaleriaapi.services.TasteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/tastees")
public class TasteController {

    @Autowired
    TasteService tasteService;

    @GetMapping
    public ResponseEntity<StockDataResponse<Taste>> getAll() {
        String successMessage = "tastees encontrados";
        String badMessage = "error al buscar tastees";
        StockDataResponse<Taste>  brandResponse = new StockDataResponse<Taste> ();
        ResponseEntity<StockDataResponse<Taste>> response;
        try {
            brandResponse = tasteService.getAll();
            brandResponse.setMessage(successMessage);
            response = new ResponseEntity<>(brandResponse, HttpStatus.OK);
        } catch (Exception e) {
            brandResponse.setMessage(badMessage);
            response = new ResponseEntity<>(brandResponse, HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @PostMapping
    public ResponseEntity<StockDataResponse<Taste>> save(@RequestBody Taste taste) {
        String successMessage = "taste creado";
        String badMessage = "error al crear taste";
        StockDataResponse<Taste>  brandResponse = new StockDataResponse<Taste> ();
        ResponseEntity<StockDataResponse<Taste>> response;
        try {
            brandResponse = tasteService.save(taste);
            brandResponse.setMessage(successMessage);
            response = new ResponseEntity<>(brandResponse, HttpStatus.OK);
        } catch (Exception e) {
            brandResponse.setMessage(badMessage);
            response = new ResponseEntity<>(brandResponse, HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @PostMapping(value = "/monton")
    public ResponseEntity<StockDataResponse<Taste>> savePorMonton(@RequestBody List<Taste> tastees) {
        String successMessage = "tastees creados";
        String badMessage = "error al crear tastees";
        StockDataResponse<Taste>  brandResponse = new StockDataResponse<Taste> ();
        ResponseEntity<StockDataResponse<Taste>> response;
        try {
            brandResponse = tasteService.savePorMonton(tastees);
            brandResponse.setMessage(successMessage);
            response = new ResponseEntity<>(brandResponse, HttpStatus.OK);
        } catch (Exception e) {
            brandResponse.setMessage(badMessage);
            response = new ResponseEntity<>(brandResponse, HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @PutMapping
    public ResponseEntity<StockDataResponse<Taste>>  update(@RequestBody Taste taste) {
        String successMessage = "taste actualizado";
        String badMessage = "error al actualizar taste";
        StockDataResponse<Taste>  brandResponse = new StockDataResponse<Taste> ();
        ResponseEntity<StockDataResponse<Taste>> response;
        try {
            brandResponse = tasteService.update(taste);
            brandResponse.setMessage(successMessage);
            response = new ResponseEntity<>(brandResponse, HttpStatus.OK);
        } catch (Exception e) {
            brandResponse.setMessage(badMessage);
            response = new ResponseEntity<>(brandResponse, HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @DeleteMapping
    public ResponseEntity<StockDataResponse<Taste>> delete(@RequestBody Taste taste) {
        String successMessage = "taste eliminado";
        String badMessage = "error al eliminar taste";
        StockDataResponse<Taste>  brandResponse = new StockDataResponse<Taste> ();
        ResponseEntity<StockDataResponse<Taste>> response;
        try {
            brandResponse = tasteService.delete(taste);
            brandResponse.setMessage(successMessage);
            response = new ResponseEntity<>(brandResponse, HttpStatus.OK);
        } catch (Exception e) {
            brandResponse.setMessage(badMessage);
            response = new ResponseEntity<>(brandResponse, HttpStatus.BAD_REQUEST);
        }
        return response;
    }
}
