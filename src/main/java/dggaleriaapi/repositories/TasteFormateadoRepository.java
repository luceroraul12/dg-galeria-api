package dggaleriaapi.repositories;

import dggaleriaapi.models.TasteFormateado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TasteFormateadoRepository extends JpaRepository<TasteFormateado, Long> {
    List<TasteFormateado> findByBrandedTaste_Id(Long id);

//    @Query("select (count(s) > 0) from TasteFormateado s where s.drinkContainer.id = :id and s.brandedTaste.id = :id1")
//    boolean existsByDrinkContainer_IdAndBrandedTaste_Id(@Param("id") Long idDrinkContainer, @Param("id1") Long idBrandedTaste);

    @Query("select (count(s) > 0) from TasteFormateado s where s.drinkContainer.id = :id and s.brandedTaste.id = :id1")
    boolean existsByDrinkContainer_IdAndBrandedTaste_Id(@Param("id") Long idDrinkContainer, @Param("id1") Long idBrandedTaste);



    @Query("select s from TasteFormateado s where s.brandedTaste.brand.id = :id")
    List<TasteFormateado> getAllByIdBrand(@Param("id") Long id);



}