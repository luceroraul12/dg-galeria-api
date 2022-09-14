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
@RequestMapping(value = "/drink-containers")
public class DrinkContainerController {

    @Autowired
    DrinkContainerService drinkContainerService;

    @GetMapping
    public ResponseEntity<StockDataResponse<DrinkContainer>> getAllDrinkContainers() {
        String succesMessage = "drinkContainers obtenidos";
        String badMessage = "error al adquirir drinkContainers";
        StockDataResponse<DrinkContainer>  drinkContainerResponse = new StockDataResponse<DrinkContainer> ();
        ResponseEntity<StockDataResponse<DrinkContainer>> response;
        try {
            drinkContainerResponse = drinkContainerService.getAllDrinkContainers();
            drinkContainerResponse.setMessage(succesMessage);
            response = new ResponseEntity<>(drinkContainerResponse, HttpStatus.OK);
        } catch (Exception e) {
            drinkContainerResponse.setMessage(badMessage);
            response = new ResponseEntity<>(drinkContainerResponse, HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @PostMapping
    public ResponseEntity<StockDataResponse<DrinkContainer>> saveDrinkContainer(@RequestBody DrinkContainer drinkContainer) {
        String succesMessage = "drinkContainer guardado";
        String badMessage = "error al guardar drinkContainer";
        StockDataResponse<DrinkContainer>  drinkContainerResponse = new StockDataResponse<DrinkContainer> ();
        ResponseEntity<StockDataResponse<DrinkContainer>> response;
        try {
            drinkContainerResponse = drinkContainerService.saveDrinkContainer(drinkContainer);
            drinkContainerResponse.setMessage(succesMessage);
            response = new ResponseEntity<>(drinkContainerResponse, HttpStatus.OK);
        } catch (Exception e) {
            drinkContainerResponse.setMessage(badMessage);
            response = new ResponseEntity<>(drinkContainerResponse, HttpStatus.BAD_REQUEST);
        }
        return response;
    }
    @PutMapping
    public ResponseEntity<StockDataResponse<DrinkContainer>> updateDrinkContainer(@RequestBody DrinkContainer drinkContainer) {
        String succesMessage = "drinkContainer actualizado";
        String badMessage = "error al actualizar drinkContainer";
        StockDataResponse<DrinkContainer>  drinkContainerResponse = new StockDataResponse<DrinkContainer> ();
        ResponseEntity<StockDataResponse<DrinkContainer>> response;
        try {
            drinkContainerResponse = drinkContainerService.updateDrinkContainer(drinkContainer);
            drinkContainerResponse.setMessage(succesMessage);
            response = new ResponseEntity<>(drinkContainerResponse, HttpStatus.OK);
        } catch (Exception e) {
            drinkContainerResponse.setMessage(badMessage);
            response = new ResponseEntity<>(drinkContainerResponse, HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @DeleteMapping
    public ResponseEntity<StockDataResponse<DrinkContainer>> deleteDrinkContainer(@RequestBody DrinkContainer drinkContainer) {
        String succesMessage = "drinkContainer eliminado";
        String badMessage = "error al eliminar drinkContainer";
        StockDataResponse<DrinkContainer>  drinkContainerResponse = new StockDataResponse<DrinkContainer> ();
        ResponseEntity<StockDataResponse<DrinkContainer>> response;
        try {
            drinkContainerResponse = drinkContainerService.deleteDrinkContainer(drinkContainer);
            drinkContainerResponse.setMessage(succesMessage);
            response = new ResponseEntity<>(drinkContainerResponse, HttpStatus.OK);
        } catch (Exception e) {
            drinkContainerResponse.setMessage(badMessage);
            response = new ResponseEntity<>(drinkContainerResponse, HttpStatus.BAD_REQUEST);
        }
        return response;
    }
}
