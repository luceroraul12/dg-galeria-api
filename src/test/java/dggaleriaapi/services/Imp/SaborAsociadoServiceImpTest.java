package dggaleriaapi.services.Imp;

import dggaleriaapi.models.Brand;
import dggaleriaapi.models.Taste;
import dggaleriaapi.models.TasteAsociado;
import dggaleriaapi.responses.TasteAsociadoResponse;
import dggaleriaapi.responses.TasteResponse;
import dggaleriaapi.services.TasteAsociadoService;
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
class TasteAsociadoServiceImpTest {

    @Autowired
    TasteAsociadoService service;

    @Test()
    @Order(6)
    void getAll(){
        TasteAsociadoResponse respuesta = service.getAll();
        assertEquals(7, respuesta.getTasteesAsociadosTrabajados().size());
    }
    @Test
    @Order(5)
    void getAllByIdBrand() throws Exception {
        TasteAsociadoResponse respuesta = service.getAllByIdBrand(1L);
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
        TasteAsociado tasteAsociado = new TasteAsociado();
        tasteAsociado.setTaste(taste);
        tasteAsociado.setBrand(brand);

        TasteAsociadoResponse respuesta = service.save(tasteAsociado);

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
        TasteAsociado tasteAsociado = new TasteAsociado();
        tasteAsociado.setTaste(taste);
        tasteAsociado.setBrand(brand);
        TasteAsociado tasteAsociado2 = new TasteAsociado();
        tasteAsociado2.setTaste(taste);
        tasteAsociado2.setBrand(brand);
        List<TasteAsociado> tasteAsociados = Arrays.asList(tasteAsociado, tasteAsociado2);
        TasteAsociadoResponse respuesta = service.savePorMonton(tasteAsociados);

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
        TasteAsociado tasteAsociado = new TasteAsociado();
        tasteAsociado.setId(1L);
        tasteAsociado.setTaste(taste);
        tasteAsociado.setBrand(brand);

        TasteAsociadoResponse respuesta = service.update(tasteAsociado);

        assertEquals(1, respuesta.getTasteTrabajado().getId());
        assertEquals(3, respuesta.getTasteTrabajado().getBrand().getId());
        assertEquals(1, respuesta.getTasteTrabajado().getTaste().getId());
    }

    @Test
    @Order(4)
    void delete() throws Exception {
        TasteAsociado tasteAsociado = new TasteAsociado();
        tasteAsociado.setId(1L);
        TasteAsociadoResponse respuesta = service.delete(tasteAsociado);


        assertEquals(1, respuesta.getTasteTrabajado().getId());
    }
}