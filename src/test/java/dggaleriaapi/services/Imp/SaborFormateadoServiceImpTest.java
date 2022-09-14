package dggaleriaapi.services.Imp;

import dggaleriaapi.models.DrinkContainer;
import dggaleriaapi.models.TasteAsociado;
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
    void getByTasteAsociadoId() {
        TasteAsociado tasteAsociado = new TasteAsociado();
        tasteAsociado.setId(1L);
        TasteFormateado tasteFormateado = new TasteFormateado();
        tasteFormateado.setTasteAsociado(tasteAsociado);

        TasteFormateadoResponse respuesta = tasteFormateadoService.getByTasteAsociadoId(tasteFormateado);
        assertEquals(1, respuesta.getTasteesFormateadosTrabajados().size());

        tasteAsociado.setId(2L);
        respuesta = tasteFormateadoService.getByTasteAsociadoId(tasteFormateado);
        assertEquals(1, respuesta.getTasteesFormateadosTrabajados().size());

        tasteAsociado.setId(3L);
        respuesta = tasteFormateadoService.getByTasteAsociadoId(tasteFormateado);
        assertEquals(2, respuesta.getTasteesFormateadosTrabajados().size());

        tasteAsociado.setId(4L);
        respuesta = tasteFormateadoService.getByTasteAsociadoId(tasteFormateado);
        assertEquals(2, respuesta.getTasteesFormateadosTrabajados().size());

        tasteAsociado.setId(5L);
        respuesta = tasteFormateadoService.getByTasteAsociadoId(tasteFormateado);
        assertEquals(1, respuesta.getTasteesFormateadosTrabajados().size());
    }

    @Test
    @Order(3)
    void save() {
        DrinkContainer drinkContainer = new DrinkContainer();
        drinkContainer.setId(1L);
        TasteAsociado tasteAsociado = new TasteAsociado();
        tasteAsociado.setId(2L);
        TasteFormateado tasteFormateado = new TasteFormateado();
        tasteFormateado.setDrinkContainer(drinkContainer);
        tasteFormateado.setTasteAsociado(tasteAsociado);

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
        TasteAsociado tasteAsociado = new TasteAsociado();
        tasteAsociado.setId(2L);
        TasteFormateado tasteFormateado = new TasteFormateado();
        tasteFormateado.setDrinkContainer(drinkContainer);
        tasteFormateado.setTasteAsociado(tasteAsociado);

        TasteFormateadoResponse respuesta = tasteFormateadoService.saveInicial(tasteFormateado);

        assertEquals(5, respuesta.getTasteesFormateadosTrabajados().size());
    }

    @Test
    @Order(5)
    void savePorMonton() throws Exception {
        DrinkContainer drinkContainer1 = new DrinkContainer();
        drinkContainer1.setId(1L);
        TasteAsociado tasteAsociado1 = new TasteAsociado();
        tasteAsociado1.setId(2L);
        TasteFormateado tasteFormateado1 = new TasteFormateado();
        tasteFormateado1.setDrinkContainer(drinkContainer1);
        tasteFormateado1.setTasteAsociado(tasteAsociado1);

        DrinkContainer drinkContainer2 = new DrinkContainer();
        drinkContainer2.setId(1L);
        TasteAsociado tasteAsociado2 = new TasteAsociado();
        tasteAsociado2.setId(2L);
        TasteFormateado tasteFormateado2 = new TasteFormateado();
        tasteFormateado2.setDrinkContainer(drinkContainer2);
        tasteFormateado2.setTasteAsociado(tasteAsociado2);

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
        TasteAsociado tasteAsociado1 = new TasteAsociado();
        tasteAsociado1.setId(2L);
        TasteFormateado tasteFormateado1 = new TasteFormateado();
        tasteFormateado1.setDrinkContainer(drinkContainer1);
        tasteFormateado1.setTasteAsociado(tasteAsociado1);

        DrinkContainer drinkContainer2 = new DrinkContainer();
        drinkContainer2.setId(1L);
        TasteAsociado tasteAsociado2 = new TasteAsociado();
        tasteAsociado2.setId(2L);
        TasteFormateado tasteFormateado2 = new TasteFormateado();
        tasteFormateado2.setDrinkContainer(drinkContainer2);
        tasteFormateado2.setTasteAsociado(tasteAsociado2);

        List<TasteFormateado> tasteesFormateados = Arrays.asList(tasteFormateado1, tasteFormateado2);

        TasteFormateadoResponse respuesta = tasteFormateadoService.savePorMontonInicial(tasteesFormateados);

        assertEquals(10, respuesta.getTasteesFormateadosTrabajados().size());
    }

    @Test
    @Order(7)
    void update() throws Exception {
        DrinkContainer drinkContainer = new DrinkContainer();
        drinkContainer.setId(1L);
        TasteAsociado tasteAsociado = new TasteAsociado();
        tasteAsociado.setId(2L);
        TasteFormateado tasteFormateado = new TasteFormateado();
        tasteFormateado.setId(1L);
        tasteFormateado.setDrinkContainer(drinkContainer);
        tasteFormateado.setTasteAsociado(tasteAsociado);

        TasteFormateadoResponse respuesta = tasteFormateadoService.update(tasteFormateado);

        assertEquals(1, respuesta.getTasteFormateadoTrabajado().getId());
        assertEquals(2, respuesta.getTasteFormateadoTrabajado().getTasteAsociado().getId());
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