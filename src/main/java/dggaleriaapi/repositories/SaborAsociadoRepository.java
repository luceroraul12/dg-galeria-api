package dggaleriaapi.repositories;

import dggaleriaapi.models.SaborAsociado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SaborAsociadoRepository extends JpaRepository<SaborAsociado, Long> {
    List<SaborAsociado> findByMarca_Id(Long id);

}