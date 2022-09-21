package dggaleriaapi.repositories;

import dggaleriaapi.models.DrinkContainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DrinkContainerRepository extends JpaRepository<DrinkContainer, Long> {
    @Query("select (count(d) > 0) from DrinkContainer d where d.containerName = :containerName")
    boolean isExistByName(@Param("containerName") Integer containerName);





}