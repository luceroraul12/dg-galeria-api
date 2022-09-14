package dggaleriaapi.services.Imp;

import dggaleriaapi.models.Brand;
import dggaleriaapi.models.Taste;
import dggaleriaapi.models.BrandedTaste;
import dggaleriaapi.responses.BrandedTasteResponse;
import dggaleriaapi.responses.TasteResponse;
import dggaleriaapi.services.BrandedTasteService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@TestMethodOrder(MethodOrderer.MethodName.class)
class BrandedTasteServiceImpTest {

    @Autowired
    BrandedTasteService service;

    @Test()
    @Order(6)
    void getAll(){
        BrandedTasteResponse respuesta = service.getAll();
        assertEquals(7, respuesta.getTasteesAsociadosTrabajados().size());
    }
    @Test
    @Order(5)
    void getAllByIdBrand() throws Exception {
        BrandedTasteResponse respuesta = service.getAllByIdBrand(1L);
        assertEquals(3, respuesta.getTasteesAsociadosTrabajados().size());

        respuesta = service.getAllByIdBrand(2L);
        assertEquals(0, respuesta.getTasteesAsociadosTrabajados().size());

        respuesta = service.getAllByIdBrand(3L);
        assertEquals(2, respuesta.getTasteesAsociadosTrabajados().size());

        respuesta = service.getAllByIdBrand(5L);
        assertEquals(2, respuesta.getTasteesAsociadosTrabajados().size());

        respuesta = service.getAllByIdBrand(-1L);
        assertEquals(0, respuesta.getTasteesAsociadosTrabajados().size());

        respuesta = service.getAllByIdBrand(100L);
        assertEquals(0, respuesta.getTasteesAsociadosTrabajados().size());
    }

    @Test
    @Order(1)
    void save() throws Exception {

        Taste taste = new Taste();
        taste.setId(1L);
        Brand brand = new Brand();
        brand.setId(3L);
        BrandedTaste brandedTaste = new BrandedTaste();
        brandedTaste.setTaste(taste);
        brandedTaste.setBrand(brand);

        BrandedTasteResponse respuesta = service.save(brandedTaste);

        assertEquals(8, respuesta.getTasteTrabajado().getId());
        //Valor por defecto declarado en la Entidad
        assertEquals(true, respuesta.getTasteTrabajado().getEstadoStock());
        assertEquals(3, respuesta.getTasteTrabajado().getBrand().getId());
        assertEquals(1, respuesta.getTasteTrabajado().getTaste().getId());
    }

    @Test
    @Order(2)
    void savePorMonton() throws Exception {

        Taste taste = new Taste();
        taste.setId(1L);
        Brand brand = new Brand();
        brand.setId(3L);
        BrandedTaste brandedTaste = new BrandedTaste();
        brandedTaste.setTaste(taste);
        brandedTaste.setBrand(brand);
        BrandedTaste brandedTaste2 = new BrandedTaste();
        brandedTaste2.setTaste(taste);
        brandedTaste2.setBrand(brand);
        List<BrandedTaste> brandedTastes = Arrays.asList(brandedTaste, brandedTaste2);
        BrandedTasteResponse respuesta = service.savePorMonton(brandedTastes);

        assertEquals(9, respuesta.getTasteesAsociadosTrabajados().get(0).getId());
        assertEquals(10, respuesta.getTasteesAsociadosTrabajados().get(1).getId());
    }

    @Test
    @Order(3)
    void update() throws Exception {
        Taste taste = new Taste();
        taste.setId(1L);
        Brand brand = new Brand();
        brand.setId(3L);
        BrandedTaste brandedTaste = new BrandedTaste();
        brandedTaste.setId(1L);
        brandedTaste.setTaste(taste);
        brandedTaste.setBrand(brand);

        BrandedTasteResponse respuesta = service.update(brandedTaste);

        assertEquals(1, respuesta.getTasteTrabajado().getId());
        assertEquals(3, respuesta.getTasteTrabajado().getBrand().getId());
        assertEquals(1, respuesta.getTasteTrabajado().getTaste().getId());
    }

    @Test
    @Order(4)
    void delete() throws Exception {
        BrandedTaste brandedTaste = new BrandedTaste();
        brandedTaste.setId(1L);
        BrandedTasteResponse respuesta = service.delete(brandedTaste);


        assertEquals(1, respuesta.getTasteTrabajado().getId());
    }
}