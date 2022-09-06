package dggaleriaapi.services.Imp;

import dggaleriaapi.models.Marca;
import dggaleriaapi.repositories.MarcaRepository;
import dggaleriaapi.responses.GaleriaResponse;
import dggaleriaapi.services.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;

public class MarcaServiceImp implements MarcaService {

    @Autowired
    MarcaRepository marcaRepository;

    public MarcaServiceImp(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    @Override
    public GaleriaResponse getAll() {
        GaleriaResponse respuesta = new GaleriaResponse();
        respuesta.setMarcasDisponibles(
                marcaRepository.findAll()
        );
        return respuesta;
    }

    @Override
    public GaleriaResponse getById(Long id) {
        GaleriaResponse respuesta = new GaleriaResponse();
        respuesta.setMarcasTrabajado(
                marcaRepository.findById(id).get()
        );
        return respuesta;
    }

    @Override
    public GaleriaResponse saveMarca(Marca marca) {
        GaleriaResponse respuesta = new GaleriaResponse();
        respuesta.setMarcasTrabajado(
                marcaRepository.save(marca)
        );
        return null;
    }
}
