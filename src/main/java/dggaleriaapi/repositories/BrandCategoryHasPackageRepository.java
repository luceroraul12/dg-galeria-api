package dggaleriaapi.repositories;

import dggaleriaapi.models.BrandCategoryHasPackage;
import dggaleriaapi.models.Package;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BrandCategoryHasPackageRepository extends JpaRepository<BrandCategoryHasPackage, Long> {
    @Query("SELECT p " +
            "FROM BrandCategoryHasPackage bchp " +
            "   INNER JOIN bchp.aPackage p " +
            "   INNER JOIN bchp.brandCategory bc " +
            "   INNER JOIN Brand b ON bc.id = b.brandCategory.id " +
            "WHERE b.id = :brandId")
    List<Package> getPackagesByBrandId(@Param("brandId") Long brandId);
}
