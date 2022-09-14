package dggaleriaapi.repositories;

import dggaleriaapi.models.DrinkContainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormatoRepository extends JpaRepository<DrinkContainer, Long> {
}