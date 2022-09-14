package dggaleriaapi.services.Imp;

import dggaleriaapi.models.DrinkContainer;
import dggaleriaapi.models.TasteAsociado;
import dggaleriaapi.models.TasteFormateado;
import dggaleriaapi.repositories.DrinkContainerRepository;
import dggaleriaapi.repositories.TasteFormateadoRepository;
import dggaleriaapi.responses.TasteFormateadoResponse;
import dggaleriaapi.services.TasteFormateadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TasteFormateadoServiceImp implements TasteFormateadoService {

    @Autowired
    TasteFormateadoRepository tasteFormateadoRepository;

    @Autowired
    DrinkContainerRepository drinkContainerRepository;

    @Override
    public TasteFormateadoResponse getAll() {
        TasteFormateadoResponse respuesta = new TasteFormateadoResponse();
        respuesta.setTasteesFormateadosTrabajados(
                tasteFormateadoRepository.findAll()
        );
        return respuesta;
    }

    @Override
    public TasteFormateadoResponse getByTasteAsociadoId(TasteFormateado tasteFormateado) {
        TasteFormateadoResponse respuesta = new TasteFormateadoResponse();
        Long idTasteAsociado = tasteFormateado.getTasteAsociado().getId();
        respuesta.setTasteesFormateadosTrabajados(
                tasteFormateadoRepository.findByTasteAsociado_Id(idTasteAsociado)
        );
        return respuesta;
    }

    @Override
    public TasteFormateadoResponse getAllByIdBrand(Long idBrand) {
        TasteFormateadoResponse respuesta = new TasteFormateadoResponse();
        respuesta.setTasteesFormateadosTrabajados(
                tasteFormateadoRepository.getAllByIdBrand(idBrand)
        );
        return respuesta;
    }

    @Override
    public TasteFormateadoResponse save(TasteFormateado tasteFormateado) throws Exception {
        boolean esTasteExistente = tasteFormateadoRepository.existsByDrinkContainer_IdAndTasteAsociado_Id(
                tasteFormateado.getDrinkContainer().getId(),
                tasteFormateado.getTasteAsociado().getId()
        );
        if (esTasteExistente){
            throw new Exception();
        }
        TasteFormateadoResponse respuesta = new TasteFormateadoResponse();
        respuesta.setTasteFormateadoTrabajado(
                tasteFormateadoRepository.save(tasteFormateado)
        );
        return respuesta;
    }

    @Override
    public TasteFormateadoResponse saveInicial(TasteFormateado tasteFormateado) throws Exception {
        List<TasteFormateado> tasteesFormateadosGenerados = generarDrinkContainersParaTasteAsociado(tasteFormateado);
        TasteFormateadoResponse respuesta = new TasteFormateadoResponse();
        return savePorMonton(tasteesFormateadosGenerados);
    }

    @Override
    public TasteFormateadoResponse savePorMonton(List<TasteFormateado> tasteesFormateados) throws Exception {
        if (tasteesFormateados == null){
            throw new Exception();
        }
        TasteFormateadoResponse respuesta = new TasteFormateadoResponse();
        respuesta.setTasteesFormateadosTrabajados(
                tasteFormateadoRepository.saveAll(tasteesFormateados)
        );
        return respuesta;
    }

    @Override
    public TasteFormateadoResponse savePorMontonInicial(List<TasteFormateado> tasteesFormateados) throws Exception {
        if(tasteesFormateados == null){
            throw new Exception();
        }
        TasteFormateadoResponse respuesta = new TasteFormateadoResponse();
        List<TasteFormateado> conjuntoTasteesFormateados = new ArrayList<>();
        for (TasteFormateado tasteFormateado : tasteesFormateados) {
            conjuntoTasteesFormateados.addAll(
                    saveInicial(tasteFormateado).getTasteesFormateadosTrabajados()
            );
        }
        respuesta.setTasteesFormateadosTrabajados(conjuntoTasteesFormateados);
        return respuesta;
    }

    @Override
    public TasteFormateadoResponse update(TasteFormateado tasteFormateado) throws Exception {
        if (tasteFormateadoRepository.existsByDrinkContainer_IdAndTasteAsociado_Id(
                tasteFormateado.getDrinkContainer().getId(),
                tasteFormateado.getTasteAsociado().getId()
        )){
            throw new Exception();
        }
        TasteFormateadoResponse respuesta = new TasteFormateadoResponse();
        tasteFormateadoRepository.save(tasteFormateado);
        respuesta.setTasteFormateadoTrabajado(tasteFormateado);
        return respuesta;
    }

    @Override
    public TasteFormateadoResponse delete(TasteFormateado tasteFormateado) throws Exception {
        if (!tasteFormateadoRepository.existsById(tasteFormateado.getId())){
            throw new Exception();
        }
        TasteFormateadoResponse respuesta = new TasteFormateadoResponse();
        tasteFormateadoRepository.delete(tasteFormateado);
        respuesta.setTasteFormateadoTrabajado(tasteFormateado);
        return respuesta;
    }



    private List<TasteFormateado> generarDrinkContainersParaTasteAsociado(TasteFormateado tasteFormateado) {
        List<TasteFormateado> resultado = new ArrayList<>();
        List<DrinkContainer> drinkContainersDisponibles = drinkContainerRepository.findAll();


        drinkContainersDisponibles.forEach(drinkContainer -> {
            resultado.add(
                    generarTasteInmutable(drinkContainer, tasteFormateado)
            );
        });

        return resultado;
    }

    private TasteFormateado generarTasteInmutable(DrinkContainer drinkContainer, TasteFormateado tasteFormateado) {

        TasteFormateado taste = new TasteFormateado();
        TasteAsociado tasteAsociado = new TasteAsociado();
        DrinkContainer drinkContainer1 = new DrinkContainer();

        drinkContainer1.setId(drinkContainer.getId().longValue());
        tasteAsociado.setId(tasteFormateado.getTasteAsociado().getId());
        taste.setTasteAsociado(tasteAsociado);
        taste.setDrinkContainer(drinkContainer1);

        return taste;
    }
}
