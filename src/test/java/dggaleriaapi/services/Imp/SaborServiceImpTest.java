package dggaleriaapi.services.Imp;

import dggaleriaapi.models.Taste;
import dggaleriaapi.responses.TasteResponse;
import dggaleriaapi.services.TasteService;
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
class TasteServiceImpTest {

    @Autowired
    TasteService tasteService;

    @Test
    void getAll() {
        TasteResponse respuesta = tasteService.getAll();
        assertEquals(10, respuesta.getTasteesTrabajados().size());
    }

    @Test
    @Order(1)
    void save() throws Exception {
        Taste taste = new Taste();
        taste.setNombre("MANAWA");
        TasteResponse respuesta = tasteService.save(taste);
        assertEquals(11, respuesta.getTasteTrabajado().getId());
        assertEquals(taste.getNombre(), respuesta.getTasteTrabajado().getNombre());
    }

    @Test
    @Order(2)
    void savePorMonton() throws Exception {
        Taste taste1 = new Taste();
        Taste taste2 = new Taste();
        List<Taste> tastees = new ArrayList<>();
        taste1.setNombre("AWA MANANTIAL");
        tastees.add(taste1);
        taste2.setNombre("Narampol");
        tastees.add(taste2);
        TasteResponse respuesta = tasteService.savePorMonton(tastees);
        assertEquals(12, respuesta.getTasteesTrabajados().get(0).getId());
        assertEquals("AWA MANANTIAL", respuesta.getTasteesTrabajados().get(0).getNombre());
        assertEquals(13, respuesta.getTasteesTrabajados().get(1).getId());
        assertEquals("Narampol", respuesta.getTasteesTrabajados().get(1).getNombre());

    }

    @Test
    void update() throws Exception {
        Taste taste = new Taste();
        taste.setId(1L);
        taste.setNombre("MANAWA");
        tasteService.update(taste);
        TasteResponse respuesta = tasteService.getAll();
        assertEquals("MANAWA", respuesta.getTasteesTrabajados().get(0).getNombre());
    }

    @Test
    void delete() throws Exception {
        Taste taste = new Taste();
        taste.setId(1L);
        TasteResponse respuesta = tasteService.delete(taste);
        assertEquals(1, respuesta.getTasteTrabajado().getId());
    }
}