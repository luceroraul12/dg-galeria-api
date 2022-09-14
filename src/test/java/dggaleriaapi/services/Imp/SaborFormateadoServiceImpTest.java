package dggaleriaapi.services.Imp;

import dggaleriaapi.models.DrinkContainer;
import dggaleriaapi.models.BrandedTaste;
import dggaleriaapi.models.TasteFormateado;
import dggaleriaapi.responses.TasteFormateadoResponse;
import dggaleriaapi.services.TasteFormateadoService;
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
class TasteFormateadoServiceImpTest {

    @Autowired
    TasteFormateadoService tasteFormateadoService;

    @Test
    @Order(1)
    void getAll() {
        TasteFormateadoResponse respuesta = tasteFormateadoService.getAll();
        assertEquals(7, respuesta.getTasteesFormateadosTrabajados().size());
    }

    @Test
    @Order(2)
    void getByBrandedTasteId() {
        BrandedTaste brandedTaste = new BrandedTaste();
        brandedTaste.setId(1L);
        TasteFormateado tasteFormateado = new TasteFormateado();
        tasteFormateado.setBrandedTaste(brandedTaste);

        TasteFormateadoResponse respuesta = tasteFormateadoService.getByBrandedTasteId(tasteFormateado);
        assertEquals(1, respuesta.getTasteesFormateadosTrabajados().size());

        brandedTaste.setId(2L);
        respuesta = tasteFormateadoService.getByBrandedTasteId(tasteFormateado);
        assertEquals(1, respuesta.getTasteesFormateadosTrabajados().size());

        brandedTaste.setId(3L);
        respuesta = tasteFormateadoService.getByBrandedTasteId(tasteFormateado);
        assertEquals(2, respuesta.getTasteesFormateadosTrabajados().size());

        brandedTaste.setId(4L);
        respuesta = tasteFormateadoService.getByBrandedTasteId(tasteFormateado);
        assertEquals(2, respuesta.getTasteesFormateadosTrabajados().size());

        brandedTaste.setId(5L);
        respuesta = tasteFormateadoService.getByBrandedTasteId(tasteFormateado);
        assertEquals(1, respuesta.getTasteesFormateadosTrabajados().size());
    }

    @Test
    @Order(3)
    void save() {
        DrinkContainer drinkContainer = new DrinkContainer();
        drinkContainer.setId(1L);
        BrandedTaste brandedTaste = new BrandedTaste();
        brandedTaste.setId(2L);
        TasteFormateado tasteFormateado = new TasteFormateado();
        tasteFormateado.setDrinkContainer(drinkContainer);
        tasteFormateado.setBrandedTaste(brandedTaste);

        TasteFormateadoResponse respuesta = null;
        try {
            respuesta = tasteFormateadoService.save(tasteFormateado);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        assertEquals(8, respuesta.getTasteFormateadoTrabajado().getId());
    }

    @Test
    @Order(4)
    void saveInicial() throws Exception {
        DrinkContainer drinkContainer = new DrinkContainer();
        drinkContainer.setId(1L);
        BrandedTaste brandedTaste = new BrandedTaste();
        brandedTaste.setId(2L);
        TasteFormateado tasteFormateado = new TasteFormateado();
        tasteFormateado.setDrinkContainer(drinkContainer);
        tasteFormateado.setBrandedTaste(brandedTaste);

        TasteFormateadoResponse respuesta = tasteFormateadoService.saveInicial(tasteFormateado);

        assertEquals(5, respuesta.getTasteesFormateadosTrabajados().size());
    }

    @Test
    @Order(5)
    void savePorMonton() throws Exception {
        DrinkContainer drinkContainer1 = new DrinkContainer();
        drinkContainer1.setId(1L);
        BrandedTaste brandedTaste1 = new BrandedTaste();
        brandedTaste1.setId(2L);
        TasteFormateado tasteFormateado1 = new TasteFormateado();
        tasteFormateado1.setDrinkContainer(drinkContainer1);
        tasteFormateado1.setBrandedTaste(brandedTaste1);

        DrinkContainer drinkContainer2 = new DrinkContainer();
        drinkContainer2.setId(1L);
        BrandedTaste brandedTaste2 = new BrandedTaste();
        brandedTaste2.setId(2L);
        TasteFormateado tasteFormateado2 = new TasteFormateado();
        tasteFormateado2.setDrinkContainer(drinkContainer2);
        tasteFormateado2.setBrandedTaste(brandedTaste2);

        List<TasteFormateado> tasteesFormateados = Arrays.asList(tasteFormateado1, tasteFormateado2);

        TasteFormateadoResponse respuesta = tasteFormateadoService.savePorMonton(tasteesFormateados);

        assertEquals(10, respuesta.getTasteesFormateadosTrabajados().get(0).getId());
        assertEquals(11, respuesta.getTasteesFormateadosTrabajados().get(1).getId());

    }

    @Test
    @Order(6)
    void savePorMontonInicial() throws Exception {
        DrinkContainer drinkContainer1 = new DrinkContainer();
        drinkContainer1.setId(1L);
        BrandedTaste brandedTaste1 = new BrandedTaste();
        brandedTaste1.setId(2L);
        TasteFormateado tasteFormateado1 = new TasteFormateado();
        tasteFormateado1.setDrinkContainer(drinkContainer1);
        tasteFormateado1.setBrandedTaste(brandedTaste1);

        DrinkContainer drinkContainer2 = new DrinkContainer();
        drinkContainer2.setId(1L);
        BrandedTaste brandedTaste2 = new BrandedTaste();
        brandedTaste2.setId(2L);
        TasteFormateado tasteFormateado2 = new TasteFormateado();
        tasteFormateado2.setDrinkContainer(drinkContainer2);
        tasteFormateado2.setBrandedTaste(brandedTaste2);

        List<TasteFormateado> tasteesFormateados = Arrays.asList(tasteFormateado1, tasteFormateado2);

        TasteFormateadoResponse respuesta = tasteFormateadoService.savePorMontonInicial(tasteesFormateados);

        assertEquals(10, respuesta.getTasteesFormateadosTrabajados().size());
    }

    @Test
    @Order(7)
    void update() throws Exception {
        DrinkContainer drinkContainer = new DrinkContainer();
        drinkContainer.setId(1L);
        BrandedTaste brandedTaste = new BrandedTaste();
        brandedTaste.setId(2L);
        TasteFormateado tasteFormateado = new TasteFormateado();
        tasteFormateado.setId(1L);
        tasteFormateado.setDrinkContainer(drinkContainer);
        tasteFormateado.setBrandedTaste(brandedTaste);

        TasteFormateadoResponse respuesta = tasteFormateadoService.update(tasteFormateado);

        assertEquals(1, respuesta.getTasteFormateadoTrabajado().getId());
        assertEquals(2, respuesta.getTasteFormateadoTrabajado().getBrandedTaste().getId());
        assertEquals(true, respuesta.getTasteFormateadoTrabajado().getEstadoStock());
        assertEquals(1, respuesta.getTasteFormateadoTrabajado().getDrinkContainer().getId());
    }

    @Test
    @Order(8)
    void delete() throws Exception {
        TasteFormateado tasteFormateado = new TasteFormateado();
        tasteFormateado.setId(1L);

        TasteFormateadoResponse respuesta = tasteFormateadoService.delete(tasteFormateado);

        assertEquals(1, respuesta.getTasteFormateadoTrabajado().getId());
    }
}