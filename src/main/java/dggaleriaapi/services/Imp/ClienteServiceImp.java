package dggaleriaapi.services.Imp;

import dggaleriaapi.dto.ClienteDTO;
import dggaleriaapi.dto.TasteResumenDTO;
import dggaleriaapi.models.DrinkContainer;
import dggaleriaapi.models.Brand;
import dggaleriaapi.models.BrandedTaste;
import dggaleriaapi.models.TasteFormateado;
import dggaleriaapi.repositories.BrandRepository;
import dggaleriaapi.repositories.BrandedTasteRepository;
import dggaleriaapi.repositories.TasteFormateadoRepository;
import dggaleriaapi.responses.ClienteDTOResponse;
import dggaleriaapi.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImp implements ClienteService {

    @Autowired
    BrandRepository brandRepository;
    @Autowired
    BrandedTasteRepository brandedTasteRepository;
    @Autowired
    TasteFormateadoRepository tasteFormateadoRepository;


    @Override
    public ClienteDTOResponse obtenerResumenPorBrand(Brand brand) {

        ClienteDTO cliente = new ClienteDTO();
        ClienteDTOResponse respuesta = new ClienteDTOResponse();

        cliente.setBrandElegida(brandRepository.findById(brand.getId()).get());

        cliente.setTasteesResumidos(generarTasteesResumidos(brand.getId()));

        respuesta.setResumen(cliente);

        return respuesta;
    }

    private List<TasteResumenDTO> generarTasteesResumidos(Long idBrand) {

        List<BrandedTaste> tasteesAsociados = brandedTasteRepository.findByBrand_Id(idBrand);
        List<TasteFormateado> tasteesFormateados = tasteFormateadoRepository.getAllByIdBrand(idBrand);
        List<TasteResumenDTO> resultado = new ArrayList<>();
        TasteResumenDTO tasteResumido;

        for (BrandedTaste brandedTaste : tasteesAsociados){
            tasteResumido = TasteResumenDTO.builder()
                            .nombreTaste(brandedTaste.getTaste().getNombre())
                            .drinkContainersDisponibles(obtenerDrinkContainers(brandedTaste.getId(), tasteesFormateados))
                            .build();
            resultado.add(tasteResumido);
        }


        return resultado;
    }

    private List<DrinkContainer> obtenerDrinkContainers(Long idBrandedTaste, List<TasteFormateado> tasteesFormateados) {
        List<DrinkContainer> resultado = new ArrayList<>();
        List<TasteFormateado> tasteesFormateadosFiltrados = tasteesFormateados
                .stream()
                .filter(tasteFormateado -> tasteFormateado.getBrandedTaste().getId() == idBrandedTaste).collect(Collectors.toList());

        tasteesFormateadosFiltrados.forEach(taste -> resultado.add(obtenerDrinkContainerInmutable(taste)));

        return resultado;
    }

    private DrinkContainer obtenerDrinkContainerInmutable(TasteFormateado taste) {
        DrinkContainer drinkContainer = new DrinkContainer();
        drinkContainer.setId(taste.getDrinkContainer().getId());
        drinkContainer.setContainerName(taste.getDrinkContainer().getContainerName());
        drinkContainer.setIsStocked(taste.getEstadoStock());
        return drinkContainer;
    }


}
