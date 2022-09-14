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
        String mensajeAfirmativo = "drinkContainer guardado";
        String mensajeNegativo = "error al intentar guardar drinkContainer";
        DrinkContainerResponse drinkContainerResponse = new DrinkContainerResponse();
        ResponseEntity<DrinkContainerResponse> respuesta;
        try {
            drinkContainerResponse = drinkContainerService.saveDrinkContainer(containerName);
            drinkContainerResponse.setMensaje(mensajeAfirmativo);
            respuesta = new ResponseEntity<DrinkContainerResponse>(drinkContainerResponse, HttpStatus.OK);
        } catch (Exception e) {
            drinkContainerResponse.setMensaje(mensajeNegativo);
            respuesta = new ResponseEntity<DrinkContainerResponse>(drinkContainerResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    @PutMapping
    public ResponseEntity<DrinkContainerResponse> updateDrinkContainer(@RequestBody DrinkContainer drinkContainer) {
        String mensajeAfirmativo = "drinkContainer actualizado";
        String mensajeNegativo = "error al intentar actualizar drinkContainer";
        DrinkContainerResponse drinkContainerResponse = new DrinkContainerResponse();
        ResponseEntity<DrinkContainerResponse> respuesta;
        try {
            drinkContainerResponse = drinkContainerService.updateDrinkContainer(drinkContainer);
            drinkContainerResponse.setMensaje(mensajeAfirmativo);
            respuesta = new ResponseEntity<DrinkContainerResponse>(drinkContainerResponse, HttpStatus.OK);
        } catch (Exception e) {
            drinkContainerResponse.setMensaje(mensajeNegativo);
            respuesta = new ResponseEntity<DrinkContainerResponse>(drinkContainerResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @DeleteMapping
    public ResponseEntity<DrinkContainerResponse> deleteDrinkContainer(@RequestParam(value = "id") Long idDrinkContainer) {
        String mensajeAfirmativo = "drinkContainer eliminado";
        String mensajeNegativo = "error al intentar eliminar drinkContainer";
        DrinkContainerResponse drinkContainerResponse = new DrinkContainerResponse();
        ResponseEntity<DrinkContainerResponse> respuesta;
        try {
            drinkContainerResponse = drinkContainerService.deleteDrinkContainer(idDrinkContainer);
            drinkContainerResponse.setMensaje(mensajeAfirmativo);
            respuesta = new ResponseEntity<DrinkContainerResponse>(drinkContainerResponse, HttpStatus.OK);
        } catch (Exception e) {
            drinkContainerResponse.setMensaje(mensajeNegativo);
            respuesta = new ResponseEntity<DrinkContainerResponse>(drinkContainerResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
}
