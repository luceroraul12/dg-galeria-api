package dggaleriaapi.services.Imp;

import dggaleriaapi.models.Formato;
import dggaleriaapi.models.SaborFormateado;
import dggaleriaapi.repositories.FormatoRepository;
import dggaleriaapi.repositories.SaborFormateadoRepository;
import dggaleriaapi.responses.SaborFormateadoResponse;
import dggaleriaapi.services.SaborFormateadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SaborFormateadoServiceImp implements SaborFormateadoService {

    @Autowired
    SaborFormateadoRepository saborFormateadoRepository;

    @Autowired
    FormatoRepository formatoRepository;

    @Override
    public SaborFormateadoResponse getAll() {
        SaborFormateadoResponse respuesta = new SaborFormateadoResponse();
        respuesta.setSaboresFormateadosTrabajados(
                saborFormateadoRepository.findAll()
        );
        return respuesta;
    }

    @Override
    public SaborFormateadoResponse getBySaborAsociadoId(SaborFormateado saborFormateado) {
        SaborFormateadoResponse respuesta = new SaborFormateadoResponse();
        Long idSaborAsociado = saborFormateado.getSaborAsociado().getId();
        respuesta.setSaboresFormateadosTrabajados(
                saborFormateadoRepository.findBySaborAsociado_Id(idSaborAsociado)
        );
        return respuesta;
    }

    @Override
    public SaborFormateadoResponse save(SaborFormateado saborFormateado) {
        SaborFormateadoResponse respuesta = new SaborFormateadoResponse();
        respuesta.setSaborFormateadoTrabajado(
                saborFormateadoRepository.save(saborFormateado)
        );
        return respuesta;
    }

    @Override
    public SaborFormateadoResponse saveInicial(SaborFormateado saborFormateado) {
        List<SaborFormateado> saboresFormateadosGenerados = generarFormatosParaSaborAsociado(saborFormateado);
        return savePorMonton(saboresFormateadosGenerados);
    }

    @Override
    public SaborFormateadoResponse savePorMonton(List<SaborFormateado> saboresFormateados) {
        SaborFormateadoResponse respuesta = new SaborFormateadoResponse();
        respuesta.setSaboresFormateadosTrabajados(
                saborFormateadoRepository.saveAll(saboresFormateados)
        );
        return respuesta;
    }

    @Override
    public SaborFormateadoResponse savePorMontonInicial(List<SaborFormateado> saboresFormateados) {
        SaborFormateadoResponse respuesta = new SaborFormateadoResponse();
        List<SaborFormateado> conjuntoSaboresFormateados = new ArrayList<>();
        saboresFormateados.forEach(saborFormateado -> {
            conjuntoSaboresFormateados.addAll(
                    saveInicial(saborFormateado).getSaboresFormateadosTrabajados()
            );
        });
        respuesta.setSaboresFormateadosTrabajados(conjuntoSaboresFormateados);
        return respuesta;
    }

    @Override
    public SaborFormateadoResponse update(SaborFormateado saborFormateado) {
        return save(saborFormateado);
    }

    @Override
    public SaborFormateadoResponse delete(SaborFormateado saborFormateado) {
        SaborFormateadoResponse respuesta = new SaborFormateadoResponse();
        saborFormateadoRepository.delete(saborFormateado);
        respuesta.setSaborFormateadoTrabajado(saborFormateado);
        return respuesta;
    }



    private List<SaborFormateado> generarFormatosParaSaborAsociado(SaborFormateado saborFormateado) {
        List<SaborFormateado> resultado = new ArrayList<>();
        List<Formato> formatosDisponibles = formatoRepository.findAll();
        formatosDisponibles.forEach(formato -> {
            saborFormateado.setFormato(formato);
            resultado.add(saborFormateado);
        });
        return resultado;
    }


}
