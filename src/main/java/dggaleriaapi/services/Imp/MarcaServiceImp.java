package dggaleriaapi.services.Imp;

import dggaleriaapi.models.Marca;
import dggaleriaapi.repositories.MarcaRepository;
import dggaleriaapi.responses.GaleriaResponse;
import dggaleriaapi.services.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarcaServiceImp implements MarcaService {

    @Autowired
    MarcaRepository marcaRepository;

    public MarcaServiceImp(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    @Override
    public GaleriaResponse getAll() {
        GaleriaResponse respuesta = new GaleriaResponse();
        respuesta.setMarcasCreadas(
                marcaRepository.findAll()
        );
        return respuesta;
    }

    @Override
    public GaleriaResponse saveMarca(Marca marca) {
        GaleriaResponse respuesta = new GaleriaResponse();
        respuesta.setMarcaTrabajada(
                marcaRepository.save(marca)
        );
        return respuesta;
    }

    @Override
    public GaleriaResponse updateMarca(Marca marca) {
        GaleriaResponse respuesta = new GaleriaResponse();
        respuesta.setMarcaTrabajada(
                marcaRepository.save(marca)
        );
        return respuesta;
    }

    @Override
    public GaleriaResponse deleteMarca(Long idMarca) {
        GaleriaResponse respuesta = new GaleriaResponse();
        Marca marca = new Marca();
        marca.setId(idMarca);
        marcaRepository.delete(marca);
        respuesta.setMarcaTrabajada(marca);
        return respuesta;
    }
}
