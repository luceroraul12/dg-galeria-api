package dggaleriaapi.services;

import dggaleriaapi.models.BrandedTaste;
import dggaleriaapi.responses.BrandedTasteResponse;

import java.util.List;

public interface BrandedTasteService {

    BrandedTasteResponse getAll();
    BrandedTasteResponse getAllByIdBrand(Long idBrand) throws Exception;
    BrandedTasteResponse save(BrandedTaste brandedTaste) throws Exception;
    BrandedTasteResponse savePorMonton(List<BrandedTaste> tasteesAsociados) throws Exception;

    BrandedTasteResponse update(BrandedTaste brandedTaste) throws Exception;

    BrandedTasteResponse delete(BrandedTaste brandedTaste) throws Exception;

}
