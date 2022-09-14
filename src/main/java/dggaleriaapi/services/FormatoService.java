package dggaleriaapi.services;

import dggaleriaapi.models.DrinkContainer;
import dggaleriaapi.responses.FormatoResponse;
import dggaleriaapi.responses.StockDataResponse;
import org.springframework.stereotype.Service;

@Service
public interface FormatoService {

    StockDataResponse getAllFormatos();
    FormatoResponse saveFormato(String tipo) throws Exception;

    FormatoResponse updateFormato(DrinkContainer drinkContainer) throws Exception;

    FormatoResponse deleteFormato(Long idFormato) throws Exception;
}
