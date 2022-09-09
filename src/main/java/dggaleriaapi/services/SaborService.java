package dggaleriaapi.services;

import dggaleriaapi.models.Sabor;
import dggaleriaapi.responses.SaborResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SaborService {

    SaborResponse getAll();
    SaborResponse save(Sabor sabor);
    SaborResponse savePorMonton(List<Sabor> sabores);

    SaborResponse update(Sabor sabor);
    SaborResponse delete(Sabor sabor);
}
