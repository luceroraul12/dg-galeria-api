package dggaleriaapi.controllers;

import dggaleriaapi.models.Brand;
import dggaleriaapi.models.BrandedTaste;
import dggaleriaapi.models.DrinkContaineredTaste;
import dggaleriaapi.responses.DrinkContaineredTasteResponse;
import dggaleriaapi.responses.StockDataResponse;
import dggaleriaapi.services.DrinkContaineredTasteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/drink-containered-taste")
public class DrinkContaineredTasteController {

    @Autowired
    DrinkContaineredTasteService drinkContaineredTasteService;

    @GetMapping
    public ResponseEntity<StockDataResponse<DrinkContaineredTaste>> getAll() {
        String successMessage = "tastees formateados encontrados";
        String badMessage = "error al buscar tastees formateados";
        StockDataResponse<DrinkContaineredTaste> drinkContaineredTasteResponse = new StockDataResponse<DrinkContaineredTaste>();
        ResponseEntity<StockDataResponse<DrinkContaineredTaste>> respuesta;
        try {
            drinkContaineredTasteResponse = drinkContaineredTasteService.getAll();
            drinkContaineredTasteResponse.setMessage(successMessage);
            respuesta = new ResponseEntity<StockDataResponse<DrinkContaineredTaste>>(drinkContaineredTasteResponse, HttpStatus.OK);
        } catch (Exception e) {
            drinkContaineredTasteResponse.setMessage(badMessage);
            respuesta = new ResponseEntity<StockDataResponse<DrinkContaineredTaste>>(drinkContaineredTasteResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    @GetMapping("/taste-asociado")
    public ResponseEntity<StockDataResponse<DrinkContaineredTaste>> getByBrandedTasteId(@RequestBody BrandedTaste brandedTaste) {
        String successMessage = "tastees encontrados";
        String badMessage = "error al buscar tastees";
        StockDataResponse<DrinkContaineredTaste> drinkContaineredTasteResponse = new StockDataResponse<DrinkContaineredTaste>();
        ResponseEntity<StockDataResponse<DrinkContaineredTaste>> respuesta;
        try {
            drinkContaineredTasteResponse = drinkContaineredTasteService.getByBrandedTasteId(brandedTaste);
            drinkContaineredTasteResponse.setMessage(successMessage);
            respuesta = new ResponseEntity<StockDataResponse<DrinkContaineredTaste>>(drinkContaineredTasteResponse, HttpStatus.OK);
        } catch (Exception e) {
            drinkContaineredTasteResponse.setMessage(badMessage);
            respuesta = new ResponseEntity<StockDataResponse<DrinkContaineredTaste>>(drinkContaineredTasteResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    @GetMapping("/por-brand")
    public ResponseEntity<StockDataResponse<DrinkContaineredTaste>> getAllByIdBrand(@RequestBody Brand brand) {
        String successMessage = "tastees encontrados";
        String badMessage = "error al buscar tastees";
        StockDataResponse<DrinkContaineredTaste> drinkContaineredTasteResponse = new StockDataResponse<DrinkContaineredTaste>();
        ResponseEntity<StockDataResponse<DrinkContaineredTaste>> respuesta;
        try {
            drinkContaineredTasteResponse = drinkContaineredTasteService.getAllByIdBrand(brand);
            drinkContaineredTasteResponse.setMessage(successMessage);
            respuesta = new ResponseEntity<StockDataResponse<DrinkContaineredTaste>>(drinkContaineredTasteResponse, HttpStatus.OK);
        } catch (Exception e) {
            drinkContaineredTasteResponse.setMessage(badMessage);
            respuesta = new ResponseEntity<StockDataResponse<DrinkContaineredTaste>>(drinkContaineredTasteResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    @PostMapping
    public ResponseEntity<StockDataResponse<DrinkContaineredTaste>> save(@RequestBody DrinkContaineredTaste drinkContaineredTaste) {
        String successMessage = "taste creado";
        String badMessage = "error al crear taste";
        StockDataResponse<DrinkContaineredTaste> drinkContaineredTasteResponse = new StockDataResponse<DrinkContaineredTaste>();
        ResponseEntity<StockDataResponse<DrinkContaineredTaste>> respuesta;
        try {
            drinkContaineredTasteResponse = drinkContaineredTasteService.save(drinkContaineredTaste);
            drinkContaineredTasteResponse.setMessage(successMessage);
            respuesta = new ResponseEntity<StockDataResponse<DrinkContaineredTaste>>(drinkContaineredTasteResponse, HttpStatus.OK);
        } catch (Exception e) {
            drinkContaineredTasteResponse.setMessage(badMessage);
            respuesta = new ResponseEntity<StockDataResponse<DrinkContaineredTaste>>(drinkContaineredTasteResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    @PostMapping("/save-inicial")
    public ResponseEntity<StockDataResponse<DrinkContaineredTaste>> saveInicial(@RequestBody DrinkContaineredTaste drinkContaineredTaste) {
        String successMessage = "tastees formateados creados inicialmente";
        String badMessage = "error al crear tastees formateados inicialmente";
        StockDataResponse<DrinkContaineredTaste> drinkContaineredTasteResponse = new StockDataResponse<DrinkContaineredTaste>();
        ResponseEntity<StockDataResponse<DrinkContaineredTaste>> respuesta;
        try {
            drinkContaineredTasteResponse = drinkContaineredTasteService.saveInicial(drinkContaineredTaste);
            drinkContaineredTasteResponse.setMessage(successMessage);
            respuesta = new ResponseEntity<StockDataResponse<DrinkContaineredTaste>>(drinkContaineredTasteResponse, HttpStatus.OK);
        } catch (Exception e) {
            drinkContaineredTasteResponse.setMessage(badMessage);
            respuesta = new ResponseEntity<StockDataResponse<DrinkContaineredTaste>>(drinkContaineredTasteResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @PostMapping("/save-monton")
    public ResponseEntity<StockDataResponse<DrinkContaineredTaste>> savePorMonton(@RequestBody List<DrinkContaineredTaste> tasteesFormateados) {
        String successMessage = "tastees formateados por monton creados";
        String badMessage = "error al crear tastees formateados por monton";
        StockDataResponse<DrinkContaineredTaste> drinkContaineredTasteResponse = new StockDataResponse<DrinkContaineredTaste>();
        ResponseEntity<StockDataResponse<DrinkContaineredTaste>> respuesta;
        try {
            drinkContaineredTasteResponse = drinkContaineredTasteService.savePorMonton(tasteesFormateados);
            drinkContaineredTasteResponse.setMessage(successMessage);
            respuesta = new ResponseEntity<StockDataResponse<DrinkContaineredTaste>>(drinkContaineredTasteResponse, HttpStatus.OK);
        } catch (Exception e) {
            drinkContaineredTasteResponse.setMessage(badMessage);
            respuesta = new ResponseEntity<StockDataResponse<DrinkContaineredTaste>>(drinkContaineredTasteResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @PostMapping("/save-monton-inicial")
    public ResponseEntity<StockDataResponse<DrinkContaineredTaste>> savePorMontonInicial(@RequestBody List<DrinkContaineredTaste> tasteesFormateados) {
        String successMessage = "tastees formateados por monton inicial creados";
        String badMessage = "error al crear tastees formateados inicial por monton";
        StockDataResponse<DrinkContaineredTaste> drinkContaineredTasteResponse = new StockDataResponse<DrinkContaineredTaste>();
        ResponseEntity<StockDataResponse<DrinkContaineredTaste>> respuesta;
        try {
            drinkContaineredTasteResponse = drinkContaineredTasteService.savePorMontonInicial(tasteesFormateados);
            drinkContaineredTasteResponse.setMessage(successMessage);
            respuesta = new ResponseEntity<StockDataResponse<DrinkContaineredTaste>>(drinkContaineredTasteResponse, HttpStatus.OK);
        } catch (Exception e) {
            drinkContaineredTasteResponse.setMessage(badMessage);
            respuesta = new ResponseEntity<StockDataResponse<DrinkContaineredTaste>>(drinkContaineredTasteResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    @PutMapping
    public ResponseEntity<StockDataResponse<DrinkContaineredTaste>> update(@RequestBody DrinkContaineredTaste drinkContaineredTaste) {
        String successMessage = "tastee formateado actualizado";
        String badMessage = "error al actualizar taste formateado";
        StockDataResponse<DrinkContaineredTaste> drinkContaineredTasteResponse = new StockDataResponse<DrinkContaineredTaste>();
        ResponseEntity<StockDataResponse<DrinkContaineredTaste>> respuesta;
        try {
            drinkContaineredTasteResponse = drinkContaineredTasteService.update(drinkContaineredTaste);
            drinkContaineredTasteResponse.setMessage(successMessage);
            respuesta = new ResponseEntity<StockDataResponse<DrinkContaineredTaste>>(drinkContaineredTasteResponse, HttpStatus.OK);
        } catch (Exception e) {
            drinkContaineredTasteResponse.setMessage(badMessage);
            respuesta = new ResponseEntity<StockDataResponse<DrinkContaineredTaste>>(drinkContaineredTasteResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @DeleteMapping
    public ResponseEntity<StockDataResponse<DrinkContaineredTaste>> delete(@RequestBody DrinkContaineredTaste drinkContaineredTaste) {
        String successMessage = "taste formateado eliminado";
        String badMessage = "error al borrar taste formateado";
        StockDataResponse<DrinkContaineredTaste> drinkContaineredTasteResponse = new StockDataResponse<DrinkContaineredTaste>();
        ResponseEntity<StockDataResponse<DrinkContaineredTaste>> respuesta;
        try {
            drinkContaineredTasteResponse = drinkContaineredTasteService.delete(drinkContaineredTaste);
            drinkContaineredTasteResponse.setMessage(successMessage);
            respuesta = new ResponseEntity<StockDataResponse<DrinkContaineredTaste>>(drinkContaineredTasteResponse, HttpStatus.OK);
        } catch (Exception e) {
            drinkContaineredTasteResponse.setMessage(badMessage);
            respuesta = new ResponseEntity<StockDataResponse<DrinkContaineredTaste>>(drinkContaineredTasteResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
}
