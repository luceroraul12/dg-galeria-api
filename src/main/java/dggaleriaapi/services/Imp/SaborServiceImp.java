package dggaleriaapi.services.Imp;

import dggaleriaapi.models.Formato;
import dggaleriaapi.models.SaborAsociado;
import dggaleriaapi.models.SaborCliente;
import dggaleriaapi.repositories.SaborRepository;
import dggaleriaapi.responses.GaleriaResponse;
import dggaleriaapi.services.SaborService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class SaborServiceImp implements SaborService {

    @Autowired
    SaborRepository saborRepository;

    public SaborServiceImp(SaborRepository saborRepository) {
        this.saborRepository = saborRepository;
    }

    @Override
    public GaleriaResponse getAllByIdMarca(Long idMarca) {
        GaleriaResponse resultado = new GaleriaResponse();
        resultado.setSaboresCreados(
            saborRepository.findByMarca_Id(idMarca)
        );
        return resultado;
    }

    @Override
    public GaleriaResponse getAllByIdMarcaParaVer(Long idMarca) {
        GaleriaResponse resultado = new GaleriaResponse();
        List<SaborCliente> saboresResumidos = new ArrayList<>();
        Set<String> saboresUnicos;
        List<SaborAsociado> saboresCreados = saborRepository.findByMarca_Id(idMarca);

        saboresUnicos = obtenerSaboresUnicos(saboresCreados);

        saboresUnicos.forEach(sabor -> {
            saboresResumidos.add(
                    resumirSabor(saboresCreados, sabor)
            );
        });

        resultado.setSaboresResumidos(saboresResumidos);
        return resultado;
    }




    @Override
    public GaleriaResponse getAllByIdMarcayStock(Long idMarca) {
        GaleriaResponse resultado = new GaleriaResponse();
        resultado.setSaboresDisponibles(
                saborRepository.getAllByIdMacaryStock(idMarca)
        );
        return resultado;
    }

    @Override
    public GaleriaResponse saveSabor(SaborAsociado saborAsociado) {
        GaleriaResponse resultado = new GaleriaResponse();
        resultado.setSaborAsociadoTrabajado(
                saborRepository.save(saborAsociado)
        );
        return resultado;
    }

    @Override
    public GaleriaResponse updateSabor(SaborAsociado saborAsociado) {
        GaleriaResponse resultado = new GaleriaResponse();
        resultado.setSaborAsociadoTrabajado(
                saborRepository.save(saborAsociado)
        );
        return resultado;
    }

    @Override
    public GaleriaResponse deleteSabor(SaborAsociado saborAsociado) {
        GaleriaResponse resultado = new GaleriaResponse();
        saborRepository.delete(saborAsociado);

        resultado.setSaborAsociadoTrabajado(saborAsociado);
        return resultado;
    }

    private SaborCliente resumirSabor(List<SaborAsociado> saboresCreados, String saborUnico) {
        List<Boolean> estadosStockCreados = new ArrayList<>();
        List<Formato> formatosCreados = new ArrayList<>();
        SaborCliente saborCliente = new SaborCliente();

        saboresCreados.forEach(sabor -> {
            if (sabor.getNombre().equals(saborUnico)){
                estadosStockCreados.add(sabor.getEstadoStock());
                formatosCreados.add(sabor.getFormato());
            }
        });

        saborCliente.setNombreSabor(saborUnico);
        saborCliente.setEstadosStock(estadosStockCreados);
        saborCliente.setFormatos(formatosCreados);
        return saborCliente;
    }

    private Set<String> obtenerSaboresUnicos(List<SaborAsociado> saboresCreados) {
        Set<String> resultado = new LinkedHashSet<>();
        saboresCreados.forEach(sabor ->{
            resultado.add(sabor.getNombre());
        });
        return resultado;
    }
}
