package dggaleriaapi.services.Imp;

import dggaleriaapi.models.SaborCliente;
import dggaleriaapi.repositories.SaborAsociadoRepository;
import dggaleriaapi.services.SaborAsociadoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SaborAsociadoServiceImpTest {

    @Autowired
    SaborAsociadoRepository saborAsociadoRepository;
    @Autowired
    SaborAsociadoService saborAsociadoService;

    @Test
    void getAllByIdMarcaParaVer() {
        List<SaborCliente> resultado = saborAsociadoService.getAllByIdMarcaParaVer(6L).getSaboresResumidos();
        //solo se tiene 2 sabores
        assertEquals(2, resultado.size());
        //para el primero tiene que tener 3 formatos
        assertEquals(3, resultado.get(0).getFormatos().size());
        //para el segundo tiene que tener 1 formato
        assertEquals(1, resultado.get(1).getFormatos().size());
        //otra busqueda, 3 sabores, 1 formato cada uno
        resultado = saborAsociadoService.getAllByIdMarcaParaVer(1L).getSaboresResumidos();
        assertEquals(3, resultado.size());
        assertEquals(1, resultado.get(0).getFormatos().size());
        assertEquals(1, resultado.get(1).getFormatos().size());
        assertEquals(1, resultado.get(2).getFormatos().size());


    }
}