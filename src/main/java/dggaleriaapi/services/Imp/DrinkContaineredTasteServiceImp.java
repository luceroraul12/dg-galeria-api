package dggaleriaapi.services.Imp;

import dggaleriaapi.models.DrinkContainer;
import dggaleriaapi.models.BrandedTaste;
import dggaleriaapi.models.DrinkContaineredTaste;
import dggaleriaapi.repositories.DrinkContainerRepository;
import dggaleriaapi.repositories.DrinkContaineredTasteRepository;
import dggaleriaapi.responses.DrinkContaineredTasteResponse;
import dggaleriaapi.services.DrinkContaineredTasteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DrinkContaineredTasteServiceImp implements DrinkContaineredTasteService {

    @Autowired
    DrinkContaineredTasteRepository drinkContaineredTasteRepository;

    @Autowired
    DrinkContainerRepository drinkContainerRepository;

    @Override
    public DrinkContaineredTasteResponse getAll() {
        DrinkContaineredTasteResponse respuesta = new DrinkContaineredTasteResponse();
        respuesta.setTasteesFormateadosTrabajados(
                drinkContaineredTasteRepository.findAll()
        );
        return respuesta;
    }

    @Override
    public DrinkContaineredTasteResponse getByBrandedTasteId(DrinkContaineredTaste drinkContaineredTaste) {
        DrinkContaineredTasteResponse respuesta = new DrinkContaineredTasteResponse();
        Long idBrandedTaste = drinkContaineredTaste.getBrandedTaste().getId();
        respuesta.setTasteesFormateadosTrabajados(
                drinkContaineredTasteRepository.findByBrandedTaste_Id(idBrandedTaste)
        );
        return respuesta;
    }

    @Override
    public DrinkContaineredTasteResponse getAllByIdBrand(Long idBrand) {
        DrinkContaineredTasteResponse respuesta = new DrinkContaineredTasteResponse();
        respuesta.setTasteesFormateadosTrabajados(
                drinkContaineredTasteRepository.getAllByIdBrand(idBrand)
        );
        return respuesta;
    }

    @Override
    public DrinkContaineredTasteResponse save(DrinkContaineredTaste drinkContaineredTaste) throws Exception {
        boolean esTasteExistente = drinkContaineredTasteRepository.existsByDrinkContainer_IdAndBrandedTaste_Id(
                drinkContaineredTaste.getDrinkContainer().getId(),
                drinkContaineredTaste.getBrandedTaste().getId()
        );
        if (esTasteExistente){
            throw new Exception();
        }
        DrinkContaineredTasteResponse respuesta = new DrinkContaineredTasteResponse();
        respuesta.setDrinkContaineredTasteTrabajado(
                drinkContaineredTasteRepository.save(drinkContaineredTaste)
        );
        return respuesta;
    }

    @Override
    public DrinkContaineredTasteResponse saveInicial(DrinkContaineredTaste drinkContaineredTaste) throws Exception {
        List<DrinkContaineredTaste> tasteesFormateadosGenerados = generarDrinkContainersParaBrandedTaste(drinkContaineredTaste);
        DrinkContaineredTasteResponse respuesta = new DrinkContaineredTasteResponse();
        return savePorMonton(tasteesFormateadosGenerados);
    }

    @Override
    public DrinkContaineredTasteResponse savePorMonton(List<DrinkContaineredTaste> tasteesFormateados) throws Exception {
        if (tasteesFormateados == null){
            throw new Exception();
        }
        DrinkContaineredTasteResponse respuesta = new DrinkContaineredTasteResponse();
        respuesta.setTasteesFormateadosTrabajados(
                drinkContaineredTasteRepository.saveAll(tasteesFormateados)
        );
        return respuesta;
    }

    @Override
    public DrinkContaineredTasteResponse savePorMontonInicial(List<DrinkContaineredTaste> tasteesFormateados) throws Exception {
        if(tasteesFormateados == null){
            throw new Exception();
        }
        DrinkContaineredTasteResponse respuesta = new DrinkContaineredTasteResponse();
        List<DrinkContaineredTaste> conjuntoTasteesFormateados = new ArrayList<>();
        for (DrinkContaineredTaste drinkContaineredTaste : tasteesFormateados) {
            conjuntoTasteesFormateados.addAll(
                    saveInicial(drinkContaineredTaste).getTasteesFormateadosTrabajados()
            );
        }
        respuesta.setTasteesFormateadosTrabajados(conjuntoTasteesFormateados);
        return respuesta;
    }

    @Override
    public DrinkContaineredTasteResponse update(DrinkContaineredTaste drinkContaineredTaste) throws Exception {
        if (drinkContaineredTasteRepository.existsByDrinkContainer_IdAndBrandedTaste_Id(
                drinkContaineredTaste.getDrinkContainer().getId(),
                drinkContaineredTaste.getBrandedTaste().getId()
        )){
            throw new Exception();
        }
        DrinkContaineredTasteResponse respuesta = new DrinkContaineredTasteResponse();
        drinkContaineredTasteRepository.save(drinkContaineredTaste);
        respuesta.setDrinkContaineredTasteTrabajado(drinkContaineredTaste);
        return respuesta;
    }

    @Override
    public DrinkContaineredTasteResponse delete(DrinkContaineredTaste drinkContaineredTaste) throws Exception {
        if (!drinkContaineredTasteRepository.existsById(drinkContaineredTaste.getId())){
            throw new Exception();
        }
        DrinkContaineredTasteResponse respuesta = new DrinkContaineredTasteResponse();
        drinkContaineredTasteRepository.delete(drinkContaineredTaste);
        respuesta.setDrinkContaineredTasteTrabajado(drinkContaineredTaste);
        return respuesta;
    }



    private List<DrinkContaineredTaste> generarDrinkContainersParaBrandedTaste(DrinkContaineredTaste drinkContaineredTaste) {
        List<DrinkContaineredTaste> resultado = new ArrayList<>();
        List<DrinkContainer> drinkContainersDisponibles = drinkContainerRepository.findAll();


        drinkContainersDisponibles.forEach(drinkContainer -> {
            resultado.add(
                    generarTasteInmutable(drinkContainer, drinkContaineredTaste)
            );
        });

        return resultado;
    }

    private DrinkContaineredTaste generarTasteInmutable(DrinkContainer drinkContainer, DrinkContaineredTaste drinkContaineredTaste) {

        DrinkContaineredTaste taste = new DrinkContaineredTaste();
        BrandedTaste brandedTaste = new BrandedTaste();
        DrinkContainer drinkContainer1 = new DrinkContainer();

        drinkContainer1.setId(drinkContainer.getId().longValue());
        brandedTaste.setId(drinkContaineredTaste.getBrandedTaste().getId());
        taste.setBrandedTaste(brandedTaste);
        taste.setDrinkContainer(drinkContainer1);

        return taste;
    }
}
