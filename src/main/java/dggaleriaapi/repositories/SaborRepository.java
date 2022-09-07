package dggaleriaapi.repositories;

import dggaleriaapi.models.Sabor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SaborRepository extends JpaRepository<Sabor, Long> {
    List<Sabor> findByMarca_Id(Long id);

    @Query("select s from Sabor s where s.marca.id = ?1 and s.estadoStock = true")
    List<Sabor> getAllByIdMacaryStock(Long id);

}