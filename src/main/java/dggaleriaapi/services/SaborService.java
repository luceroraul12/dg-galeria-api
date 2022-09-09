package dggaleriaapi.services;

import dggaleriaapi.models.Sabor;
import dggaleriaapi.responses.SaborResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SaborService {

    SaborResponse getAll();
    SaborResponse save(Sabor sabor) throws Exception;
    SaborResponse savePorMonton(List<Sabor> sabores) throws Exception;

    SaborResponse update(Sabor sabor) throws Exception;
    SaborResponse delete(Sabor sabor) throws Exception;
}
