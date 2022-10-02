package dggaleriaapi.controllers;

import com.lowagie.text.DocumentException;
import dggaleriaapi.models.Brand;
import dggaleriaapi.responses.CustomerDTOResponse;
import dggaleriaapi.services.CustomerService;
import dggaleriaapi.services.Imp.CustomerPDFServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService service;

    @Autowired
    CustomerPDFServiceImp customerPDFServiceImp;
    
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
            resultado.setMessage(successMessage);
            respuesta = new ResponseEntity<>(resultado, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            resultado = new CustomerDTOResponse();
            resultado.setMessage(e.getMessage());
            respuesta = new ResponseEntity<>(resultado, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @GetMapping("pdf")
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        customerPDFServiceImp.export(response);

    }

}
