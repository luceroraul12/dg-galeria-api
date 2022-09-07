package dggaleriaapi.controllers;

import dggaleriaapi.datosprueba.DatosPrueba;
import dggaleriaapi.repositories.FormatoRepository;
import dggaleriaapi.repositories.MarcaRepository;
import dggaleriaapi.repositories.SaborRepository;
import dggaleriaapi.responses.GaleriaResponse;
import dggaleriaapi.services.FormatoService;
import dggaleriaapi.services.Imp.FormatoServiceImp;
import dggaleriaapi.services.Imp.MarcaServiceImp;
import dggaleriaapi.services.Imp.SaborServiceImp;
import dggaleriaapi.services.MarcaService;
import dggaleriaapi.services.SaborService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class GaleriaBebidasControllerTest {

    static FormatoRepository formatoRepository = Mockito.mock(FormatoRepository.class);
    static MarcaRepository marcaRepository = Mockito.mock(MarcaRepository.class);
    static SaborRepository saborRepository = Mockito.mock(SaborRepository.class);

    FormatoService formatoService = new FormatoServiceImp(formatoRepository);
    MarcaService marcaService = new MarcaServiceImp(marcaRepository);
    SaborService saborService = new SaborServiceImp(saborRepository);

    GaleriaBebidasController controller = new GaleriaBebidasController(
            formatoService,
            marcaService,
            saborService
    );

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