package dggaleriaapi.controllers;

import dggaleriaapi.models.DrinkContaineredTaste;
import dggaleriaapi.responses.DrinkContaineredTasteResponse;
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
    public ResponseEntity<DrinkContaineredTasteResponse> getAll() {
        String successMessage = "tastees formateados encontrados";
        String badMessage = "error al buscar tastees formateados";
        DrinkContaineredTasteResponse drinkContaineredTasteResponse = new DrinkContaineredTasteResponse();
        ResponseEntity<DrinkContaineredTasteResponse> respuesta;
        try {
            drinkContaineredTasteResponse = drinkContaineredTasteService.getAll();
            drinkContaineredTasteResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<DrinkContaineredTasteResponse>(drinkContaineredTasteResponse, HttpStatus.OK);
        } catch (Exception e) {
            drinkContaineredTasteResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<DrinkContaineredTasteResponse>(drinkContaineredTasteResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    @GetMapping("/taste-asociado")
    public ResponseEntity<DrinkContaineredTasteResponse> getByBrandedTasteId(@RequestBody DrinkContaineredTaste drinkContaineredTaste) {
        String successMessage = "tastees encontrados";
        String badMessage = "error al buscar tastees";
        DrinkContaineredTasteResponse drinkContaineredTasteResponse = new DrinkContaineredTasteResponse();
        ResponseEntity<DrinkContaineredTasteResponse> respuesta;
        try {
            drinkContaineredTasteResponse = drinkContaineredTasteService.getByBrandedTasteId(drinkContaineredTaste);
            drinkContaineredTasteResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<DrinkContaineredTasteResponse>(drinkContaineredTasteResponse, HttpStatus.OK);
        } catch (Exception e) {
            drinkContaineredTasteResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<DrinkContaineredTasteResponse>(drinkContaineredTasteResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    @GetMapping("/por-brand")
    public ResponseEntity<DrinkContaineredTasteResponse> getAllByIdBrand(@RequestParam(name = "id") Long idBrand) {
        String successMessage = "tastees encontrados";
        String badMessage = "error al buscar tastees";
        DrinkContaineredTasteResponse drinkContaineredTasteResponse = new DrinkContaineredTasteResponse();
        ResponseEntity<DrinkContaineredTasteResponse> respuesta;
        try {
            drinkContaineredTasteResponse = drinkContaineredTasteService.getAllByIdBrand(idBrand);
            drinkContaineredTasteResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<DrinkContaineredTasteResponse>(drinkContaineredTasteResponse, HttpStatus.OK);
        } catch (Exception e) {
            drinkContaineredTasteResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<DrinkContaineredTasteResponse>(drinkContaineredTasteResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    @PostMapping
    public ResponseEntity<DrinkContaineredTasteResponse> save(@RequestBody DrinkContaineredTaste drinkContaineredTaste) {
        String successMessage = "taste creado";
        String badMessage = "error al crear taste";
        DrinkContaineredTasteResponse drinkContaineredTasteResponse = new DrinkContaineredTasteResponse();
        ResponseEntity<DrinkContaineredTasteResponse> respuesta;
        try {
            drinkContaineredTasteResponse = drinkContaineredTasteService.save(drinkContaineredTaste);
            drinkContaineredTasteResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<DrinkContaineredTasteResponse>(drinkContaineredTasteResponse, HttpStatus.OK);
        } catch (Exception e) {
            drinkContaineredTasteResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<DrinkContaineredTasteResponse>(drinkContaineredTasteResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    @PostMapping("/save-inicial")
    public ResponseEntity<DrinkContaineredTasteResponse> saveInicial(@RequestBody DrinkContaineredTaste drinkContaineredTaste) {
        String successMessage = "tastees formateados creados inicialmente";
        String badMessage = "error al crear tastees formateados inicialmente";
        DrinkContaineredTasteResponse drinkContaineredTasteResponse = new DrinkContaineredTasteResponse();
        ResponseEntity<DrinkContaineredTasteResponse> respuesta;
        try {
            drinkContaineredTasteResponse = drinkContaineredTasteService.saveInicial(drinkContaineredTaste);
            drinkContaineredTasteResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<DrinkContaineredTasteResponse>(drinkContaineredTasteResponse, HttpStatus.OK);
        } catch (Exception e) {
            drinkContaineredTasteResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<DrinkContaineredTasteResponse>(drinkContaineredTasteResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @PostMapping("/save-monton")
    public ResponseEntity<DrinkContaineredTasteResponse> savePorMonton(@RequestBody List<DrinkContaineredTaste> tasteesFormateados) {
        String successMessage = "tastees formateados por monton creados";
        String badMessage = "error al crear tastees formateados por monton";
        DrinkContaineredTasteResponse drinkContaineredTasteResponse = new DrinkContaineredTasteResponse();
        ResponseEntity<DrinkContaineredTasteResponse> respuesta;
        try {
            drinkContaineredTasteResponse = drinkContaineredTasteService.savePorMonton(tasteesFormateados);
            drinkContaineredTasteResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<DrinkContaineredTasteResponse>(drinkContaineredTasteResponse, HttpStatus.OK);
        } catch (Exception e) {
            drinkContaineredTasteResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<DrinkContaineredTasteResponse>(drinkContaineredTasteResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @PostMapping("/save-monton-inicial")
    public ResponseEntity<DrinkContaineredTasteResponse> savePorMontonInicial(@RequestBody List<DrinkContaineredTaste> tasteesFormateados) {
        String successMessage = "tastees formateados por monton inicial creados";
        String badMessage = "error al crear tastees formateados inicial por monton";
        DrinkContaineredTasteResponse drinkContaineredTasteResponse = new DrinkContaineredTasteResponse();
        ResponseEntity<DrinkContaineredTasteResponse> respuesta;
        try {
            drinkContaineredTasteResponse = drinkContaineredTasteService.savePorMontonInicial(tasteesFormateados);
            drinkContaineredTasteResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<DrinkContaineredTasteResponse>(drinkContaineredTasteResponse, HttpStatus.OK);
        } catch (Exception e) {
            drinkContaineredTasteResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<DrinkContaineredTasteResponse>(drinkContaineredTasteResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    @PutMapping
    public ResponseEntity<DrinkContaineredTasteResponse> update(@RequestBody DrinkContaineredTaste drinkContaineredTaste) {
        String successMessage = "tastee formateado actualizado";
        String badMessage = "error al actualizar taste formateado";
        DrinkContaineredTasteResponse drinkContaineredTasteResponse = new DrinkContaineredTasteResponse();
        ResponseEntity<DrinkContaineredTasteResponse> respuesta;
        try {
            drinkContaineredTasteResponse = drinkContaineredTasteService.update(drinkContaineredTaste);
            drinkContaineredTasteResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<DrinkContaineredTasteResponse>(drinkContaineredTasteResponse, HttpStatus.OK);
        } catch (Exception e) {
            drinkContaineredTasteResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<DrinkContaineredTasteResponse>(drinkContaineredTasteResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @DeleteMapping
    public ResponseEntity<DrinkContaineredTasteResponse> delete(@RequestBody DrinkContaineredTaste drinkContaineredTaste) {
        String successMessage = "taste formateado eliminado";
        String badMessage = "error al borrar taste formateado";
        DrinkContaineredTasteResponse drinkContaineredTasteResponse = new DrinkContaineredTasteResponse();
        ResponseEntity<DrinkContaineredTasteResponse> respuesta;
        try {
            drinkContaineredTasteResponse = drinkContaineredTasteService.delete(drinkContaineredTaste);
            drinkContaineredTasteResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<DrinkContaineredTasteResponse>(drinkContaineredTasteResponse, HttpStatus.OK);
        } catch (Exception e) {
            drinkContaineredTasteResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<DrinkContaineredTasteResponse>(drinkContaineredTasteResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
}
