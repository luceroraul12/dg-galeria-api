package dggaleriaapi.controllers;

import dggaleriaapi.models.Brand;
import dggaleriaapi.responses.ClienteDTOResponse;
import dggaleriaapi.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    ClienteService service;
    
    @GetMapping
    public ResponseEntity<ClienteDTOResponse> getResumenByIdBrand(@RequestParam(name = "id-brand") Long idBrand){
        ClienteDTOResponse resultado;
        ResponseEntity<ClienteDTOResponse> respuesta;

        String mensajeAfirmativo = "resumen obtenido";
        String mensajeNegativo = "error al obtener resumen";

        Brand brand = new Brand();
        brand.setId(idBrand);

        try {
            resultado = service.obtenerResumenPorBrand(brand);
            resultado.setMensaje(mensajeAfirmativo);
            respuesta = new ResponseEntity<>(resultado, HttpStatus.OK);
        } catch (Exception e) {
            resultado = new ClienteDTOResponse();
            resultado.setMensaje(mensajeNegativo);
            respuesta = new ResponseEntity<>(resultado, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

}
