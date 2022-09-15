package dggaleriaapi.services.Imp;

import dggaleriaapi.models.DrinkContainer;
import dggaleriaapi.models.BrandedTaste;
import dggaleriaapi.models.DrinkContaineredTaste;
import dggaleriaapi.responses.DrinkContaineredTasteResponse;
import dggaleriaapi.services.DrinkContaineredTasteService;
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
class DrinkContaineredTasteServiceImpTest {

    @Autowired
    DrinkContaineredTasteService drinkContaineredTasteService;

    @Test
    @Order(1)
    void getAll() {
        DrinkContaineredTasteResponse respuesta = drinkContaineredTasteService.getAll();
        assertEquals(7, respuesta.getTasteesFormateadosTrabajados().size());
    }

    @Test
    @Order(2)
    void getByBrandedTasteId() {
        BrandedTaste brandedTaste = new BrandedTaste();
        brandedTaste.setId(1L);
        DrinkContaineredTaste drinkContaineredTaste = new DrinkContaineredTaste();
        drinkContaineredTaste.setBrandedTaste(brandedTaste);

        DrinkContaineredTasteResponse respuesta = drinkContaineredTasteService.getByBrandedTasteId(drinkContaineredTaste);
        assertEquals(1, respuesta.getTasteesFormateadosTrabajados().size());

        brandedTaste.setId(2L);
        respuesta = drinkContaineredTasteService.getByBrandedTasteId(drinkContaineredTaste);
        assertEquals(1, respuesta.getTasteesFormateadosTrabajados().size());

        brandedTaste.setId(3L);
        respuesta = drinkContaineredTasteService.getByBrandedTasteId(drinkContaineredTaste);
        assertEquals(2, respuesta.getTasteesFormateadosTrabajados().size());

        brandedTaste.setId(4L);
        respuesta = drinkContaineredTasteService.getByBrandedTasteId(drinkContaineredTaste);
        assertEquals(2, respuesta.getTasteesFormateadosTrabajados().size());

        brandedTaste.setId(5L);
        respuesta = drinkContaineredTasteService.getByBrandedTasteId(drinkContaineredTaste);
        assertEquals(1, respuesta.getTasteesFormateadosTrabajados().size());
    }

    @Test
    @Order(3)
    void save() {
        DrinkContainer drinkContainer = new DrinkContainer();
        drinkContainer.setId(1L);
        BrandedTaste brandedTaste = new BrandedTaste();
        brandedTaste.setId(2L);
        DrinkContaineredTaste drinkContaineredTaste = new DrinkContaineredTaste();
        drinkContaineredTaste.setDrinkContainer(drinkContainer);
        drinkContaineredTaste.setBrandedTaste(brandedTaste);

        DrinkContaineredTasteResponse respuesta = null;
        try {
            respuesta = drinkContaineredTasteService.save(drinkContaineredTaste);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        assertEquals(8, respuesta.getDrinkContaineredTasteTrabajado().getId());
    }

    @Test
    @Order(4)
    void saveInicial() throws Exception {
        DrinkContainer drinkContainer = new DrinkContainer();
        drinkContainer.setId(1L);
        BrandedTaste brandedTaste = new BrandedTaste();
        brandedTaste.setId(2L);
        DrinkContaineredTaste drinkContaineredTaste = new DrinkContaineredTaste();
        drinkContaineredTaste.setDrinkContainer(drinkContainer);
        drinkContaineredTaste.setBrandedTaste(brandedTaste);

        DrinkContaineredTasteResponse respuesta = drinkContaineredTasteService.saveInicial(drinkContaineredTaste);

        assertEquals(5, respuesta.getTasteesFormateadosTrabajados().size());
    }

    @Test
    @Order(5)
    void savePorMonton() throws Exception {
        DrinkContainer drinkContainer1 = new DrinkContainer();
        drinkContainer1.setId(1L);
        BrandedTaste brandedTaste1 = new BrandedTaste();
        brandedTaste1.setId(2L);
        DrinkContaineredTaste drinkContaineredTaste1 = new DrinkContaineredTaste();
        drinkContaineredTaste1.setDrinkContainer(drinkContainer1);
        drinkContaineredTaste1.setBrandedTaste(brandedTaste1);

        DrinkContainer drinkContainer2 = new DrinkContainer();
        drinkContainer2.setId(1L);
        BrandedTaste brandedTaste2 = new BrandedTaste();
        brandedTaste2.setId(2L);
        DrinkContaineredTaste drinkContaineredTaste2 = new DrinkContaineredTaste();
        drinkContaineredTaste2.setDrinkContainer(drinkContainer2);
        drinkContaineredTaste2.setBrandedTaste(brandedTaste2);

        List<DrinkContaineredTaste> tasteesFormateados = Arrays.asList(drinkContaineredTaste1, drinkContaineredTaste2);

        DrinkContaineredTasteResponse respuesta = drinkContaineredTasteService.savePorMonton(tasteesFormateados);

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
        DrinkContaineredTaste drinkContaineredTaste1 = new DrinkContaineredTaste();
        drinkContaineredTaste1.setDrinkContainer(drinkContainer1);
        drinkContaineredTaste1.setBrandedTaste(brandedTaste1);

        DrinkContainer drinkContainer2 = new DrinkContainer();
        drinkContainer2.setId(1L);
        BrandedTaste brandedTaste2 = new BrandedTaste();
        brandedTaste2.setId(2L);
        DrinkContaineredTaste drinkContaineredTaste2 = new DrinkContaineredTaste();
        drinkContaineredTaste2.setDrinkContainer(drinkContainer2);
        drinkContaineredTaste2.setBrandedTaste(brandedTaste2);

        List<DrinkContaineredTaste> tasteesFormateados = Arrays.asList(drinkContaineredTaste1, drinkContaineredTaste2);

        DrinkContaineredTasteResponse respuesta = drinkContaineredTasteService.savePorMontonInicial(tasteesFormateados);

        assertEquals(10, respuesta.getTasteesFormateadosTrabajados().size());
    }

    @Test
    @Order(7)
    void update() throws Exception {
        DrinkContainer drinkContainer = new DrinkContainer();
        drinkContainer.setId(1L);
        BrandedTaste brandedTaste = new BrandedTaste();
        brandedTaste.setId(2L);
        DrinkContaineredTaste drinkContaineredTaste = new DrinkContaineredTaste();
        drinkContaineredTaste.setId(1L);
        drinkContaineredTaste.setDrinkContainer(drinkContainer);
        drinkContaineredTaste.setBrandedTaste(brandedTaste);

        DrinkContaineredTasteResponse respuesta = drinkContaineredTasteService.update(drinkContaineredTaste);

        assertEquals(1, respuesta.getDrinkContaineredTasteTrabajado().getId());
        assertEquals(2, respuesta.getDrinkContaineredTasteTrabajado().getBrandedTaste().getId());
        assertEquals(true, respuesta.getDrinkContaineredTasteTrabajado().getIsStocked());
        assertEquals(1, respuesta.getDrinkContaineredTasteTrabajado().getDrinkContainer().getId());
    }

    @Test
    @Order(8)
    void delete() throws Exception {
        DrinkContaineredTaste drinkContaineredTaste = new DrinkContaineredTaste();
        drinkContaineredTaste.setId(1L);

        DrinkContaineredTasteResponse respuesta = drinkContaineredTasteService.delete(drinkContaineredTaste);

        assertEquals(1, respuesta.getDrinkContaineredTasteTrabajado().getId());
    }
}