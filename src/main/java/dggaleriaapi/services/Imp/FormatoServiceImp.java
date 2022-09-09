package dggaleriaapi.services.Imp;

import dggaleriaapi.models.Formato;
import dggaleriaapi.repositories.FormatoRepository;
import dggaleriaapi.responses.FormatoResponse;
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
    public FormatoResponse getAllFormatos() {
        FormatoResponse respuesta = new FormatoResponse();
        respuesta.setFormatosTrabajados(
                formatoRepository.findAll()
        );
        return respuesta;
    }

    @Override
    public FormatoResponse saveFormato(String tipo) throws Exception {
        if (tipo.isEmpty()){
            throw new Exception();
        }
        Formato formato = new Formato();
        FormatoResponse respuesta = new FormatoResponse();

        formato.setTipo(tipo);
        respuesta.setFormatoTrabajado(
                formatoRepository.save(formato)
        );
        return respuesta;
    }

    @Override
    public FormatoResponse updateFormato(Formato formato) throws Exception {
        if (!formatoRepository.existsById(formato.getId()) | formato.getTipo().isEmpty()){
            throw new Exception();
        }
        FormatoResponse respuesta = new FormatoResponse();

        respuesta.setFormatoTrabajado(
                formatoRepository.save(formato)
        );
        return respuesta;
    }

    @Override
    public FormatoResponse deleteFormato(Long idFormato) throws Exception {
        if (!formatoRepository.existsById(idFormato)){
            throw new Exception("formato no existente");
        }
        Formato formato = new Formato();
        FormatoResponse respuesta = new FormatoResponse();
        formato.setId(idFormato);
        formatoRepository.delete(formato);
        respuesta.setFormatoTrabajado(formato);
        return respuesta;
    }
}
