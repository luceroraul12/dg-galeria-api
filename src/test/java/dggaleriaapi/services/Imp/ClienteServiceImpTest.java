package dggaleriaapi.services.Imp;

import dggaleriaapi.models.Brand;
import dggaleriaapi.responses.ClienteDTOResponse;
import dggaleriaapi.services.ClienteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ClienteServiceImpTest {

    @Autowired
    ClienteService service;

    @Test
    void obtenerResumenPorBrand() {
        Brand brand = new Brand();
        brand.setId(3L);
        ClienteDTOResponse respuesta = service.obtenerResumenPorBrand(brand);
        System.out.println(respuesta);
        assertEquals(2, respuesta.getResumen().getTasteesResumidos().get(0).getDrinkContainersDisponibles().size());
        assertEquals(1, respuesta.getResumen().getTasteesResumidos().get(1).getDrinkContainersDisponibles().size());
    }
}