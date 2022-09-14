package dggaleriaapi.controllers;

import dggaleriaapi.models.DrinkContainer;
import dggaleriaapi.responses.DrinkContainerResponse;
import dggaleriaapi.responses.StockDataResponse;
import dggaleriaapi.services.DrinkContainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/drinkcontainers")
public class DrinkContainerController {

    @Autowired
    DrinkContainerService drinkContainerService;

    @GetMapping
    public ResponseEntity<StockDataResponse<DrinkContainer>> getAllDrinkContainers() {
        String succesMessage = "drinkContainers obtenidos";
        String badMessage = "error al adquirir drinkContainers";
        StockDataResponse drinkContainerResponse = new StockDataResponse<>();
        ResponseEntity<StockDataResponse<DrinkContainer>> response;
        try {
            drinkContainerResponse = drinkContainerService.getAllDrinkContainers();
            drinkContainerResponse.setMessage(succesMessage);
            response = new ResponseEntity<StockDataResponse<DrinkContainer>>(drinkContainerResponse, HttpStatus.OK);
        } catch (Exception e) {
            drinkContainerResponse.setMessage(badMessage);
            response = new ResponseEntity<StockDataResponse<DrinkContainer>>(drinkContainerResponse, HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @PostMapping
    public ResponseEntity<DrinkContainerResponse> saveDrinkContainer(@RequestParam(name = "containerName") String containerName) {
        String successMessage = "drinkContainer guardado";
        String badMessage = "error al intentar guardar drinkContainer";
        DrinkContainerResponse drinkContainerResponse = new DrinkContainerResponse();
        ResponseEntity<DrinkContainerResponse> respuesta;
        try {
            drinkContainerResponse = drinkContainerService.saveDrinkContainer(containerName);
            drinkContainerResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<DrinkContainerResponse>(drinkContainerResponse, HttpStatus.OK);
        } catch (Exception e) {
            drinkContainerResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<DrinkContainerResponse>(drinkContainerResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    @PutMapping
    public ResponseEntity<DrinkContainerResponse> updateDrinkContainer(@RequestBody DrinkContainer drinkContainer) {
        String successMessage = "drinkContainer actualizado";
        String badMessage = "error al intentar actualizar drinkContainer";
        DrinkContainerResponse drinkContainerResponse = new DrinkContainerResponse();
        ResponseEntity<DrinkContainerResponse> respuesta;
        try {
            drinkContainerResponse = drinkContainerService.updateDrinkContainer(drinkContainer);
            drinkContainerResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<DrinkContainerResponse>(drinkContainerResponse, HttpStatus.OK);
        } catch (Exception e) {
            drinkContainerResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<DrinkContainerResponse>(drinkContainerResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @DeleteMapping
    public ResponseEntity<DrinkContainerResponse> deleteDrinkContainer(@RequestParam(value = "id") Long idDrinkContainer) {
        String successMessage = "drinkContainer eliminado";
        String badMessage = "error al intentar eliminar drinkContainer";
        DrinkContainerResponse drinkContainerResponse = new DrinkContainerResponse();
        ResponseEntity<DrinkContainerResponse> respuesta;
        try {
            drinkContainerResponse = drinkContainerService.deleteDrinkContainer(idDrinkContainer);
            drinkContainerResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<DrinkContainerResponse>(drinkContainerResponse, HttpStatus.OK);
        } catch (Exception e) {
            drinkContainerResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<DrinkContainerResponse>(drinkContainerResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
}
