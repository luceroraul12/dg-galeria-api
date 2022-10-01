package dggaleriaapi.repositories;

import dggaleriaapi.models.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    @Query("select (count(b) > 0) from Brand b where upper(b.brandName) = upper(:brandName)")
    boolean existsByBrandName(@Param("brandName") String brandName);

    @Transactional
    @Modifying
    @Query("update Brand b set b.isStocked = :isStocked where b.id = :id")
    void updateStockState(@Param("isStocked") Boolean isStocked, @Param("id") Long id);




}