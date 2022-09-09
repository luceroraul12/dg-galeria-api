package dggaleriaapi.repositories;

import dggaleriaapi.models.SaborAsociado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SaborAsociadoRepository extends JpaRepository<SaborAsociado, Long> {
    List<SaborAsociado> findByMarca_Id(Long id);

    @Query("select (count(s) > 0) from SaborAsociado s where s.marca.id = :id")
    boolean existByIdMarca(@Param("id") Long id);

    @Query("select (count(s) > 0) from SaborAsociado s where s.sabor.id = :id")
    boolean existByIdSabor(@Param("id") Long id);

    @Query("select (count(s) > 0) from SaborAsociado s where s.marca.id = :id and s.sabor.id = :id1")
    boolean existsByMarca_IdAndSabor_Id(@Param("id") Long idMarca, @Param("id1") Long idSabor);








}