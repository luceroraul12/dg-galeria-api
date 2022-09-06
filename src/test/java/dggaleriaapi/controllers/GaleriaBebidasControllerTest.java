package dggaleriaapi.controllers;

import dggaleriaapi.datosprueba.DatosPrueba;
import dggaleriaapi.repositories.FormatoRepository;
import dggaleriaapi.responses.GaleriaResponse;
import dggaleriaapi.services.FormatoService;
import dggaleriaapi.services.Imp.FormatoServiceImp;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class GaleriaBebidasControllerTest {

    static FormatoRepository formatoRepository = Mockito.mock(FormatoRepository.class);
    FormatoService formatoService = new FormatoServiceImp(formatoRepository);
    GaleriaBebidasController galeriaBebidasController = new GaleriaBebidasController(formatoService);

    @BeforeAll
    static void beforeAll() {
        Mockito.when( formatoRepository.findAll()).thenReturn(DatosPrueba.formatos);
    }

    @Test
    void getAllFormatos() {
        ResponseEntity<GaleriaResponse> respuesta = galeriaBebidasController.getAllFormatos();
        assertArrayEquals(DatosPrueba.formatos.toArray(), respuesta.getBody().getFormatosDiponibles().toArray() );
    }

    @Test
    void saveFormato() {
    }

    @Test
    void getAllMarcas() {
    }

    @Test
    void saveMarca() {
    }

    @Test
    void getAllSaboresByIdMarca() {
    }

    @Test
    void getAllSaboresByIdMarcayEnStock() {
    }

    @Test
    void saveSaborByIdMarca() {
    }
}