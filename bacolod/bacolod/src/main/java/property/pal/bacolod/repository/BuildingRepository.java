package property.pal.bacolod.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import property.pal.bacolod.model.Building;

public interface BuildingRepository extends JpaRepository<Building, Integer> {
}
