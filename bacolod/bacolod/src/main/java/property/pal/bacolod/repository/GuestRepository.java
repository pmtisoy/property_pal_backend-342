package property.pal.bacolod.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import property.pal.bacolod.model.Guest;

public interface GuestRepository extends JpaRepository<Guest, Integer> {
}
