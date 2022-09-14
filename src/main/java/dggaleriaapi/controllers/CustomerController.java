package dggaleriaapi.controllers;

import dggaleriaapi.models.Brand;
import dggaleriaapi.responses.CustomerDTOResponse;
import dggaleriaapi.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService service;
    
    @GetMapping
    public ResponseEntity<CustomerDTOResponse> getResumenByIdBrand(@RequestParam(name = "id-brand") Long idBrand){
        CustomerDTOResponse resultado;
        ResponseEntity<CustomerDTOResponse> respuesta;

        String successMessage = "resumen obtenido";
        String badMessage = "error al obtener resumen";

        Brand brand = new Brand();
        brand.setId(idBrand);

        try {
            resultado = service.obtenerResumenPorBrand(brand);
            resultado.setMensaje(successMessage);
            respuesta = new ResponseEntity<>(resultado, HttpStatus.OK);
        } catch (Exception e) {
            resultado = new CustomerDTOResponse();
            resultado.setMensaje(badMessage);
            respuesta = new ResponseEntity<>(resultado, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

}
