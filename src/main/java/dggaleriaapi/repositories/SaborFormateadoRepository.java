package dggaleriaapi.repositories;

import dggaleriaapi.models.SaborFormateado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaborFormateadoRepository extends JpaRepository<SaborFormateado, Long> {
    List<SaborFormateado> findBySaborAsociado_Id(Long id);


}