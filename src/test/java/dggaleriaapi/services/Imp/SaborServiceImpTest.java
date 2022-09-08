package dggaleriaapi.services.Imp;

import dggaleriaapi.models.Sabor;
import dggaleriaapi.responses.SaborResponse;
import dggaleriaapi.services.SaborService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@TestMethodOrder(MethodOrderer.MethodName.class)
class SaborServiceImpTest {

    @Autowired
    SaborService saborService;

    @Test
    void getAll() {
        SaborResponse respuesta = saborService.getAll();
        assertEquals(10, respuesta.getSaboresTrabajados().size());
    }

    @Test
    @Order(1)
    void save() {
        Sabor sabor = new Sabor();
        sabor.setNombre("MANAWA");
        SaborResponse respuesta = saborService.save(sabor);
        assertEquals(11, respuesta.getSaborTrabajado().getId());
        assertEquals(sabor.getNombre(), respuesta.getSaborTrabajado().getNombre());
    }

    @Test
    @Order(2)
    void savePorMonton() {
        Sabor sabor1 = new Sabor();
        Sabor sabor2 = new Sabor();
        List<Sabor> sabores = new ArrayList<>();
        sabor1.setNombre("AWA MANANTIAL");
        sabores.add(sabor1);
        sabor2.setNombre("Narampol");
        sabores.add(sabor2);
        SaborResponse respuesta = saborService.savePorMonton(sabores);
        assertEquals(12, respuesta.getSaboresTrabajados().get(0).getId());
        assertEquals("AWA MANANTIAL", respuesta.getSaboresTrabajados().get(0).getNombre());
        assertEquals(13, respuesta.getSaboresTrabajados().get(1).getId());
        assertEquals("Narampol", respuesta.getSaboresTrabajados().get(1).getNombre());

    }

    @Test
    void update() {
        Sabor sabor = new Sabor();
        sabor.setId(1L);
        sabor.setNombre("MANAWA");
        saborService.update(sabor);
        SaborResponse respuesta = saborService.getAll();
        assertEquals("MANAWA", respuesta.getSaboresTrabajados().get(0).getNombre());
    }

    @Test
    void delete() {
        Sabor sabor = new Sabor();
        sabor.setId(1L);
        SaborResponse respuesta = saborService.delete(sabor);
        assertEquals(1, respuesta.getSaborTrabajado().getId());
    }
}