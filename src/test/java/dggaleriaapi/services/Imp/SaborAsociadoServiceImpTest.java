package dggaleriaapi.services.Imp;

import dggaleriaapi.models.Brand;
import dggaleriaapi.models.Sabor;
import dggaleriaapi.models.SaborAsociado;
import dggaleriaapi.responses.SaborAsociadoResponse;
import dggaleriaapi.responses.SaborResponse;
import dggaleriaapi.services.SaborAsociadoService;
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
class SaborAsociadoServiceImpTest {

    @Autowired
    SaborAsociadoService service;

    @Test()
    @Order(6)
    void getAll(){
        SaborAsociadoResponse respuesta = service.getAll();
        assertEquals(7, respuesta.getSaboresAsociadosTrabajados().size());
    }
    @Test
    @Order(5)
    void getAllByIdBrand() throws Exception {
        SaborAsociadoResponse respuesta = service.getAllByIdBrand(1L);
        assertEquals(3, respuesta.getSaboresAsociadosTrabajados().size());

        respuesta = service.getAllByIdBrand(2L);
        assertEquals(0, respuesta.getSaboresAsociadosTrabajados().size());

        respuesta = service.getAllByIdBrand(3L);
        assertEquals(2, respuesta.getSaboresAsociadosTrabajados().size());

        respuesta = service.getAllByIdBrand(5L);
        assertEquals(2, respuesta.getSaboresAsociadosTrabajados().size());

        respuesta = service.getAllByIdBrand(-1L);
        assertEquals(0, respuesta.getSaboresAsociadosTrabajados().size());

        respuesta = service.getAllByIdBrand(100L);
        assertEquals(0, respuesta.getSaboresAsociadosTrabajados().size());
    }

    @Test
    @Order(1)
    void save() throws Exception {

        Sabor sabor = new Sabor();
        sabor.setId(1L);
        Brand brand = new Brand();
        brand.setId(3L);
        SaborAsociado saborAsociado = new SaborAsociado();
        saborAsociado.setSabor(sabor);
        saborAsociado.setBrand(brand);

        SaborAsociadoResponse respuesta = service.save(saborAsociado);

        assertEquals(8, respuesta.getSaborTrabajado().getId());
        //Valor por defecto declarado en la Entidad
        assertEquals(true, respuesta.getSaborTrabajado().getEstadoStock());
        assertEquals(3, respuesta.getSaborTrabajado().getBrand().getId());
        assertEquals(1, respuesta.getSaborTrabajado().getSabor().getId());
    }

    @Test
    @Order(2)
    void savePorMonton() throws Exception {

        Sabor sabor = new Sabor();
        sabor.setId(1L);
        Brand brand = new Brand();
        brand.setId(3L);
        SaborAsociado saborAsociado = new SaborAsociado();
        saborAsociado.setSabor(sabor);
        saborAsociado.setBrand(brand);
        SaborAsociado saborAsociado2 = new SaborAsociado();
        saborAsociado2.setSabor(sabor);
        saborAsociado2.setBrand(brand);
        List<SaborAsociado> saborAsociados = Arrays.asList(saborAsociado, saborAsociado2);
        SaborAsociadoResponse respuesta = service.savePorMonton(saborAsociados);

        assertEquals(9, respuesta.getSaboresAsociadosTrabajados().get(0).getId());
        assertEquals(10, respuesta.getSaboresAsociadosTrabajados().get(1).getId());
    }

    @Test
    @Order(3)
    void update() throws Exception {
        Sabor sabor = new Sabor();
        sabor.setId(1L);
        Brand brand = new Brand();
        brand.setId(3L);
        SaborAsociado saborAsociado = new SaborAsociado();
        saborAsociado.setId(1L);
        saborAsociado.setSabor(sabor);
        saborAsociado.setBrand(brand);

        SaborAsociadoResponse respuesta = service.update(saborAsociado);

        assertEquals(1, respuesta.getSaborTrabajado().getId());
        assertEquals(3, respuesta.getSaborTrabajado().getBrand().getId());
        assertEquals(1, respuesta.getSaborTrabajado().getSabor().getId());
    }

    @Test
    @Order(4)
    void delete() throws Exception {
        SaborAsociado saborAsociado = new SaborAsociado();
        saborAsociado.setId(1L);
        SaborAsociadoResponse respuesta = service.delete(saborAsociado);


        assertEquals(1, respuesta.getSaborTrabajado().getId());
    }
}