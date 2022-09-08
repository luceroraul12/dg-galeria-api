package dggaleriaapi.repositories;

import dggaleriaapi.models.SaborAsociado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SaborAsociadoRepository extends JpaRepository<SaborAsociado, Long> {
    List<SaborAsociado> findByMarca_Id(Long id);

    @Query("select s from SaborAsociado s where s.marca.id = ?1 and s.estadoStock = true")
    List<SaborAsociado> getAllByIdMacaryStock(Long id);

}