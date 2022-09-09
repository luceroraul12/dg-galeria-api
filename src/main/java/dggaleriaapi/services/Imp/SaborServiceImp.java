package dggaleriaapi.services.Imp;

import dggaleriaapi.models.Sabor;
import dggaleriaapi.repositories.SaborRepository;
import dggaleriaapi.responses.SaborResponse;
import dggaleriaapi.services.SaborService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaborServiceImp implements SaborService {

    @Autowired
    SaborRepository saborRepository;

    @Override
    public SaborResponse getAll() {
        SaborResponse respuesta = new SaborResponse();
        respuesta.setSaboresTrabajados(
                saborRepository.findAll()
        );
        return respuesta;
    }

    @Override
    public SaborResponse save(Sabor sabor) throws Exception {
        if (sabor.getNombre().isEmpty()){
            throw new Exception();
        }
        SaborResponse respuesta = new SaborResponse();

        respuesta.setSaborTrabajado(
                saborRepository.save(sabor)
        );
        return respuesta;
    }

    @Override
    public SaborResponse savePorMonton(List<Sabor> sabores) throws Exception {
        if (sabores == null){
            throw new Exception();
        }
        SaborResponse respuesta = new SaborResponse();

        respuesta.setSaboresTrabajados(
                saborRepository.saveAll(sabores)
        );
        return respuesta;
    }

    @Override
    public SaborResponse update(Sabor sabor) throws Exception {
        if (!saborRepository.existsById(sabor.getId()) | sabor.getNombre().isEmpty()){
            throw new Exception();
        }
        SaborResponse respuesta = new SaborResponse();

        respuesta.setSaborTrabajado(
                saborRepository.save(sabor)
        );
        return respuesta;
    }

    @Override
    public SaborResponse delete(Sabor sabor) throws Exception {
        if (!saborRepository.existsById(sabor.getId())){
            throw new Exception();
        }
        SaborResponse respuesta = new SaborResponse();
        if (saborRepository.existsById(sabor.getId())){
            saborRepository.deleteById(sabor.getId());
            respuesta.setSaborTrabajado(sabor);
        }
        return respuesta;
    }
}
