package dggaleriaapi.services.Imp;

import dggaleriaapi.models.Taste;
import dggaleriaapi.repositories.TasteRepository;
import dggaleriaapi.responses.StockDataResponse;
import dggaleriaapi.services.TasteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TasteServiceImp implements TasteService {

    @Autowired
    TasteRepository tasteRepository;

    @Override
    public StockDataResponse<Taste> getAll() {
        StockDataResponse<Taste> respuesta = new StockDataResponse<Taste>();
        respuesta.setStockDataResult(
                tasteRepository.findAll()
        );
        return respuesta;
    }

    @Override
    public StockDataResponse<Taste> save(Taste taste) throws Exception {
        if (taste.getTasteName().isEmpty()
            | tasteRepository.existsByTasteName(taste.getTasteName())){
            throw new Exception();
        }
        StockDataResponse<Taste> respuesta = new StockDataResponse<Taste>();
        respuesta.setStockDataResult(
                List.of(tasteRepository.save(taste))
        );
        return respuesta;
    }

    @Override
    public StockDataResponse<Taste> savePorMonton(List<Taste> tastees) throws Exception {
        if (tastees == null){
            throw new Exception();
        }
        StockDataResponse<Taste> respuesta = new StockDataResponse<Taste>();
        respuesta.setStockDataResult(
                tasteRepository.saveAll(tastees)
        );
        return respuesta;
    }

    @Override
    public StockDataResponse<Taste> update(Taste taste) throws Exception {
        if (!tasteRepository.existsById(taste.getId()) | taste.getTasteName().isEmpty()){
            throw new Exception();
        }
        StockDataResponse<Taste> respuesta = new StockDataResponse<Taste>();
        respuesta.setStockDataResult(
                List.of(tasteRepository.save(taste))
        );
        return respuesta;
    }

    @Override
    public StockDataResponse<Taste> delete(Taste taste) throws Exception {
        if (!tasteRepository.existsById(taste.getId())){
            throw new Exception();
        }
        StockDataResponse<Taste> respuesta = new StockDataResponse<Taste>();
        tasteRepository.delete(taste);

        respuesta.setStockDataResult(List.of(taste));
        return respuesta;
    }
}
