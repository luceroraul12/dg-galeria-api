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
        Mockito.when( marcaRepository.findAll()).thenReturn(DatosPrueba.marcas);
        Mockito.when( saborRepository.findByMarca_Id(0L) ).thenReturn(DatosPrueba.saboresMismaMarca0);
        Mockito.when( saborRepository.getAllByIdMacaryStock(0L) ).thenReturn(DatosPrueba.saboresMismaMarcayEnStock);
    }

    @Test
    void getAllFormatos() {
        ResponseEntity<GaleriaResponse> respuesta = controller.getAllFormatos();
        assertArrayEquals(DatosPrueba.formatos.toArray(), respuesta.getBody().getFormatosCreados().toArray() );
    }

    @Test
    void getAllMarcas() {
        ResponseEntity<GaleriaResponse> respuesta = controller.getAllMarcas();
        assertArrayEquals(DatosPrueba.marcas.toArray(), respuesta.getBody().getMarcasCreadas().toArray());
    }
    @Test
    void getAllSaboresByIdMarca() {
        ResponseEntity<GaleriaResponse> respuesta = controller.getAllSaboresByIdMarca(0L);
        assertArrayEquals(DatosPrueba.saboresMismaMarca0.toArray(), respuesta.getBody().getSaboresCreados().toArray());
    }

    @Test
    void getAllSaboresByIdMarcayEnStock() {
        ResponseEntity<GaleriaResponse> respuesta = controller.getAllSaboresByIdMarcayEnStock(0L);
        assertArrayEquals(DatosPrueba.saboresMismaMarcayEnStock.toArray(), respuesta.getBody().getSaboresDisponibles().toArray());
    }
}