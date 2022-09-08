package dggaleriaapi.services.Imp;

import dggaleriaapi.models.SaborCliente;
import dggaleriaapi.services.SaborService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SaborServiceImpTest {

    @Autowired
    SaborService saborService;

    @Test
    void getAllByIdMarcaParaVer() {
        List<SaborCliente> resultado = saborService.getAllByIdMarcaParaVer(2L).getSaboresResumidos();
        assertEquals();
    }
}