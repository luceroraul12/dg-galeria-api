package dggaleriaapi.services.Imp;

import dggaleriaapi.dto.ClienteDTO;
import dggaleriaapi.dto.TasteResumenDTO;
import dggaleriaapi.models.DrinkContainer;
import dggaleriaapi.models.Brand;
import dggaleriaapi.models.TasteAsociado;
import dggaleriaapi.models.TasteFormateado;
import dggaleriaapi.repositories.BrandRepository;
import dggaleriaapi.repositories.TasteAsociadoRepository;
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
    TasteAsociadoRepository tasteAsociadoRepository;
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

        List<TasteAsociado> tasteesAsociados = tasteAsociadoRepository.findByBrand_Id(idBrand);
        List<TasteFormateado> tasteesFormateados = tasteFormateadoRepository.getAllByIdBrand(idBrand);
        List<TasteResumenDTO> resultado = new ArrayList<>();
        TasteResumenDTO tasteResumido;

        for (TasteAsociado tasteAsociado : tasteesAsociados){
            tasteResumido = TasteResumenDTO.builder()
                            .nombreTaste(tasteAsociado.getTaste().getNombre())
                            .drinkContainersDisponibles(obtenerDrinkContainers(tasteAsociado.getId(), tasteesFormateados))
                            .build();
            resultado.add(tasteResumido);
        }


        return resultado;
    }

    private List<DrinkContainer> obtenerDrinkContainers(Long idTasteAsociado, List<TasteFormateado> tasteesFormateados) {
        List<DrinkContainer> resultado = new ArrayList<>();
        List<TasteFormateado> tasteesFormateadosFiltrados = tasteesFormateados
                .stream()
                .filter(tasteFormateado -> tasteFormateado.getTasteAsociado().getId() == idTasteAsociado).collect(Collectors.toList());

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
