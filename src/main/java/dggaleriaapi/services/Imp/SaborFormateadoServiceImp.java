package dggaleriaapi.services.Imp;

import dggaleriaapi.models.DrinkContainer;
import dggaleriaapi.models.SaborAsociado;
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
    public SaborFormateadoResponse getAllByIdMarca(Long idMarca) {
        SaborFormateadoResponse respuesta = new SaborFormateadoResponse();
        respuesta.setSaboresFormateadosTrabajados(
                saborFormateadoRepository.getAllByIdMarca(idMarca)
        );
        return respuesta;
    }

    @Override
    public SaborFormateadoResponse save(SaborFormateado saborFormateado) throws Exception {
        boolean esSaborExistente = saborFormateadoRepository.existsByFormato_IdAndSaborAsociado_Id(
                saborFormateado.getDrinkContainer().getId(),
                saborFormateado.getSaborAsociado().getId()
        );
        if (esSaborExistente){
            throw new Exception();
        }
        SaborFormateadoResponse respuesta = new SaborFormateadoResponse();
        respuesta.setSaborFormateadoTrabajado(
                saborFormateadoRepository.save(saborFormateado)
        );
        return respuesta;
    }

    @Override
    public SaborFormateadoResponse saveInicial(SaborFormateado saborFormateado) throws Exception {
        List<SaborFormateado> saboresFormateadosGenerados = generarFormatosParaSaborAsociado(saborFormateado);
        SaborFormateadoResponse respuesta = new SaborFormateadoResponse();
        return savePorMonton(saboresFormateadosGenerados);
    }

    @Override
    public SaborFormateadoResponse savePorMonton(List<SaborFormateado> saboresFormateados) throws Exception {
        if (saboresFormateados == null){
            throw new Exception();
        }
        SaborFormateadoResponse respuesta = new SaborFormateadoResponse();
        respuesta.setSaboresFormateadosTrabajados(
                saborFormateadoRepository.saveAll(saboresFormateados)
        );
        return respuesta;
    }

    @Override
    public SaborFormateadoResponse savePorMontonInicial(List<SaborFormateado> saboresFormateados) throws Exception {
        if(saboresFormateados == null){
            throw new Exception();
        }
        SaborFormateadoResponse respuesta = new SaborFormateadoResponse();
        List<SaborFormateado> conjuntoSaboresFormateados = new ArrayList<>();
        for (SaborFormateado saborFormateado : saboresFormateados) {
            conjuntoSaboresFormateados.addAll(
                    saveInicial(saborFormateado).getSaboresFormateadosTrabajados()
            );
        }
        respuesta.setSaboresFormateadosTrabajados(conjuntoSaboresFormateados);
        return respuesta;
    }

    @Override
    public SaborFormateadoResponse update(SaborFormateado saborFormateado) throws Exception {
        if (saborFormateadoRepository.existsByFormato_IdAndSaborAsociado_Id(
                saborFormateado.getDrinkContainer().getId(),
                saborFormateado.getSaborAsociado().getId()
        )){
            throw new Exception();
        }
        SaborFormateadoResponse respuesta = new SaborFormateadoResponse();
        saborFormateadoRepository.save(saborFormateado);
        respuesta.setSaborFormateadoTrabajado(saborFormateado);
        return respuesta;
    }

    @Override
    public SaborFormateadoResponse delete(SaborFormateado saborFormateado) throws Exception {
        if (!saborFormateadoRepository.existsById(saborFormateado.getId())){
            throw new Exception();
        }
        SaborFormateadoResponse respuesta = new SaborFormateadoResponse();
        saborFormateadoRepository.delete(saborFormateado);
        respuesta.setSaborFormateadoTrabajado(saborFormateado);
        return respuesta;
    }



    private List<SaborFormateado> generarFormatosParaSaborAsociado(SaborFormateado saborFormateado) {
        List<SaborFormateado> resultado = new ArrayList<>();
        List<DrinkContainer> formatosDisponibles = formatoRepository.findAll();


        formatosDisponibles.forEach(formato -> {
            resultado.add(
                    generarSaborInmutable(formato, saborFormateado)
            );
        });

        return resultado;
    }

    private SaborFormateado generarSaborInmutable(DrinkContainer drinkContainer, SaborFormateado saborFormateado) {

        SaborFormateado sabor = new SaborFormateado();
        SaborAsociado saborAsociado = new SaborAsociado();
        DrinkContainer drinkContainer1 = new DrinkContainer();

        drinkContainer1.setId(drinkContainer.getId().longValue());
        saborAsociado.setId(saborFormateado.getSaborAsociado().getId());
        sabor.setSaborAsociado(saborAsociado);
        sabor.setDrinkContainer(drinkContainer1);

        return sabor;
    }
}
