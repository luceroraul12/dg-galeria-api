package dggaleriaapi.repositories;

import dggaleriaapi.models.BrandedTaste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BrandedTasteRepository extends JpaRepository<BrandedTaste, Long> {
    List<BrandedTaste> findByBrand_Id(Long id);

    @Query("select (count(s) > 0) from BrandedTaste s where s.brand.id = :id")
    boolean existByIdBrand(@Param("id") Long id);

    @Query("select (count(s) > 0) from BrandedTaste s where s.taste.id = :id")
    boolean existByIdTaste(@Param("id") Long id);

    @Query("select (count(s) > 0) from BrandedTaste s where s.brand.id = :id and s.taste.id = :id1")
    boolean existsByBrand_IdAndTaste_Id(@Param("id") Long idBrand, @Param("id1") Long idTaste);

    @Query("""
            select (count(b) > 0) from BrandedTaste b
            where b.id = ?1 and b.brand.id = ?2 and b.taste.id = ?3 and b.isStocked = ?4""")
    boolean isExistWithoutChanges(Long idBrandedTaste, Long idBrand, Long idTaste, Boolean isStocked);









}