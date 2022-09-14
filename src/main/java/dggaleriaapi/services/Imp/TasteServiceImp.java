package dggaleriaapi.services.Imp;

import dggaleriaapi.models.Taste;
import dggaleriaapi.repositories.TasteRepository;
import dggaleriaapi.responses.TasteResponse;
import dggaleriaapi.services.TasteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TasteServiceImp implements TasteService {

    @Autowired
    TasteRepository tasteRepository;

    @Override
    public TasteResponse getAll() {
        TasteResponse respuesta = new TasteResponse();
        respuesta.setTasteesTrabajados(
                tasteRepository.findAll()
        );
        return respuesta;
    }

    @Override
    public TasteResponse save(Taste taste) throws Exception {
        if (taste.getNombre().isEmpty()){
            throw new Exception();
        }
        TasteResponse respuesta = new TasteResponse();

        respuesta.setTasteTrabajado(
                tasteRepository.save(taste)
        );
        return respuesta;
    }

    @Override
    public TasteResponse savePorMonton(List<Taste> tastees) throws Exception {
        if (tastees == null){
            throw new Exception();
        }
        TasteResponse respuesta = new TasteResponse();

        respuesta.setTasteesTrabajados(
                tasteRepository.saveAll(tastees)
        );
        return respuesta;
    }

    @Override
    public TasteResponse update(Taste taste) throws Exception {
        if (!tasteRepository.existsById(taste.getId()) | taste.getNombre().isEmpty()){
            throw new Exception();
        }
        TasteResponse respuesta = new TasteResponse();

        respuesta.setTasteTrabajado(
                tasteRepository.save(taste)
        );
        return respuesta;
    }

    @Override
    public TasteResponse delete(Taste taste) throws Exception {
        if (!tasteRepository.existsById(taste.getId())){
            throw new Exception();
        }
        TasteResponse respuesta = new TasteResponse();
        if (tasteRepository.existsById(taste.getId())){
            tasteRepository.deleteById(taste.getId());
            respuesta.setTasteTrabajado(taste);
        }
        return respuesta;
    }
}
