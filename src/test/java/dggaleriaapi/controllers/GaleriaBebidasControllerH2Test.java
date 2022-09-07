package dggaleriaapi.controllers;

import dggaleriaapi.models.Formato;
import dggaleriaapi.models.Marca;
import dggaleriaapi.models.Sabor;
import dggaleriaapi.responses.GaleriaResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
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
    void updateFormat(){
        Formato formato = new Formato();
        formato.setId(2L);
        formato.setTipo("300LSX");

        ResponseEntity<GaleriaResponse> respuesta = controller.updateFormato(formato);
        assertEquals(formato.getTipo(), respuesta.getBody().getFormatoTrabajado().getTipo());
    }

    @Test
    void deleteFormato(){
        ResponseEntity<GaleriaResponse> respuesta = controller.deleteFormato(2L);
        assertEquals(2, respuesta.getBody().getFormatoTrabajado().getId());
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
    void updateMarca(){
        Marca marca = new Marca();
        marca.setId(2L);
        marca.setNombre("Toyota");
        marca.setEnlace("www.wawas.com");
        ResponseEntity<GaleriaResponse> respuesta = controller.updateMarca(marca);
        assertEquals(marca.getNombre(), respuesta.getBody().getMarcaTrabajada().getNombre());
    }

    @Test
    void deleteMarca(){
        Marca marca = new Marca();
        marca.setId(2L);
        marca.setNombre("Toyota");
        marca.setEnlace("www.wawas.com");
        ResponseEntity<GaleriaResponse> respuesta = controller.deleteMarca(marca);
        assertEquals(marca.getId(), respuesta.getBody().getMarcaTrabajada().getId());
    }

    @Test
    void getAllSaboresByIdMarca() {
        ResponseEntity<GaleriaResponse> respuesta = controller.getAllSaboresByIdMarca(3L);
        //ninguno con idMarca 3
        assertEquals(0, respuesta.getBody().getSaboresCreados().size());
        respuesta = controller.getAllSaboresByIdMarca(4L);
        //2 con idMarca 4
        assertEquals(2, respuesta.getBody().getSaboresCreados().size());

    }

    @Test
    void getSaboresIdStockBien() {
        ResponseEntity<GaleriaResponse> respuesta = controller.getAllSaboresByIdMarcayEnStock(1L);
        //2 con idMarca 2
        assertEquals(2, respuesta.getBody().getSaboresDisponibles().size());
        respuesta = controller.getAllSaboresByIdMarcayEnStock(6L);
        //2 con idMarca 6
        assertEquals(2, respuesta.getBody().getSaboresDisponibles().size());

    }
    @Test
    void getSaboresIdStockVacio() {
        ResponseEntity<GaleriaResponse> respuesta = controller.getAllSaboresByIdMarcayEnStock(4L);
        assertEquals(0, respuesta.getBody().getSaboresDisponibles().size());
    }

    @Test
    void getSaboresIdStockNoExiste() {
        ResponseEntity<GaleriaResponse> respuesta = controller.getAllSaboresByIdMarcayEnStock(203L);
        assertEquals(0, respuesta.getBody().getSaboresDisponibles().size());
    }

    @Test
    void saveSabor() {

        Formato formato = new Formato();
        formato.setId(2L);
        Marca marca = new Marca();
        marca.setId(1L);
        Sabor sabor = new Sabor();
        sabor.setFormato(formato);
        sabor.setMarca(marca);
        sabor.setNombre("Narampol");
        sabor.setEstadoStock(true);

        ResponseEntity<GaleriaResponse> respuesta = controller.saveSabor(sabor);
        sabor.setId(11L);
        assertEquals(sabor, respuesta.getBody().getSaborTrabajado());
    }

    @Test
    void updateSabor() {
        Formato formato = new Formato();
        formato.setId(2L);
        Marca marca = new Marca();
        marca.setId(1L);
        Sabor sabor = new Sabor();
        sabor.setId(10L);
        sabor.setFormato(formato);
        sabor.setMarca(marca);
        sabor.setNombre("Limón");
        sabor.setEstadoStock(true);

        ResponseEntity<GaleriaResponse> respuesta = controller.updateSabor(sabor);
        //no deben ser iguales por que la bd devuelve los datos completos del formato y marca
        assertNotEquals(sabor.toString(), respuesta.getBody().getSaborTrabajado().toString());
    }

    @Test
    void deleteSabor() {
        Sabor sabor = new Sabor();
        sabor.setId(10L);

        ResponseEntity<GaleriaResponse> respuesta = controller.deleteSabor(sabor);
        //no deben ser iguales por que la bd devuelve los datos completos del formato y marca
        assertEquals(sabor.toString(), respuesta.getBody().getSaborTrabajado().toString());
    }


}