package dggaleriaapi.services.Imp;

import dggaleriaapi.models.Brand;
import dggaleriaapi.responses.CustomerDTOResponse;
import dggaleriaapi.services.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CustomerServiceImpTest {

    @Autowired
    CustomerService service;

    @Test
    void obtenerResumenPorBrand() {
        Brand brand = new Brand();
        brand.setId(3L);
        CustomerDTOResponse respuesta = service.obtenerResumenPorBrand(brand);
        System.out.println(respuesta);
        assertEquals(2, respuesta.getResumen().getTasteesResumidos().get(0).getDrinkContainersDisponibles().size());
        assertEquals(1, respuesta.getResumen().getTasteesResumidos().get(1).getDrinkContainersDisponibles().size());
    }
}