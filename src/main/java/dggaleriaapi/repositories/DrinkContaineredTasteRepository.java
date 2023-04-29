package dggaleriaapi.repositories;

import dggaleriaapi.models.DrinkContaineredTaste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DrinkContaineredTasteRepository extends JpaRepository<DrinkContaineredTaste, Long> {
    List<DrinkContaineredTaste> findByBrandHasTaste_Id(Long id);

    @Query("select (count(s) > 0) from DrinkContaineredTaste s where s.drinkContainer.id = :id and s.brandHasTaste.id = :id1")
    boolean existsByDrinkContainer_IdAndBrandedTaste_Id(@Param("id") Long idDrinkContainer, @Param("id1") Long idBrandedTaste);

    @Query("""
            select (count(d) > 0) from DrinkContaineredTaste d
            where d.drinkContainer.id = :id1 and d.brandHasTaste.id = :id2 """)
    boolean isExistWithoutChanges( @Param("id1") Long idDrinkContainer, @Param("id2") Long idBrandedTaste);

    @Transactional
    @Modifying
    @Query("update DrinkContaineredTaste d set d.isStocked = :isStocked where d.id = :id")
    int updateIsStockedById(@Param("isStocked") Boolean isStocked, @Param("id") Long id);




    @Query("select s from DrinkContaineredTaste s where s.brandHasTaste.brand.id = :id")
    List<DrinkContaineredTaste> getAllByIdBrand(@Param("id") Long id);



}