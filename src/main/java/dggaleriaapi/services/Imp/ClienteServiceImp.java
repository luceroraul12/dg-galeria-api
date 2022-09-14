package dggaleriaapi.services.Imp;

import dggaleriaapi.dto.ClienteDTO;
import dggaleriaapi.dto.SaborResumenDTO;
import dggaleriaapi.models.DrinkContainer;
import dggaleriaapi.models.Marca;
import dggaleriaapi.models.SaborAsociado;
import dggaleriaapi.models.SaborFormateado;
import dggaleriaapi.repositories.MarcaRepository;
import dggaleriaapi.repositories.SaborAsociadoRepository;
import dggaleriaapi.repositories.SaborFormateadoRepository;
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
    MarcaRepository marcaRepository;
    @Autowired
    SaborAsociadoRepository saborAsociadoRepository;
    @Autowired
    SaborFormateadoRepository saborFormateadoRepository;


    @Override
    public ClienteDTOResponse obtenerResumenPorMarca(Marca marca) {

        ClienteDTO cliente = new ClienteDTO();
        ClienteDTOResponse respuesta = new ClienteDTOResponse();

        cliente.setMarcaElegida(marcaRepository.findById(marca.getId()).get());

        cliente.setSaboresResumidos(generarSaboresResumidos(marca.getId()));

        respuesta.setResumen(cliente);

        return respuesta;
    }

    private List<SaborResumenDTO> generarSaboresResumidos(Long idMarca) {

        List<SaborAsociado> saboresAsociados = saborAsociadoRepository.findByMarca_Id(idMarca);
        List<SaborFormateado> saboresFormateados = saborFormateadoRepository.getAllByIdMarca(idMarca);
        List<SaborResumenDTO> resultado = new ArrayList<>();
        SaborResumenDTO saborResumido;

        for (SaborAsociado saborAsociado : saboresAsociados){
            saborResumido = SaborResumenDTO.builder()
                            .nombreSabor(saborAsociado.getSabor().getNombre())
                            .drinkContainersDisponibles(obtenerDrinkContainers(saborAsociado.getId(), saboresFormateados))
                            .build();
            resultado.add(saborResumido);
        }


        return resultado;
    }

    private List<DrinkContainer> obtenerDrinkContainers(Long idSaborAsociado, List<SaborFormateado> saboresFormateados) {
        List<DrinkContainer> resultado = new ArrayList<>();
        List<SaborFormateado> saboresFormateadosFiltrados = saboresFormateados
                .stream()
                .filter(saborFormateado -> saborFormateado.getSaborAsociado().getId() == idSaborAsociado).collect(Collectors.toList());

        saboresFormateadosFiltrados.forEach(sabor -> resultado.add(obtenerDrinkContainerInmutable(sabor)));

        return resultado;
    }

    private DrinkContainer obtenerDrinkContainerInmutable(SaborFormateado sabor) {
        DrinkContainer drinkContainer = new DrinkContainer();
        drinkContainer.setId(sabor.getDrinkContainer().getId());
        drinkContainer.setContainerName(sabor.getDrinkContainer().getContainerName());
        drinkContainer.setIsStocked(sabor.getEstadoStock());
        return drinkContainer;
    }


}
