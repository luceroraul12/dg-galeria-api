package dggaleriaapi.services.Imp;

import dggaleriaapi.dto.CustomerDTO;
import dggaleriaapi.dto.TasteResumenDTO;
import dggaleriaapi.models.DrinkContainer;
import dggaleriaapi.models.Brand;
import dggaleriaapi.models.BrandedTaste;
import dggaleriaapi.models.DrinkContaineredTaste;
import dggaleriaapi.repositories.BrandRepository;
import dggaleriaapi.repositories.BrandedTasteRepository;
import dggaleriaapi.repositories.DrinkContaineredTasteRepository;
import dggaleriaapi.responses.CustomerDTOResponse;
import dggaleriaapi.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImp implements CustomerService {

    @Autowired
    BrandRepository brandRepository;
    @Autowired
    BrandedTasteRepository brandedTasteRepository;
    @Autowired
    DrinkContaineredTasteRepository drinkContaineredTasteRepository;


    @Override
    public CustomerDTOResponse obtenerResumenPorBrand(Brand brand) {

        CustomerDTO customer = new CustomerDTO();
        CustomerDTOResponse respuesta = new CustomerDTOResponse();

        customer.setBrandSelected(brandRepository.findById(brand.getId()).get());

        customer.setTasteResults(generarTasteesResumidos(brand.getId()));

        respuesta.setCustomerResult(customer);

        return respuesta;
    }

    private List<TasteResumenDTO> generarTasteesResumidos(Long idBrand) {

        List<BrandedTaste> tasteesAsociados = brandedTasteRepository.findByBrand_Id(idBrand);
        List<DrinkContaineredTaste> tasteesFormateados = drinkContaineredTasteRepository.getAllByIdBrand(idBrand);
        List<TasteResumenDTO> resultado = new ArrayList<>();
        TasteResumenDTO tasteResumido;

        for (BrandedTaste brandedTaste : tasteesAsociados){
            tasteResumido = TasteResumenDTO.builder()
                            .tasteName(brandedTaste.getTaste().getTasteName())
                            .drinkContainersAvailable(obtenerDrinkContainers(brandedTaste.getId(), tasteesFormateados))
                            .build();
            resultado.add(tasteResumido);
        }


        return resultado;
    }

    private List<DrinkContainer> obtenerDrinkContainers(Long idBrandedTaste, List<DrinkContaineredTaste> tasteesFormateados) {
        List<DrinkContainer> resultado = new ArrayList<>();
        List<DrinkContaineredTaste> tasteesFormateadosFiltrados = tasteesFormateados
                .stream()
                .filter(drinkContaineredTaste -> drinkContaineredTaste.getBrandedTaste().getId() == idBrandedTaste).collect(Collectors.toList());

        tasteesFormateadosFiltrados.forEach(taste -> resultado.add(obtenerDrinkContainerInmutable(taste)));

        return resultado;
    }

    private DrinkContainer obtenerDrinkContainerInmutable(DrinkContaineredTaste taste) {
        DrinkContainer drinkContainer = new DrinkContainer();
        drinkContainer.setId(taste.getDrinkContainer().getId());
        drinkContainer.setContainerName(taste.getDrinkContainer().getContainerName());
        drinkContainer.setIsStocked(taste.getIsStocked());
        return drinkContainer;
    }


}
