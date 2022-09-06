package dggaleriaapi.services.Imp;

import dggaleriaapi.models.Formato;
import dggaleriaapi.repositories.FormatoRepository;
import dggaleriaapi.responses.GaleriaResponse;
import dggaleriaapi.services.FormatoService;
import org.springframework.beans.factory.annotation.Autowired;

public class FormatoServiceImp implements FormatoService {

    @Autowired
    FormatoRepository formatoRepository;

    public FormatoServiceImp(FormatoRepository formatoRepository) {
        this.formatoRepository = formatoRepository;
    }

    @Override
    public GaleriaResponse getAllFormatos() {
        GaleriaResponse respuesta = new GaleriaResponse();
        respuesta.setFormatosDiponibles(
                formatoRepository.findAll()
        );
        return respuesta;
    }

    @Override
    public GaleriaResponse saveFormato(String tipo) {
        Formato formato = new Formato();
        GaleriaResponse respuesta = new GaleriaResponse();

        formato.setTipo(tipo);
        respuesta.setFormatoTrabajado(
                formatoRepository.save(formato)
        );
        return respuesta;
    }
}
