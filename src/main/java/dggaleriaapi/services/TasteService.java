package dggaleriaapi.services;

import dggaleriaapi.models.Taste;
import dggaleriaapi.responses.TasteResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TasteService {

    TasteResponse getAll();
    TasteResponse save(Taste taste) throws Exception;
    TasteResponse savePorMonton(List<Taste> tastees) throws Exception;

    TasteResponse update(Taste taste) throws Exception;
    TasteResponse delete(Taste taste) throws Exception;
}
