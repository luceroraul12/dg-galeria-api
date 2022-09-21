package dggaleriaapi.repositories;

import dggaleriaapi.models.Taste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TasteRepository extends JpaRepository<Taste, Long> {
    @Query("select (count(t) > 0) from Taste t where upper(t.tasteName) = upper(:tasteName)")
    boolean existsByTasteName(@Param("tasteName") String tasteName);


}