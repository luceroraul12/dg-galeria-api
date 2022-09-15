package dggaleriaapi.services;

import dggaleriaapi.models.Taste;
import dggaleriaapi.responses.StockDataResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TasteService {

    StockDataResponse<Taste> getAll();
    StockDataResponse<Taste> save(Taste taste) throws Exception;
    StockDataResponse<Taste> savePorMonton(List<Taste> tastees) throws Exception;

    StockDataResponse<Taste> update(Taste taste) throws Exception;
    StockDataResponse<Taste> delete(Taste taste) throws Exception;
}
