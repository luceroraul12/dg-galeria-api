package dggaleriaapi.services.Imp;

import dggaleriaapi.models.Marca;
import dggaleriaapi.repositories.MarcaRepository;
import dggaleriaapi.responses.FormatoResponse;
import dggaleriaapi.responses.MarcaResponse;
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
    public MarcaResponse getAll() {
        MarcaResponse respuesta = new MarcaResponse();
        respuesta.setMarcasTrabajadas(
                marcaRepository.findAll()
        );
        return respuesta;
    }

    @Override
    public MarcaResponse getMarcaById(Long idMarca) {
        MarcaResponse respuesta = new MarcaResponse();
        respuesta.setMarcaTrabajada(
                marcaRepository.findById(idMarca).get()
        );
        return respuesta;
    }

    @Override
    public MarcaResponse saveMarca(Marca marca) {
        MarcaResponse respuesta = new MarcaResponse();
        respuesta.setMarcaTrabajada(
                marcaRepository.save(marca)
        );
        return respuesta;
    }

    @Override
    public MarcaResponse updateMarca(Marca marca) {
        MarcaResponse respuesta = new MarcaResponse();
        respuesta.setMarcaTrabajada(
                marcaRepository.save(marca)
        );
        return respuesta;
    }

    @Override
    public MarcaResponse deleteMarca(Long idMarca) {
        MarcaResponse respuesta = new MarcaResponse();
        Marca marca = new Marca();
        marca.setId(idMarca);
        marcaRepository.delete(marca);
        respuesta.setMarcaTrabajada(marca);
        return respuesta;
    }
}
