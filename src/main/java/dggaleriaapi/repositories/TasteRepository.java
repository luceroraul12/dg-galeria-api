package dggaleriaapi.repositories;

import dggaleriaapi.models.Taste;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TasteRepository extends JpaRepository<Taste, Long> {
}