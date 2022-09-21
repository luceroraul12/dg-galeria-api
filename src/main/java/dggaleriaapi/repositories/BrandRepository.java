package dggaleriaapi.repositories;

import dggaleriaapi.models.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    @Query("select (count(b) > 0) from Brand b where upper(b.brandName) = upper(:brandName)")
    boolean existsByBrandName(@Param("brandName") String brandName);


}