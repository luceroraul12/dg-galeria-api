package dggaleriaapi.services.Imp;

import dggaleriaapi.models.Formato;
import dggaleriaapi.models.SaborAsociado;
import dggaleriaapi.models.SaborFormateado;
import dggaleriaapi.responses.SaborFormateadoResponse;
import dggaleriaapi.services.SaborFormateadoService;
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
class SaborFormateadoServiceImpTest {

    @Autowired
    SaborFormateadoService saborFormateadoService;

    @Test
    @Order(1)
    void getAll() {
        SaborFormateadoResponse respuesta = saborFormateadoService.getAll();
        assertEquals(7, respuesta.getSaboresFormateadosTrabajados().size());
    }

    @Test
    @Order(2)
    void getBySaborAsociadoId() {
        SaborAsociado saborAsociado = new SaborAsociado();
        saborAsociado.setId(1L);
        SaborFormateado saborFormateado = new SaborFormateado();
        saborFormateado.setSaborAsociado(saborAsociado);

        SaborFormateadoResponse respuesta = saborFormateadoService.getBySaborAsociadoId(saborFormateado);
        assertEquals(1, respuesta.getSaboresFormateadosTrabajados().size());

        saborAsociado.setId(2L);
        respuesta = saborFormateadoService.getBySaborAsociadoId(saborFormateado);
        assertEquals(1, respuesta.getSaboresFormateadosTrabajados().size());

        saborAsociado.setId(3L);
        respuesta = saborFormateadoService.getBySaborAsociadoId(saborFormateado);
        assertEquals(2, respuesta.getSaboresFormateadosTrabajados().size());

        saborAsociado.setId(4L);
        respuesta = saborFormateadoService.getBySaborAsociadoId(saborFormateado);
        assertEquals(2, respuesta.getSaboresFormateadosTrabajados().size());

        saborAsociado.setId(5L);
        respuesta = saborFormateadoService.getBySaborAsociadoId(saborFormateado);
        assertEquals(1, respuesta.getSaboresFormateadosTrabajados().size());
    }

    @Test
    @Order(3)
    void save() {
        Formato formato = new Formato();
        formato.setId(1L);
        SaborAsociado saborAsociado = new SaborAsociado();
        saborAsociado.setId(2L);
        SaborFormateado saborFormateado = new SaborFormateado();
        saborFormateado.setFormato(formato);
        saborFormateado.setSaborAsociado(saborAsociado);

        SaborFormateadoResponse respuesta = null;
        try {
            respuesta = saborFormateadoService.save(saborFormateado);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        assertEquals(8, respuesta.getSaborFormateadoTrabajado().getId());
    }

    @Test
    @Order(4)
    void saveInicial() {
        Formato formato = new Formato();
        formato.setId(1L);
        SaborAsociado saborAsociado = new SaborAsociado();
        saborAsociado.setId(2L);
        SaborFormateado saborFormateado = new SaborFormateado();
        saborFormateado.setFormato(formato);
        saborFormateado.setSaborAsociado(saborAsociado);

        SaborFormateadoResponse respuesta = saborFormateadoService.saveInicial(saborFormateado);

        assertEquals(5, respuesta.getSaboresFormateadosTrabajados().size());
    }

    @Test
    @Order(5)
    void savePorMonton() {
        Formato formato1 = new Formato();
        formato1.setId(1L);
        SaborAsociado saborAsociado1 = new SaborAsociado();
        saborAsociado1.setId(2L);
        SaborFormateado saborFormateado1 = new SaborFormateado();
        saborFormateado1.setFormato(formato1);
        saborFormateado1.setSaborAsociado(saborAsociado1);

        Formato formato2 = new Formato();
        formato2.setId(1L);
        SaborAsociado saborAsociado2 = new SaborAsociado();
        saborAsociado2.setId(2L);
        SaborFormateado saborFormateado2 = new SaborFormateado();
        saborFormateado2.setFormato(formato2);
        saborFormateado2.setSaborAsociado(saborAsociado2);

        List<SaborFormateado> saboresFormateados = Arrays.asList(saborFormateado1, saborFormateado2);

        SaborFormateadoResponse respuesta = saborFormateadoService.savePorMonton(saboresFormateados);

        assertEquals(10, respuesta.getSaboresFormateadosTrabajados().get(0).getId());
        assertEquals(11, respuesta.getSaboresFormateadosTrabajados().get(1).getId());

    }

    @Test
    @Order(6)
    void savePorMontonInicial() {
        Formato formato1 = new Formato();
        formato1.setId(1L);
        SaborAsociado saborAsociado1 = new SaborAsociado();
        saborAsociado1.setId(2L);
        SaborFormateado saborFormateado1 = new SaborFormateado();
        saborFormateado1.setFormato(formato1);
        saborFormateado1.setSaborAsociado(saborAsociado1);

        Formato formato2 = new Formato();
        formato2.setId(1L);
        SaborAsociado saborAsociado2 = new SaborAsociado();
        saborAsociado2.setId(2L);
        SaborFormateado saborFormateado2 = new SaborFormateado();
        saborFormateado2.setFormato(formato2);
        saborFormateado2.setSaborAsociado(saborAsociado2);

        List<SaborFormateado> saboresFormateados = Arrays.asList(saborFormateado1, saborFormateado2);

        SaborFormateadoResponse respuesta = saborFormateadoService.savePorMontonInicial(saboresFormateados);

        assertEquals(10, respuesta.getSaboresFormateadosTrabajados().size());
    }

    @Test
    @Order(7)
    void update() {
        Formato formato = new Formato();
        formato.setId(1L);
        SaborAsociado saborAsociado = new SaborAsociado();
        saborAsociado.setId(2L);
        SaborFormateado saborFormateado = new SaborFormateado();
        saborFormateado.setId(1L);
        saborFormateado.setFormato(formato);
        saborFormateado.setSaborAsociado(saborAsociado);

        SaborFormateadoResponse respuesta = saborFormateadoService.update(saborFormateado);

        assertEquals(1, respuesta.getSaborFormateadoTrabajado().getId());
        assertEquals(2, respuesta.getSaborFormateadoTrabajado().getSaborAsociado().getId());
        assertEquals(true, respuesta.getSaborFormateadoTrabajado().getEstadoStock());
        assertEquals(1, respuesta.getSaborFormateadoTrabajado().getFormato().getId());
    }

    @Test
    @Order(8)
    void delete() {
        SaborFormateado saborFormateado = new SaborFormateado();
        saborFormateado.setId(1L);

        SaborFormateadoResponse respuesta = saborFormateadoService.delete(saborFormateado);

        assertEquals(1, respuesta.getSaborFormateadoTrabajado().getId());
    }
}