package dggaleriaapi.services.Imp;

import dggaleriaapi.models.Formato;
import dggaleriaapi.repositories.FormatoRepository;
import dggaleriaapi.responses.GaleriaResponse;
import dggaleriaapi.services.FormatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormatoServiceImp implements FormatoService {

    @Autowired
    FormatoRepository formatoRepository;

    public FormatoServiceImp(FormatoRepository formatoRepository) {
        this.formatoRepository = formatoRepository;
    }

    @Override
    public GaleriaResponse getAllFormatos() {
        GaleriaResponse respuesta = new GaleriaResponse();
        respuesta.setFormatosCreados(
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

    @Override
    public GaleriaResponse updateFormato(Formato formato) {
        GaleriaResponse respuesta = new GaleriaResponse();

        respuesta.setFormatoTrabajado(
                formatoRepository.save(formato)
        );
        return respuesta;
    }

    @Override
    public GaleriaResponse deleteFormato(Long idFormato) {
        Formato formato = new Formato();
        GaleriaResponse respuesta = new GaleriaResponse();
        formato.setId(idFormato);
        formatoRepository.delete(formato);
        respuesta.setFormatoTrabajado(formato);
        return respuesta;
    }
}
