package dggaleriaapi.services;

import dggaleriaapi.models.Package;

import java.util.List;

public interface BrandCategoryHasPackageService {
    List<Package> getPackagesByBrandId(Long brandId);
}
