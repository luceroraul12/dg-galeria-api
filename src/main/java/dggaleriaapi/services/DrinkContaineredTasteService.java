package dggaleriaapi.services;

import dggaleriaapi.models.DrinkContaineredTaste;
import dggaleriaapi.responses.DrinkContaineredTasteResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DrinkContaineredTasteService {

    DrinkContaineredTasteResponse getAll();

    DrinkContaineredTasteResponse getByBrandedTasteId(DrinkContaineredTaste drinkContaineredTaste);

    DrinkContaineredTasteResponse getAllByIdBrand(Long idBrand);

    DrinkContaineredTasteResponse save(DrinkContaineredTaste drinkContaineredTaste) throws Exception;

    DrinkContaineredTasteResponse saveInicial(DrinkContaineredTaste drinkContaineredTaste) throws Exception;

    DrinkContaineredTasteResponse savePorMonton(List<DrinkContaineredTaste> tasteesFormateados) throws Exception;

    DrinkContaineredTasteResponse savePorMontonInicial(List<DrinkContaineredTaste> tasteesFormateados) throws Exception;

    DrinkContaineredTasteResponse update(DrinkContaineredTaste drinkContaineredTaste) throws Exception;

    DrinkContaineredTasteResponse delete(DrinkContaineredTaste drinkContaineredTaste) throws Exception;
}
