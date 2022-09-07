package dggaleriaapi.controllers;

import dggaleriaapi.models.Formato;
import dggaleriaapi.models.Marca;
import dggaleriaapi.responses.GaleriaResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GaleriaBebidasControllerH2Test {



    @Autowired
    GaleriaBebidasController controller;




    @BeforeEach
    void setUp() {
    }

    @Test
    void getAllFormatos() {
        ResponseEntity<GaleriaResponse> respuesta = controller.getAllFormatos();
        assertEquals(5, respuesta.getBody().getFormatosCreados().size());
    }

    @Test
    void saveFormato() {
        Formato formato = new Formato();
        formato.setTipo("300LSX");

        ResponseEntity<GaleriaResponse> respuesta = controller.saveFormato(formato.getTipo());
        assertEquals(formato.getTipo(), respuesta.getBody().getFormatoTrabajado().getTipo());
    }

    @Test
    void getAllMarcas() {
        ResponseEntity<GaleriaResponse> respuesta = controller.getAllMarcas();
        assertEquals(6, respuesta.getBody().getMarcasCreadas().size());
    }

    @Test
    void saveMarca() {
        Marca marca = new Marca();
        marca.setNombre("Toyota");
        marca.setEnlace("www.wawas.com");
        ResponseEntity<GaleriaResponse> respuesta = controller.saveMarca(marca);
        assertEquals(marca.getNombre(), respuesta.getBody().getMarcaTrabajada().getNombre());
    }

    @Test
    void getAllSaboresByIdMarca() {
        ResponseEntity<GaleriaResponse> respuesta = controller.getAllSaboresByIdMarca(3L);
        assertEquals(3, respuesta.getBody().getSaboresCreados().size());
    }

    @Test
    void getSaboresIdStockBien() {
        ResponseEntity<GaleriaResponse> respuesta = controller.getAllSaboresByIdMarcayEnStock(3L);
        assertEquals(2, respuesta.getBody().getSaboresDisponibles().size());
    }
    @Test
    void getSaboresIdStockVacio() {
        ResponseEntity<GaleriaResponse> respuesta = controller.getAllSaboresByIdMarcayEnStock(6L);
        assertEquals(0, respuesta.getBody().getSaboresDisponibles().size());
    }

    @Test
    void getSaboresIdStockNoExiste() {
        ResponseEntity<GaleriaResponse> respuesta = controller.getAllSaboresByIdMarcayEnStock(203L);
        assertEquals(0, respuesta.getBody().getSaboresDisponibles().size());
    }

    @Test
    void saveSaborByIdMarca() {
    }
}