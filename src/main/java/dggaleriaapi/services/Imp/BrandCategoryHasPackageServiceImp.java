package dggaleriaapi.services.Imp;

import dggaleriaapi.models.Package;
import dggaleriaapi.repositories.BrandCategoryHasPackageRepository;
import dggaleriaapi.services.BrandCategoryHasPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandCategoryHasPackageServiceImp implements BrandCategoryHasPackageService {

    @Autowired
    private BrandCategoryHasPackageRepository repository;
    @Override
    public List<Package> getPackagesByBrandId(Long brandId) {
        return repository.getPackagesByBrandId(brandId);
    }
}
