package dggaleriaapi.repositories;

import dggaleriaapi.models.SaborFormateado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SaborFormateadoRepository extends JpaRepository<SaborFormateado, Long> {
    List<SaborFormateado> findBySaborAsociado_Id(Long id);

//    @Query("select (count(s) > 0) from SaborFormateado s where s.drinkContainer.id = :id and s.saborAsociado.id = :id1")
//    boolean existsByDrinkContainer_IdAndSaborAsociado_Id(@Param("id") Long idDrinkContainer, @Param("id1") Long idSaborAsociado);

    @Query("select (count(s) > 0) from SaborFormateado s where s.drinkContainer.id = :id and s.saborAsociado.id = :id1")
    boolean existsByDrinkContainer_IdAndSaborAsociado_Id(@Param("id") Long idDrinkContainer, @Param("id1") Long idSaborAsociado);



    @Query("select s from SaborFormateado s where s.saborAsociado.brand.id = :id")
    List<SaborFormateado> getAllByIdBrand(@Param("id") Long id);



}