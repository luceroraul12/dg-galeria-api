package dggaleriaapi.services.Imp;

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
        return null;
    }

    @Override
    public GaleriaResponse getById() {
        return null;
    }

    @Override
    public GaleriaResponse saveMarca() {
        return null;
    }
}
